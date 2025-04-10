package net.riser876.castaway;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CastAway implements ModInitializer {

    public static final String MOD_ID = "castaway";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        CastAway.LOGGER.info("[CastAway] Mod loaded.");
    }
}
