package fr.siglah.siglah.block.entity;

import fr.siglah.siglah.init.ModBlockEntities;
import fr.siglah.siglah.init.ModBlocks;
import fr.siglah.siglah.init.ModItems;
import fr.siglah.siglah.screen.TableNettoyageScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class TableNettoyageBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, Inventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    private int progress = 0;
    private final int maxProgress = 72; // ~3.5 secondes

    protected final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        public int get(int index) {
            return switch (index) {
                case 0 -> TableNettoyageBlockEntity.this.progress;
                case 1 -> TableNettoyageBlockEntity.this.maxProgress;
                default -> 0;
            };
        }
        public void set(int index, int value) {
            if (index == 0) TableNettoyageBlockEntity.this.progress = value;
        }
        public int size() { return 2; }
    };

    public TableNettoyageBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TABLE_NETTOYAGE_BLOCK_ENTITY, pos, state);
    }

    // --- Logique du "Nettoyage" ---
    @SuppressWarnings("unused")
    public static void tick(World world, BlockPos pos, BlockState state, TableNettoyageBlockEntity entity) {
        if (world.isClient) return;

        if (hasRecipe(entity)) {
            entity.progress++;
            if (entity.progress >= entity.maxProgress) {
                craftItem(world, entity);
                entity.resetProgress();
            }
        } else {
            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(TableNettoyageBlockEntity entity) {
        ItemStack input = entity.getStack(0);
        boolean hasTool = entity.getStack(1).getItem() == ModItems.PINCEAU_ARCHEO;

        // Vérifie si le minerai est l'un des trois autorisés
        boolean isCorrectOre = input.isOf(ModBlocks.GIVRE_FER_ORE.asItem()) ||
                input.isOf(ModBlocks.SVARTHARN_ORE.asItem()) ||
                input.isOf(ModBlocks.LARME_YMIR_ORE.asItem());

        return isCorrectOre && hasTool;
    }

    private static final Map<Item, Item> RECIPES = Map.of(
            ModBlocks.GIVRE_FER_ORE.asItem(), ModItems.GIVRE_FER_ORE_CLEANED,
            ModBlocks.SVARTHARN_ORE.asItem(), ModItems.SVARTHARN_ORE_CLEANED,
            ModBlocks.LARME_YMIR_ORE.asItem(), ModItems.LARME_YMIR_ORE_CLEANED
    );

    private static void craftItem(World world, TableNettoyageBlockEntity entity) {
        ItemStack input = entity.getStack(0);
        Item resultItem = RECIPES.get(input.getItem());

        if (resultItem != null) {
            entity.removeStack(0, 1);
            entity.getStack(1).damage(1, world.getRandom(), null);

            ItemStack resultStack = new ItemStack(resultItem, 1);
            if (entity.getStack(2).isEmpty()) {
                entity.setStack(2, resultStack);
            } else {
                entity.getStack(2).increment(1);
            }
            entity.markDirty();
        }
    }

    private void resetProgress() { this.progress = 0; }

    // --- Sauvegarde des données ---
    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("table_nettoyage.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("table_nettoyage.progress");
    }

    // --- Interface Inventory ---
    @Override public Text getDisplayName() { return Text.literal("Table de Nettoyage"); }
    @Nullable @Override public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new TableNettoyageScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
    @Override public int size() { return inventory.size(); }
    @Override public boolean isEmpty() { return inventory.stream().allMatch(ItemStack::isEmpty); }
    @Override public ItemStack getStack(int slot) { return inventory.get(slot); }
    @Override public ItemStack removeStack(int slot, int amount) { return Inventories.splitStack(inventory, slot, amount); }
    @Override public ItemStack removeStack(int slot) { return Inventories.removeStack(inventory, slot); }
    @Override public void setStack(int slot, ItemStack stack) { inventory.set(slot, stack); }
    @Override public boolean canPlayerUse(PlayerEntity player) { return true; }
    @Override public void clear() { inventory.clear(); }
}