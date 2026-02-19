/* (C) TAMA Studios 2026 */
package com.code.tama.aseoha.entities;

import java.util.UUID;

import javax.annotation.Nullable;

import com.code.tama.aseoha.client.gui.K9Screen;
import com.code.tama.aseoha.misc.XtonicImmune;
import com.code.tama.aseoha.registries.ASounds;
import org.jetbrains.annotations.NotNull;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;

public class K9Entity extends TamableAnimal implements NeutralMob, XtonicImmune {
	// Data Sync IDs
	private static final EntityDataAccessor<Integer> DATA_COLLAR_COLOR = SynchedEntityData.defineId(K9Entity.class,
			EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> DATA_REMAINING_ANGER_TIME = SynchedEntityData
			.defineId(K9Entity.class, EntityDataSerializers.INT);

	// Constants
	private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
	@Nullable private UUID persistentAngerTarget;

	public K9Entity(EntityType<? extends K9Entity> type, Level level) {
		super(type, level);
		this.setTame(false);
		// Prevent K9 from sinking into powder snow
		this.setPathfindingMalus(BlockPathTypes.POWDER_SNOW, -1.0F);
		this.setPathfindingMalus(BlockPathTypes.DANGER_POWDER_SNOW, -1.0F);
		this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
	}

	public boolean isSensitiveToWater() {
		return true;
	}

	@Override
	protected void registerGoals() {
		// Basic Obedience
		this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
		// Combat
		this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		// Movement & Idle
		this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
		this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));

		// Targeting
		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
		this.targetSelector.addGoal(8, new ResetUniversalAngerTargetGoal<>(this, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.MAX_HEALTH, 8.0D)
				.add(Attributes.ATTACK_DAMAGE, 2.0D);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_COLLAR_COLOR, DyeColor.RED.getId());
		this.entityData.define(DATA_REMAINING_ANGER_TIME, 0);
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state) {
		// Using your custom sound
		this.playSound(ASounds.CYBERMEN.get(), 0.15F, 1.0F);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putByte("CollarColor", (byte) this.getCollarColor().getId());
		this.addPersistentAngerSaveData(tag);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		if (tag.contains("CollarColor", 99)) {
			this.setCollarColor(DyeColor.byId(tag.getInt("CollarColor")));
		}
		this.readPersistentAngerSaveData(this.level(), tag);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected float getStandingEyeHeight(@NotNull Pose pose, EntityDimensions dimensions) {
		return dimensions.height * 0.8F;
	}

	@Override
	public int getMaxHeadXRot() {
		return this.isInSittingPose() ? 20 : super.getMaxHeadXRot();
	}

	@Override
	public boolean hurt(@NotNull DamageSource source, float amount) {
		if (this.isInvulnerableTo(source)) {
			return false;
		} else {
			Entity entity = source.getEntity();
			// Stand up if attacked
			if (!this.level().isClientSide) {
				this.setOrderedToSit(false);
			}

			if ((entity instanceof LivingEntity living)) { // Increase damage done by gold tools
				if (living.getMainHandItem().getItem() instanceof TieredItem tieredItem)
					if (tieredItem.getTier().equals(Tiers.GOLD))
						amount *= 1.5f;

				if (living.getMainHandItem().getItem() instanceof PickaxeItem) // Do additional damage for pickaxes
					amount *= 1.5f;
			}

			// Reduce damage from non-players (armor plating?)
			if (entity != null && !(entity instanceof Player) && !(entity instanceof AbstractArrow)) {
				amount = (amount + 1.0F) / 2.0F;
			}

			return super.hurt(source, amount);
		}
	}

	@Override
	public boolean doHurtTarget(Entity target) {
		boolean flag = target.hurt(this.damageSources().mobAttack(this),
				(float) ((int) this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
		if (flag) {
			this.doEnchantDamageEffects(this, target);
		}
		return flag;
	}

	@Override
	public void setTame(boolean tamed) {
		super.setTame(tamed);
		if (tamed) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(40.0D);
			this.setHealth(20.0F);
			this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(8.0D);
		} else {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20.0D);
		}
	}

	@Override
	public @NotNull InteractionResult mobInteract(Player player, @NotNull InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();

		if (this.level().isClientSide) {

			Minecraft.getInstance().setScreen(new K9Screen());

			boolean flag = this.isOwnedBy(player) || this.isTame()
					|| (itemstack.is(Items.BONE) && !this.isTame() && !this.isAngry());
			return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
		} else {
			// Tamed Interaction
			if (this.isTame()) {
				if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
					// Healing
					this.heal((float) itemstack.getFoodProperties(this).getNutrition());
					if (!player.getAbilities().instabuild) {
						itemstack.shrink(1);
					}
					this.gameEvent(GameEvent.EAT, this);
					return InteractionResult.SUCCESS;
				} else if (item instanceof DyeItem) {
					// Dye Collar
					DyeItem dyeitem = (DyeItem) item;
					if (this.isOwnedBy(player)) {
						DyeColor dyecolor = dyeitem.getDyeColor();
						if (dyecolor != this.getCollarColor()) {
							this.setCollarColor(dyecolor);
							if (!player.getAbilities().instabuild) {
								itemstack.shrink(1);
							}
							return InteractionResult.SUCCESS;
						}
					}
				}

				// Sit / Stand
				InteractionResult interactionresult = super.mobInteract(player, hand);
				if ((!interactionresult.consumesAction() || this.isBaby()) && this.isOwnedBy(player)) {
					this.setOrderedToSit(!this.isOrderedToSit());
					this.jumping = false;
					this.navigation.stop();
					this.setTarget(null);
					return InteractionResult.SUCCESS;
				}
				return interactionresult;

			} else if (itemstack.is(Items.BONE) && !this.isAngry()) {
				// Taming Logic
				if (!player.getAbilities().instabuild) {
					itemstack.shrink(1);
				}

				// Vanilla Taming Randomness
				if (this.random.nextInt(3) == 0 && !ForgeEventFactory.onAnimalTame(this, player)) {
					this.tame(player);
					this.navigation.stop();
					this.setTarget(null);
					this.setOrderedToSit(true);
					this.level().broadcastEntityEvent(this, (byte) 7); // Hearts
				} else {
					this.level().broadcastEntityEvent(this, (byte) 6); // Smoke
				}
				return InteractionResult.SUCCESS;
			}

			return super.mobInteract(player, hand);
		}
	}

	// Visuals for tail rotation (can be used for antenna or tail)
	public float getTailAngle() {
		if (this.isAngry()) {
			return 1.5393804F;
		} else {
			// Tail goes up when happy/healthy
			return this.isTame()
					? (0.55F - (this.getMaxHealth() - this.getHealth()) * 0.02F) * (float) Math.PI
					: ((float) Math.PI / 5F);
		}
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return stack.getItem().equals(Items.IRON_INGOT);
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return 8;
	}

	@Override
	public int getRemainingPersistentAngerTime() {
		return this.entityData.get(DATA_REMAINING_ANGER_TIME);
	}

	@Override
	public void setRemainingPersistentAngerTime(int time) {
		this.entityData.set(DATA_REMAINING_ANGER_TIME, time);
	}

	@Override
	public void startPersistentAngerTimer() {
		this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
	}

	@Nullable @Override
	public UUID getPersistentAngerTarget() {
		return this.persistentAngerTarget;
	}

	@Override
	public void setPersistentAngerTarget(@Nullable UUID target) {
		this.persistentAngerTarget = target;
	}

	public DyeColor getCollarColor() {
		return DyeColor.byId(this.entityData.get(DATA_COLLAR_COLOR));
	}

	public void setCollarColor(DyeColor color) {
		this.entityData.set(DATA_COLLAR_COLOR, color.getId());
	}

	// K9 is a robot, it does not breed.
	@Nullable @Override
	public AgeableMob getBreedOffspring(@NotNull ServerLevel level, @NotNull AgeableMob otherParent) {
		return null;
	}

	@Override
	public boolean canMate(@NotNull Animal otherAnimal) {
		return false;
	}

	@Override
	public boolean wantsToAttack(@NotNull LivingEntity target, @NotNull LivingEntity owner) {
		if (!(target instanceof Creeper) && !(target instanceof Ghast)) {
			if (target instanceof K9Entity k9) {
				return !k9.isTame() || k9.getOwner() != owner;
			} else if (target instanceof Player && owner instanceof Player
					&& !((Player) owner).canHarmPlayer((Player) target)) {
				return false;
			} else if (target instanceof AbstractHorse && ((AbstractHorse) target).isTamed()) {
				return false;
			} else {
				return !(target instanceof TamableAnimal) || !((TamableAnimal) target).isTame();
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean canBeLeashed(@NotNull Player player) {
		return !this.isAngry() && super.canBeLeashed(player);
	}

	@Override
	public @NotNull Vec3 getLeashOffset() {
		return new Vec3(0.0D, 0.6F * this.getEyeHeight(), this.getBbWidth() * 0.4F);
	}

	public static boolean checkK9SpawnRules(EntityType<K9Entity> entityType, LevelAccessor level,
			MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return level.getBlockState(pos.below()).is(BlockTags.WOLVES_SPAWNABLE_ON) && isBrightEnoughToSpawn(level, pos);
	}
}