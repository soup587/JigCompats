package soup587.JigCompats.fabric;

import net.fabricmc.api.ModInitializer;
import soup587.JigCompats.JigCompats;

/**
 * A mod class is not technically needed for Fabric to load the Plugin, but it's still nice to have.
 */
public class JigCompatsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        JigCompats.init();
    }
}
