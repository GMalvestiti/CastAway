package net.riser876.castaway.mixin;

import net.riser876.castaway.CastAway;
import net.riser876.castaway.config.ConfigManager;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import static net.riser876.castaway.config.ConfigManager.CONFIG;

public class CastAwayMixinPlugin implements IMixinConfigPlugin {

    @Override
    public void onLoad(String mixinPackage) {
        try {
            ConfigManager.loadConfig();
            CastAway.LOGGER.info("[CastAway] Configuration loader.");
        } catch (Exception e) {
            CastAway.LOGGER.error("[CastAway] Failed to load configuration.", e);
        }
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.contains("net.riser876.castaway")) {
            if (Objects.isNull(CONFIG)) {
                return false;
            }
            return CONFIG.ENABLED;
        }
        return true;
    }

    @Override
    public String getRefMapperConfig() {return null;}
    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}
    @Override
    public List<String> getMixins() {return null;}
    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
}
