package fr.siglah.siglah.init;

import fr.siglah.siglah.Siglah;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
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
                        .icon(() -> new ItemStack(ModBlocks.GIVRE_FER_ORE != null ? ModBlocks.GIVRE_FER_ORE : Blocks.IRON_ORE))
                        .entries((context, entries) -> {
                            if (ModBlocks.GIVRE_FER_ORE != null) entries.add(ModBlocks.GIVRE_FER_ORE);
                            if (ModBlocks.SVARTHARN_ORE != null) entries.add(ModBlocks.SVARTHARN_ORE);
                            if (ModBlocks.LARME_YMIR_ORE != null) entries.add(ModBlocks.LARME_YMIR_ORE);
                        })
                        .build());
    }
}