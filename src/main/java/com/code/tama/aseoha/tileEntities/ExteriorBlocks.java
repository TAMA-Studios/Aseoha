/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.tileEntities;

import static com.code.tama.aseoha.aseoha.MODID;
import static com.code.tama.aseoha.tileEntities.TileRegistry.RTD_9_EXTERIOR_TILE;

import net.tardis.mod.block.ExteriorBlock;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExteriorBlocks {
	/** Block deferred register for exteriors */
	public static final DeferredRegister<Block> EXTERIOR_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			MODID);

	public static final RegistryObject<ExteriorBlock> RTD_9_EXTERIOR_BLOCK = ExteriorBlocks.EXTERIOR_BLOCKS
			.register("exterior/rtd_9", () -> new ExteriorBlock(RTD_9_EXTERIOR_TILE));

	public static final RegistryObject<ExteriorBlock> WARDROBE_EXTERIOR_BLOCK = ExteriorBlocks.EXTERIOR_BLOCKS
			.register("exterior/wardrobe", () -> new ExteriorBlock(TileRegistry.WARDROBE_EXTERIOR_TILE));

	public static final RegistryObject<ExteriorBlock> CAPALDI_EXTERIOR_BLOCK = ExteriorBlocks.EXTERIOR_BLOCKS
			.register("exterior/capaldi", () -> new ExteriorBlock(TileRegistry.CAPALDI_EXTERIOR_TILE));

	public static final RegistryObject<ExteriorBlock> HARTNELL112_EXTERIOR_BLOCK = ExteriorBlocks.EXTERIOR_BLOCKS
			.register("exterior/hartnell112", () -> new ExteriorBlock(TileRegistry.HARTNELL112_EXTERIOR_TILE));
}
