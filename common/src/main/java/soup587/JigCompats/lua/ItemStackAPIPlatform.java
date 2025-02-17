package soup587.JigCompats.lua;

import dev.architectury.injectables.annotations.ExpectPlatform;
import org.figuramc.figura.lua.api.world.ItemStackAPI;

public class ItemStackAPIPlatform {

    @ExpectPlatform
    public static boolean taczIsGun(ItemStackAPI item) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean taczIsChambered(ItemStackAPI item) {
        throw new AssertionError();
    }
}
