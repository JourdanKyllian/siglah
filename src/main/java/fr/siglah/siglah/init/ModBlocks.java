package fr.siglah.siglah.init;

import fr.siglah.siglah.Siglah;
import fr.siglah.siglah.block.TableNettoyageBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    // Déclaration des blocs
    public static final Block GIVRE_FER_ORE = registerBlock("givre_fer_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE).strength(4.0f, 6.0f)));

    public static final Block SVARTHARN_ORE = registerBlock("svartharn_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(10.0f, 10.0f)));

    public static final Block LARME_YMIR_ORE = registerBlock("larme_ymir_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(1.5f, 3.0f)));

    public static final Block TABLE_NETTOYAGE = registerBlock("table_nettoyage",
            new TableNettoyageBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(2.5f)));

    // Méthode pour enregistrer le bloc ET son item associé
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Siglah.MOD_ID, name), block);
    }

    // Enregistre l'item (pour pouvoir le tenir en main)
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Siglah.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        System.out.println("Enregistrement des blocs de " + Siglah.MOD_ID);
    }
}