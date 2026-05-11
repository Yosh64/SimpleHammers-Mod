package net.withrage.simplehammers.items.custom;

import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.withrage.simplehammers.config.SimpleHammersConfig;

public class ModToolMaterial {
    public static final ToolMaterial COPPER = new ToolMaterial() {
        public int getDurability() { return SimpleHammersConfig.copperDurability; }
        public float getMiningSpeedMultiplier() { return 6.0F; }
        public float getAttackDamage() { return 1.0F; }
        public int getEnchantability() { return 10; }
        public Ingredient getRepairIngredient() { return Ingredient.ofItems(Items.COPPER_INGOT); }
        public TagKey<Block> getInverseTag() { return BlockTags.INCORRECT_FOR_IRON_TOOL; }
    };
}