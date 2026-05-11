package net.withrage.simplehammers.items.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.withrage.simplehammers.SimpleHammers;
import net.withrage.simplehammers.config.SimpleHammersConfig;

public class ModItems {

    public static final Item COPPER_HAMMER = registerHammer("copper_hammer", ModToolMaterial.COPPER, 1, -2.8F, SimpleHammersConfig.copperDurability, false);
    public static final Item GOLDEN_HAMMER = registerHammer("golden_hammer", ToolMaterials.GOLD, 1, -2.8F, ToolMaterials.GOLD.getDurability(), false);
    public static final Item IRON_HAMMER = registerHammer("iron_hammer", ToolMaterials.IRON, 2, -2.8F, ToolMaterials.IRON.getDurability(), false);
    public static final Item DIAMOND_HAMMER = registerHammer("diamond_hammer", ToolMaterials.DIAMOND, 3, -2.8F, ToolMaterials.DIAMOND.getDurability(), false);
    public static final Item NETHERITE_HAMMER = registerHammer("netherite_hammer", ToolMaterials.NETHERITE, 4, -2.8F, ToolMaterials.NETHERITE.getDurability(), true);

    public static final Item HAMMER_ADV_TROPHY = registerItem("all_hammers", new Item(new Item.Settings()));

    private static Item registerHammer(String name,
                                       ToolMaterial material,
                                       int attackDamage,
                                       float attackSpeed,
                                       int durability,
                                       boolean fireproof) {

        Item.Settings settings = new Item.Settings().maxCount(1);

        if (fireproof) settings.fireproof();

        return Registry.register(Registries.ITEM,
                Identifier.of("simplehammers", name),
                new HammerItem(material, attackDamage, attackSpeed, durability, settings));
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SimpleHammers.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SimpleHammers.LOGGER.info("Registering Mod Items for " + SimpleHammers.MOD_ID);
    }
}
