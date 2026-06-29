package fr.siglah.siglah.client;

import fr.siglah.siglah.init.ModScreenHandlers;
import fr.siglah.siglah.screen.TableNettoyageScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class SiglahClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.TABLE_NETTOYAGE_SCREEN_HANDLER, TableNettoyageScreen::new);
    }
}
