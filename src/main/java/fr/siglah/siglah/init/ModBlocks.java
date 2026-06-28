package fr.siglah.siglah.init;

import fr.siglah.siglah.Siglah;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static Block GIVRE_FER_ORE;
    public static Block SVARTHARN_ORE;
    public static Block LARME_YMIR_ORE;

    public static void registerModBlocks() {
        GIVRE_FER_ORE = registerBlock("givre_fer_ore", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE)));
        SVARTHARN_ORE = registerBlock("svartharn_ore", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).hardness(5.0f)));
        LARME_YMIR_ORE = registerBlock("larme_ymir_ore", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).hardness(10.0f)));
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Siglah.MOD_ID, name), block);
    }
}