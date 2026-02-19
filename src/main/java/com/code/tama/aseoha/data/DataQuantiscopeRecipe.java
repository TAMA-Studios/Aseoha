/* (C) TAMA Studios 2025 */
package com.code.tama.aseoha.data;

import net.minecraft.resources.ResourceLocation;

public record DataQuantiscopeRecipe(ResourceLocation item, ResourceLocation structure) {
	@Override
	public String toString() {
		return "DataQuantiscopeRecipe{" + "item='" + item + '\'' + ", structure=" + structure + '}';
	}
}
