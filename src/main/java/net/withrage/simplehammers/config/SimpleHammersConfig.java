package net.withrage.simplehammers.config;

import net.fabricmc.loader.api.FabricLoader;
import org.tomlj.Toml;
import org.tomlj.TomlParseResult;

import java.nio.file.Files;
import java.nio.file.Path;

public class SimpleHammersConfig {
    private static final Path PATH = FabricLoader.getInstance().getConfigDir().resolve("simplehammers.toml");

    public static boolean sneakMines1x1 = true;

    public static int copperDurability = 190;

    public static void load() {
        try {
            if (!Files.exists(PATH)) {
                writeDefaultFile();
                return;
            }

            TomlParseResult toml = Toml.parse(Files.readString(PATH));

            if (toml.hasErrors()) {
                writeDefaultFile();
                return;
            }

            sneakMines1x1 = getBoolean(toml, "general.sneakMines1x1", sneakMines1x1);

            copperDurability = getInt(toml, "durability.copper", copperDurability);

        } catch (Exception e) {
            try { writeDefaultFile(); } catch (Exception ignored) {}
        }
    }

    private static boolean getBoolean(TomlParseResult toml, String key, boolean def) {
        Boolean v = toml.getBoolean(key);
        return v != null ? v : def;
    }

    private static int getInt(TomlParseResult toml, String key, int def) {
        Long v = toml.getLong(key);
        if (v == null) return def;
        if (v > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (v < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return v.intValue();
    }

    private static void writeDefaultFile() throws Exception {
        Files.createDirectories(PATH.getParent());

        String content = ""
                + "# ================================\n"
                + "# Simple Hammers Configuration\n"
                + "# ================================\n\n"
                + "[general]\n"
                + "# If true, sneaking mines only 1x1 instead of 3x3.\n"
                + "sneakMines1x1 = " + sneakMines1x1 + "\n\n"
                + "[durability]\n"
                + "# You can change the durability for copper hammer here.\n"
                + "copper = " + copperDurability + "\n";

        Files.writeString(PATH, content);
    }
}
