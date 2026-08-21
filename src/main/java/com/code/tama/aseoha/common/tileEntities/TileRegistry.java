/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.common.tileEntities;

import com.code.tama.aseoha.common.blocks.ABlocks;
import com.code.tama.aseoha.common.tileEntities.Console.*;
import com.code.tama.aseoha.common.tileEntities.Exterior.*;
import com.code.tama.aseoha.common.tileEntities.Exterior.CapaldiExteriorTile;
import com.code.tama.aseoha.common.tileEntities.Exterior.Hartnell112ExteriorTile;
import com.code.tama.aseoha.common.tileEntities.Exterior.RTD9ExteriorTile;
import com.code.tama.aseoha.common.tileEntities.Exterior.WardrobeExteriorTile;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import com.code.tama.aseoha.AseohaMod;

public class TileRegistry {
	public static final DeferredRegister<BlockEntityType<?>> TYPES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AseohaMod.MODID);

	public static final DeferredRegister<BlockEntityType<?>> UNREGISTERED = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AseohaMod.MODID);

	// Exteriors
	public static final RegistryObject<BlockEntityType<WardrobeExteriorTile>> WARDROBE_EXTERIOR_TILE = TYPES.register(
			"exterior/wardrobe", () -> create(WardrobeExteriorTile::new, ExteriorBlocks.WARDROBE_EXTERIOR_BLOCK.get()));

	public static final RegistryObject<BlockEntityType<RTD9ExteriorTile>> RTD_9_EXTERIOR_TILE = TYPES
			.register("exterior/rtd_9", () -> create(RTD9ExteriorTile::new, ExteriorBlocks.RTD_9_EXTERIOR_BLOCK.get()));

	public static final RegistryObject<BlockEntityType<CapaldiExteriorTile>> CAPALDI_EXTERIOR_TILE = TYPES.register(
			"exterior/capaldi", () -> create(CapaldiExteriorTile::new, ExteriorBlocks.CAPALDI_EXTERIOR_BLOCK.get()));

	public static final RegistryObject<BlockEntityType<Hartnell112ExteriorTile>> HARTNELL112_EXTERIOR_TILE = TYPES
			.register("exterior/hartnell112",
					() -> create(Hartnell112ExteriorTile::new, ExteriorBlocks.HARTNELL112_EXTERIOR_BLOCK.get()));

	// Consoles
	public static final RegistryObject<BlockEntityType<CopperConsoleTile>> COPPER_CONSOLE_TILE = TYPES
			.register("console/copper", () -> create(CopperConsoleTile::new, ConsoleBlocks.COPPER_CONSOLE_BLOCK.get()));

	public static final RegistryObject<BlockEntityType<BaseConsoleTile<?>>> STEAM_FOURTEEN_CONSOLE_TILE = TYPES
			.register("console/steam_fourteen",
					() -> create(
							(pos, state) -> new BaseConsoleTile<>(pos, state, TileRegistry.STEAM_FOURTEEN_CONSOLE_TILE),
							ConsoleBlocks.STEAM_CONSOLE_BLOCK_FOURTEEN.get()));

	public static final RegistryObject<BlockEntityType<BaseConsoleTile<?>>> STEAM_SIXTEEN_CONSOLE_TILE = TYPES.register(
			"console/steam_sixteen",
			() -> create((pos, state) -> new BaseConsoleTile<>(pos, state, TileRegistry.STEAM_SIXTEEN_CONSOLE_TILE),
					ConsoleBlocks.STEAM_CONSOLE_BLOCK_SIXTEEN.get()));

	public static final RegistryObject<BlockEntityType<BaseConsoleTile<?>>> BATTLE_CONSOLE_TILE = TYPES.register(
			"console/battle",
			() -> create((pos, state) -> new BaseConsoleTile<>(pos, state, TileRegistry.BATTLE_CONSOLE_TILE),
					ConsoleBlocks.BATTLE_CONSOLE_BLOCK.get()));

	public static final RegistryObject<BlockEntityType<ToyotaConsoleTile>> TOYOTA_CONSOLE_TILE = TYPES
			.register("console/toyota", () -> create(ToyotaConsoleTile::new, ConsoleBlocks.TOYOTA_CONSOLE_BLOCK.get()));

	public static final RegistryObject<BlockEntityType<BrackolinConsoleTile>> BRACKOLIN_CONSOLE_TILE = TYPES.register(
			"console/brackolin", () -> create(BrackolinConsoleTile::new, ConsoleBlocks.BRACKOLIN_CONSOLE_BLOCK.get()));

	public static final RegistryObject<BlockEntityType<TokamakConsoleTile>> TOKAMAK_CONSOLE_TILE = TYPES.register(
			"console/tokamak", () -> create(TokamakConsoleTile::new, ConsoleBlocks.TOKAMAK_CONSOLE_BLOCK.get()));

	// public static final RegistryObject<BlockEntityType<BaseConsoleTile<?>>>
	// HARTNELL_CONSOLE_TILE =
	// TYPES.register(
	// "console/hartnell",
	// () -> create(
	// (pos, state) -> new BaseConsoleTile<>(pos, state,
	// TileRegistry.HARTNELL_CONSOLE_TILE),
	// ConsoleBlocks.HARTNELL_CONSOLE_BLOCK.get()));

	public static final RegistryObject<BlockEntityType<CoralConsoleTile>> CORAL_CONSOLE_TILE = TYPES
			.register("console/coral", () -> create(CoralConsoleTile::new, ConsoleBlocks.CORAL_CONSOLE_BLOCK.get()));

	public static final RegistryObject<BlockEntityType<WhirlygigTile>> WHIRLYGIG_TILE = TYPES
			.register("tiles/whirlygig", () -> create(WhirlygigTile::new, ABlocks.WHIRLYGIG.get()));

	public static final RegistryObject<BlockEntityType<VortexDetectorTile>> VORTEX_DETECTOR = UNREGISTERED
			.register("tiles/vortex_detector", () -> create(VortexDetectorTile::new, ABlocks.VORTEX_DETECTOR.get()));

	@Contract("_, _ -> new")
	public static <T extends BlockEntity> @NotNull BlockEntityType<T> create(
			BlockEntityType.BlockEntitySupplier<T> factory, Block... blocks) {
		return BlockEntityType.Builder.of(factory, blocks).build(null);
	}
}
