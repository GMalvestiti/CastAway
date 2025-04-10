package net.riser876.castaway;

import net.fabricmc.api.ModInitializer;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CastAway implements ModInitializer {

    public static final String MOD_ID = "castaway";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final BlockState FLOWING_WATER = Fluids.FLOWING_WATER.getFlowing(7, false).getBlockState();

    @Override
    public void onInitialize() {
        CastAway.LOGGER.info("[CastAway] Mod loaded.");
    }
}
