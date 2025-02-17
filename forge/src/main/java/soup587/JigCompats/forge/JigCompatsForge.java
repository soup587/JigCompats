package soup587.JigCompats.forge;

import net.minecraftforge.fml.common.Mod;
import soup587.JigCompats.JigCompats;

/**
 * A mod class is needed for Forge to load the Plugin
 */
@Mod(JigCompats.PLUGIN_ID)
public class JigCompatsForge {
    public JigCompatsForge() {
        JigCompats.init();
    }
}
