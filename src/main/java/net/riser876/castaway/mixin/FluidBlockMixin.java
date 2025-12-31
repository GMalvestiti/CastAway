package net.riser876.castaway.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.riser876.castaway.CastAway;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LiquidBlock.class)
public abstract class FluidBlockMixin {

    @WrapOperation(
        method = "shouldSpreadLiquid",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/Level;setBlockAndUpdate(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Z"
        )
    )
    private boolean castAway$wrapSetBlockState(Level level, BlockPos pos, BlockState state, Operation<Boolean> original) {
        if (state.is(Blocks.COBBLESTONE)) {
            return level.setBlockAndUpdate(pos, CastAway.FLOWING_WATER);
        }

        return level.setBlockAndUpdate(pos, state);
    }
}
