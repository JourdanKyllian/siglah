package fr.siglah.siglah.init;

import fr.siglah.siglah.Siglah;
import fr.siglah.siglah.item.ModPickaxeItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    // Etape 2 des minerais (nettoyé)
    public static final Item GIVRE_FER_ORE_CLEANED = registerItem("givre_fer_ore_cleaned", new Item(new FabricItemSettings()));
    public static final Item SVARTHARN_ORE_CLEANED = registerItem("svartharn_ore_cleaned", new Item(new FabricItemSettings()));
    public static final Item LARME_YMIR_ORE_CLEANED = registerItem("larme_ymir_ore_cleaned", new Item(new FabricItemSettings()));


    // Etape 3 des minerais (cuit)
    public static final Item GIVRE_FER_INGOT = registerItem("givre_fer_ingot", new Item(new FabricItemSettings()));
    public static final Item SVARTHARN_INGOT = registerItem("svartharn_ingot", new Item(new FabricItemSettings()));
    public static final Item LARME_YMIR_INGOT = registerItem("larme_ymir_ingot", new Item(new FabricItemSettings()));

    // Outils forgerons
    public static final Item PINCEAU_ARCHEO = registerItem("pinceau_archeo", new Item(new FabricItemSettings().maxDamage(64)));

    // Outils Mineur
    public static final Item GIVRE_FER_PICKAXE = registerItem("givre_fer_pickaxe",
            new ModPickaxeItem(ModToolMaterial.GIVRE_FER, 1, -2.8f, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Siglah.MOD_ID, name), item);
    }

    public static void registerModItems() {
        System.out.println("Enregistrement des items de " + Siglah.MOD_ID);
    }
}