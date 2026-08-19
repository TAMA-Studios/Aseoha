/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.common.registries;

import static com.code.tama.aseoha.AseohaMod.MODID;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ASounds {
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister
			.create(ForgeRegistries.SOUND_EVENTS, MODID);

	public static final RegistryObject<SoundEvent> LAVA_CHICKEN = SOUND_EVENTS.register("lava_chicken", () -> SoundEvent
			.createVariableRangeEvent(new net.minecraft.resources.ResourceLocation(MODID, "lava_chicken")));

	public static final RegistryObject<SoundEvent> LOW_ARTRON_TAKEOFF = SOUND_EVENTS.register("distorted_takeoff",
			() -> setupSound("distorted_takeoff"));
	public static final RegistryObject<SoundEvent> LOW_ARTRON_LAND = SOUND_EVENTS.register("distorted_land",
			() -> setupSound("distorted_land"));
	public static final RegistryObject<SoundEvent> MAJESTIC_TALE = SOUND_EVENTS.register("majestic_tale",
			() -> setupSound("majestic_tale"));
	public static final RegistryObject<SoundEvent> CYBER_ARMY = SOUND_EVENTS.register("cyber_army",
			() -> setupSound("cyber_army"));
	public static final RegistryObject<SoundEvent> CYBERMEN = SOUND_EVENTS.register("cybermen",
			() -> setupSound("cybermen"));
	public static final RegistryObject<SoundEvent> IDIOT_BOX = SOUND_EVENTS.register("idiot_box",
			() -> setupSound("idiot_box"));

	public static final RegistryObject<SoundEvent> THIS_IS_GALLIFREY = SOUND_EVENTS.register("this_is_gallifrey",
			() -> setupSound("thisisgallifrey"));

	public static final RegistryObject<SoundEvent> WORDS_WIN_WARS = SOUND_EVENTS.register("words_win_wars",
			() -> setupSound("wordswinwars"));

	public static final RegistryObject<SoundEvent> STRANGECREATURE = SOUND_EVENTS.register("strangecreature",
			() -> setupSound("strangecreatures"));

	public static final RegistryObject<SoundEvent> SHEPHERDS_BOY = SOUND_EVENTS.register("shepherds_boy",
			() -> setupSound("shepherdsboy"));

	public static final RegistryObject<SoundEvent> WESTMINSTER = SOUND_EVENTS.register("westminster",
			() -> setupSound("westminster"));

	public static final RegistryObject<SoundEvent> IAMTHEDOCTOR = SOUND_EVENTS.register("iamthedoctor",
			() -> setupSound("iamthedoctor"));

	public static final RegistryObject<SoundEvent> THEMADMAN = SOUND_EVENTS.register("themadman",
			() -> setupSound("themadman"));

	public static final RegistryObject<SoundEvent> MADMANMUSICBOX = SOUND_EVENTS.register("madmanmusicbox",
			() -> setupSound("madmanmusicbox"));

	public static final RegistryObject<SoundEvent> AFFIRMATIVE_MASTER = SOUND_EVENTS.register("affirmative_master",
			() -> setupSound("affirmative_master"));

	// public static final SoundType AZALEA = new SoundType(1.0F, 1.0F,
	// AZALEA_BREAK.get(), AZALEA_STEP.get(), AZALEA_PLACE.get(), AZALEA_HIT.get(),
	// AZALEA_FALL.get());
	//

	// AZALEA = new SoundType(1.0F, 1.0F, SoundEvents.AZALEA_BREAK,
	// SoundEvents.AZALEA_STEP, SoundEvents.AZALEA_PLACE, SoundEvents.AZALEA_HIT,
	// SoundEvents.AZALEA_FALL);

	private static SoundEvent setupSound(String soundName) {
		return SoundEvent.createVariableRangeEvent(new ResourceLocation("aseoha", soundName));
	}
}
