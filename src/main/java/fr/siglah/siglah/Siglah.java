package fr.siglah.siglah;

import fr.siglah.siglah.init.ModBlocks;
import fr.siglah.siglah.init.ModItemGroups;
import fr.siglah.siglah.init.ModItems;
import net.fabricmc.api.ModInitializer;

public class Siglah implements ModInitializer {
    public static final String MOD_ID = "siglah";

    @Override
    public void onInitialize() {
        ModBlocks.registerModBlocks(); // Enregistre les blocs
        ModItems.registerModItems();   // Enregistre les items
        ModItemGroups.registerItemGroups(); // Enregistre l'onglet
        System.out.println("Les métaux de Siglah sont forgés !");
    }
}