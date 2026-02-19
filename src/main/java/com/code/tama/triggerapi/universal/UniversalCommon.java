/* (C) TAMA Studios 2026 */
package com.code.tama.triggerapi.universal;

import org.joml.Vector3d;
import org.joml.Vector3f;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.loading.FMLLoader;

import com.code.tama.triggerapi.TriggerAPI;

public class UniversalCommon {
	public static String modLoaderVersion() {
		return FMLLoader.versionInfo().forgeVersion();
	}
	/**
	 * @return A new ResourceLocation with namespace "minecraft"
	 */
	public static ResourceLocation newRL(String path) {
		return new ResourceLocation(path);
	}

	/**
	 * @return A new ResourceLocation
	 */
	public static ResourceLocation newRL(String namespace, String path) {
		// String arr[] = modLoaderVersion().split("\\.");
		return new ResourceLocation(path);
	}

	/**
	 * @return A new ResourceLocation with namespace being your mod id
	 */
	public static ResourceLocation modRL(String path) {
		return new ResourceLocation(TriggerAPI.getModId(), path);
	}

	public static class Pos {
		public static int x(BlockPos pos) {
			return pos.getX();
		}
		public static int y(BlockPos pos) {
			return pos.getY();
		}
		public static int z(BlockPos pos) {
			return pos.getZ();
		}

		public static double x(Vec3 pos) {
			return pos.x();
		}
		public static double y(Vec3 pos) {
			return pos.y();
		}
		public static double z(Vec3 pos) {
			return pos.z();
		}

		public static int x(Vec3i pos) {
			return pos.getZ();
		}
		public static int y(Vec3i pos) {
			return pos.getZ();
		}
		public static int z(Vec3i pos) {
			return pos.getZ();
		}

		public static float x(Vector3f pos) {
			return pos.x();
		}
		public static float y(Vector3f pos) {
			return pos.y();
		}
		public static float z(Vector3f pos) {
			return pos.z();
		}

		public static double x(Vector3d pos) {
			return pos.x();
		}
		public static double y(Vector3d pos) {
			return pos.y();
		}
		public static double z(Vector3d pos) {
			return pos.z();
		}
	}

	public static class Level {
		public BlockState getState(net.minecraft.world.level.Level world, BlockPos pos) {
			return world.getBlockState(pos);
		}
	}
}
