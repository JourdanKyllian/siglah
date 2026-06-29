package fr.siglah.siglah.init;

import fr.siglah.siglah.Siglah;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    // Etape 2 des minerais (nettoyé)
    public static final Item GIVRE_FER_ORE_CLEANED = registerItem("givre_fer_ore_cleaned", new Item(new FabricItemSettings()));

    // Etape 3 des minerais (cuit)
    public static final Item GIVRE_FER_INGOT = registerItem("givre_fer_ingot", new Item(new FabricItemSettings()));

    // Outils forgerons
    public static final Item PINCEAU_ARCHEO = registerItem("pinceau_archeo", new Item(new FabricItemSettings().maxDamage(64)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Siglah.MOD_ID, name), item);
    }

    public static void registerModItems() {
        // Enregistre les items de tes blocs
        Registry.register(Registries.ITEM, new Identifier(Siglah.MOD_ID, "givre_fer_ore"), new BlockItem(ModBlocks.GIVRE_FER_ORE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(Siglah.MOD_ID, "svartharn_ore"), new BlockItem(ModBlocks.SVARTHARN_ORE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(Siglah.MOD_ID, "larme_ymir_ore"), new BlockItem(ModBlocks.LARME_YMIR_ORE, new FabricItemSettings()));

        // L'item de la table de nettoyage
        Registry.register(Registries.ITEM, new Identifier(Siglah.MOD_ID, "table_nettoyage"), new BlockItem(ModBlocks.TABLE_NETTOYAGE, new FabricItemSettings()));
    }
}