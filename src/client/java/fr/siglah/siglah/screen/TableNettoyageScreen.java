package fr.siglah.siglah.screen;

import fr.siglah.siglah.Siglah;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TableNettoyageScreen extends HandledScreen<TableNettoyageScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(Siglah.MOD_ID, "textures/gui/table_nettoyage.png");

    public TableNettoyageScreen(TableNettoyageScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        // Dessine la flèche de progression
        if(handler.isCrafting()) {
            context.drawTexture(TEXTURE, x + 80, y + 35, 176, 0, handler.getScaledProgress(), 17);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}