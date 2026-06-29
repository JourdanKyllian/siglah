package fr.siglah.siglah.init;

import fr.siglah.siglah.Siglah;
import fr.siglah.siglah.block.entity.TableNettoyageBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static BlockEntityType<TableNettoyageBlockEntity> TABLE_NETTOYAGE_BLOCK_ENTITY;

    public static void registerBlockEntities() {
        TABLE_NETTOYAGE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Siglah.MOD_ID, "table_nettoyage_be"),
                FabricBlockEntityTypeBuilder.create(TableNettoyageBlockEntity::new,
                        ModBlocks.TABLE_NETTOYAGE).build());
    }
}