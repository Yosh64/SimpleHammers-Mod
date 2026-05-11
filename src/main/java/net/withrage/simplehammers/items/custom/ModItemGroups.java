package net.withrage.simplehammers.items.custom;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.withrage.simplehammers.SimpleHammers;

public class ModItemGroups {
    public static final ItemGroup SIMPLE_HAMMERS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SimpleHammers.MOD_ID, "iron_hammer"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.simplehammers"))
                    .icon(() -> new ItemStack(ModItems.IRON_HAMMER)).entries((displayContext, entries) -> {
                        entries.add(ModItems.COPPER_HAMMER);
                        entries.add(ModItems.GOLDEN_HAMMER);
                        entries.add(ModItems.IRON_HAMMER);
                        entries.add(ModItems.DIAMOND_HAMMER);
                        entries.add(ModItems.NETHERITE_HAMMER);
                    }).build());

    public static void registerItemGroups() {
        SimpleHammers.LOGGER.info("Registering Item Groups for " + SimpleHammers.MOD_ID);
    }
}
