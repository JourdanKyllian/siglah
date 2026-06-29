package fr.siglah.siglah.block.entity;

import fr.siglah.siglah.init.ModBlockEntities;
import fr.siglah.siglah.screen.TableNettoyageScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class TableNettoyageBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, Inventory {

    // On garde la liste, mais on implémente les méthodes de Inventory pour satisfaire Minecraft
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        public int get(int index) { return index == 0 ? 0 : 0; }
        public void set(int index, int value) { }
        public int size() { return 2; }
    };

    public TableNettoyageBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TABLE_NETTOYAGE_BLOCK_ENTITY, pos, state);
    }

    @Override
    public Text getDisplayName() { return Text.literal("Table de Nettoyage"); }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new TableNettoyageScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    // --- Implémentation obligatoire de l'interface Inventory ---
    @Override public int size() { return inventory.size(); }
    @Override public boolean isEmpty() { return inventory.stream().allMatch(ItemStack::isEmpty); }
    @Override public ItemStack getStack(int slot) { return inventory.get(slot); }
    @Override public ItemStack removeStack(int slot, int amount) { return Inventories.splitStack(inventory, slot, amount); }
    @Override public ItemStack removeStack(int slot) { return Inventories.removeStack(inventory, slot); }
    @Override public void setStack(int slot, ItemStack stack) { inventory.set(slot, stack); }
    @Override public boolean canPlayerUse(PlayerEntity player) { return true; }
    @Override public void clear() { inventory.clear(); }
}