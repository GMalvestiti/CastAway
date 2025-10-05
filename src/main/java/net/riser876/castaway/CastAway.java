package net.riser876.castaway;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.riser876.castaway.util.CastAwayGlobals;
import java.util.Objects;

import static net.riser876.castaway.config.ConfigManager.CONFIG;

public class CastAway implements ModInitializer {

    public static BlockState FLOWING_WATER;

    @Override
    public void onInitialize() {
        if (Objects.nonNull(CONFIG) && CONFIG.ENABLED) {
            CastAway.setFlowingWater();
            CastAwayGlobals.LOGGER.info("[CastAway] Mod loaded.");
        } else {
            CastAwayGlobals.LOGGER.info("[CastAway] Mod disabled.");
        }
    }

    private static void setFlowingWater() {
        FLOWING_WATER = Fluids.FLOWING_WATER.getFlowing(CONFIG.WATER_LEVEL, CONFIG.WATER_FALLING).getBlockState();
        CastAwayGlobals.LOGGER.info("[CastAway] Water level set to {} and falling set to {}.", CONFIG.WATER_LEVEL, CONFIG.WATER_FALLING);
    }
}
