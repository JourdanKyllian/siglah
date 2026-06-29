package fr.siglah.siglah.init;

import fr.siglah.siglah.Siglah;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static ItemGroup SIGLAH_GROUP;

    public static void registerItemGroups() {
        SIGLAH_GROUP = Registry.register(Registries.ITEM_GROUP,
                new Identifier(Siglah.MOD_ID, "siglah_group"),
                FabricItemGroup.builder()
                        .displayName(Text.translatable("itemgroup.siglah.siglah_group"))
                        .icon(() -> new ItemStack(ModBlocks.GIVRE_FER_ORE))
                        .entries((context, entries) -> {
                            // --- Les Blocs ---
                            entries.add(ModBlocks.GIVRE_FER_ORE);
                            entries.add(ModBlocks.SVARTHARN_ORE);
                            entries.add(ModBlocks.LARME_YMIR_ORE);
                            entries.add(ModBlocks.TABLE_NETTOYAGE);

                            // --- Les Items ---
                            entries.add(ModItems.GIVRE_FER_ORE_CLEANED);
                            entries.add(ModItems.SVARTHARN_ORE_CLEANED);
                            entries.add(ModItems.LARME_YMIR_ORE_CLEANED);
                            entries.add(ModItems.GIVRE_FER_INGOT);
                            entries.add(ModItems.SVARTHARN_INGOT);
                            entries.add(ModItems.LARME_YMIR_INGOT);
                            entries.add(ModItems.PINCEAU_ARCHEO);
                        })
                        .build());
    }
}