package fr.siglah.siglah.init;

import fr.siglah.siglah.Siglah;
import fr.siglah.siglah.screen.TableNettoyageScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<TableNettoyageScreenHandler> TABLE_NETTOYAGE_SCREEN_HANDLER;

    public static void registerScreenHandlers() {
        TABLE_NETTOYAGE_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER,
                new Identifier(Siglah.MOD_ID, "table_nettoyage"),
                new ScreenHandlerType<>(TableNettoyageScreenHandler::new, FeatureFlags.VANILLA_FEATURES));
    }
}