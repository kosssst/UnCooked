package net.kosssst.uncooked.entity;

import net.kosssst.uncooked.recipe.ModRecipes;
import net.kosssst.uncooked.recipe.UnSmeltingRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class UnFurnaceBlockEntity extends AbstractUnFurnaceBlockEntity {


    public UnFurnaceBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.UNFURNACE.get(), pPos, pBlockState, UnSmeltingRecipe.Type.INSTANCE);
    }

    protected Component getDefaultName() {
        return Component.translatable("block.uncooked.unfurnace");
    }

    protected AbstractContainerMenu createMenu(int pId, Inventory pPlayer) {
        return new UnFurnaceMenu(pId, pPlayer, this, this.dataAccess);
    }

}
