package net.riser876.castaway.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.riser876.castaway.CastAway;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FluidBlock.class)
public abstract class FluidBlockMixin {

    @Redirect(
        method = "receiveNeighborFluids",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/World;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)Z"
        )
    )
    private boolean redirectSetBlockState(World world, BlockPos pos, BlockState state) {
        if (state.isOf(Blocks.COBBLESTONE)) {
            return world.setBlockState(pos, CastAway.FLOWING_WATER);
        }

        return world.setBlockState(pos, state);
    }
}
