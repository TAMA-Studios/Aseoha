/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.capabilities.Interfaces;

import java.util.Optional;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.INBTSerializable;

public interface IControlDiscCapability extends INBTSerializable<CompoundTag> {
	void setDiscLevel(@Nullable ResourceKey<Level> var1);

	void setDiscBlockPos(@Nullable BlockPos var1);

	Optional<ResourceKey<Level>> getDiscLevel();

	Optional<BlockPos> getDiscBlockPos();
}
