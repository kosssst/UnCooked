package net.kosssst.uncooked.block.unfurnace;

import net.kosssst.uncooked.entity.ModBlockEntities;
import net.kosssst.uncooked.entity.UnFurnaceBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class UnFurnaceBlock extends AbstractFurnaceBlock {

    public UnFurnaceBlock(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createFurnaceTicker(pLevel, pBlockEntityType, ModBlockEntities.UNFURNACE.get());
    }

    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new UnFurnaceBlockEntity(pPos, pState);
    }

    protected void openContainer(Level pLevel, BlockPos pPos, Player pPlayer) {
        BlockEntity $$3 = pLevel.getBlockEntity(pPos);
        if ($$3 instanceof UnFurnaceBlockEntity) {
            pPlayer.openMenu((MenuProvider)$$3);
            pPlayer.awardStat(Stats.INTERACT_WITH_FURNACE);
        }
    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if ((Boolean)pState.getValue(LIT)) {
            double $$4 = (double)pPos.getX() + 0.5;
            double $$5 = (double)pPos.getY();
            double $$6 = (double)pPos.getZ() + 0.5;
            if (pRandom.nextDouble() < 0.1) {
                pLevel.playLocalSound($$4, $$5, $$6, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction $$7 = (Direction)pState.getValue(FACING);
            Direction.Axis $$8 = $$7.getAxis();
            double $$9 = 0.52;
            double $$10 = pRandom.nextDouble() * 0.6 - 0.3;
            double $$11 = $$8 == Direction.Axis.X ? (double)$$7.getStepX() * 0.52 : $$10;
            double $$12 = pRandom.nextDouble() * 6.0 / 16.0;
            double $$13 = $$8 == Direction.Axis.Z ? (double)$$7.getStepZ() * 0.52 : $$10;
            pLevel.addParticle(ParticleTypes.SMOKE, $$4 + $$11, $$5 + $$12, $$6 + $$13, 0.0, 0.0, 0.0);
            pLevel.addParticle(ParticleTypes.FLAME, $$4 + $$11, $$5 + $$12, $$6 + $$13, 0.0, 0.0, 0.0);
        }
    }

    //    @Override
//    public @NotNull InteractionResult use(@NotNull BlockState pState, Level pLevel, @NotNull BlockPos pPos, @NotNull Player pPlayer, @NotNull InteractionHand pHand, @NotNull BlockHitResult pHit) {
//        pLevel.playLocalSound(pPos, SoundEvents.TNT_PRIMED, SoundSource.BLOCKS, 1.0f, 1.0f, false);
//        return InteractionResult.SUCCESS;
//    }

}
