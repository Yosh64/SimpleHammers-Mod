package net.withrage.simplehammers.tags;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.withrage.simplehammers.SimpleHammers;

public class ModTags {
    public static class Blocks{
        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(SimpleHammers.MOD_ID,name));
        }

        public static final TagKey<Block> HAMMER_MINEABLE = createTag("hammer_mineable");
    }
}
