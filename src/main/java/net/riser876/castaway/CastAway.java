package net.riser876.castaway;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.riser876.castaway.config.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

import static net.riser876.castaway.config.ConfigManager.CONFIG;

public class CastAway implements ModInitializer {

    public static final String MOD_ID = "castaway";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static BlockState FLOWING_WATER;

    @Override
    public void onInitialize() {
        if (Objects.isNull(CONFIG)) {
            LOGGER.error("[CastAway] Configuration file is broken.");
            return;
        }

        if (!CONFIG.ENABLED) {
            LOGGER.info("[CastAway] Mod disabled via config.");
            return;
        }

        setFlowingWater();

        LOGGER.info("[CastAway] Mod initialized.");
    }

    private static void setFlowingWater() {
        FLOWING_WATER = Fluids.FLOWING_WATER
                .getFlowing(CONFIG.WATER_LEVEL, CONFIG.WATER_FALLING)
                .createLegacyBlock();
        LOGGER.info("[CastAway] Water level set to {} and falling set to {}.", CONFIG.WATER_LEVEL, CONFIG.WATER_FALLING);
    }
}
