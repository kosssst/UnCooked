package net.kosssst.uncooked.entity;

import net.kosssst.uncooked.recipe.UnSmeltingRecipe;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class UnFurnaceMenu extends AbstractFurnaceMenu {
    public static final ArrayList<Item> BURNABLE = new ArrayList<>(List.of(Blocks.ICE.asItem(), Blocks.PACKED_ICE.asItem(), Blocks.BLUE_ICE.asItem()));

    public UnFurnaceMenu(int pContainerId, Inventory pPlayerInventory) {
        super(MenuType.FURNACE, UnSmeltingRecipe.Type.INSTANCE, null, pContainerId, pPlayerInventory);
    }

    public UnFurnaceMenu(int pContainerId, Inventory pPlayerInventory, Container pFurnaceContainer, ContainerData pFurnaceData) {
        super(MenuType.FURNACE, UnSmeltingRecipe.Type.INSTANCE, null, pContainerId, pPlayerInventory, pFurnaceContainer, pFurnaceData);
    }

    @Override
    protected boolean isFuel(ItemStack pStack) {
        return BURNABLE.contains(pStack.getItem());
    }

    @Override
    protected boolean canSmelt(ItemStack pStack) {
        return super.canSmelt(pStack);
    }
}
