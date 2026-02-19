/* (C) TAMA Studios 2025 */
package com.code.tama.triggerapi.boti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mojang.blaze3d.vertex.VertexBuffer;
import lombok.Getter;

import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import com.code.tama.triggerapi.boti.client.BotiChunkContainer;
import com.code.tama.triggerapi.helpers.rendering.FBOHelper;
import com.code.tama.triggerapi.tileEntities.TickingTile;

/** Other tiles implement this to get data for portals */
@OnlyIn(Dist.CLIENT)
public abstract class AbstractPortalTile extends TickingTile {
	@OnlyIn(Dist.CLIENT)
	private FBOHelper FBOContainer;

	private final List<Integer> recievedPackets = new ArrayList<>();

	@OnlyIn(Dist.CLIENT)
	public VertexBuffer MODEL_VBO;

	public Vec3 SkyColor = Vec3.ZERO;

	@OnlyIn(Dist.CLIENT)
	public Map<BlockPos, BlockEntity> blockEntities = new HashMap<>();

	@OnlyIn(Dist.CLIENT)
	public Map<BakedModel, Integer> chunkModels = new HashMap<>();

	@OnlyIn(Dist.CLIENT)
	public List<BotiChunkContainer> containers = new ArrayList<>();

	public ResourceKey<DimensionType> dimensionTypeId;

	public long lastRequestTime = 0;

	public long lastUpdateTime = 0;

	@Getter
	public ResourceKey<Level> targetLevel;

	@Getter
	public BlockPos targetPos = new BlockPos(0, 128, 0);

	public float targetY = 0;

	public DimensionType type;

	public AbstractPortalTile(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
		super(p_155228_, p_155229_, p_155230_);
	}

	public FBOHelper getFBOContainer() {
		return this.FBOContainer == null ? this.FBOContainer = new FBOHelper() : this.FBOContainer;
	}

	public void setTargetLevel(ResourceKey<Level> levelKey, BlockPos targetPos, float yRot, boolean markDirty) {
		if (this.level == null)
			return;
	}

	@Override
	public void tick() {
	}

	@OnlyIn(Dist.CLIENT)
	public void updateChunkDataFromServer(List<BotiChunkContainer> chunkData, int packetIndex, int totalPackets) {

	}
}
