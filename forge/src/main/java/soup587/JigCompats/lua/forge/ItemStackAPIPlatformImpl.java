package soup587.JigCompats.lua.forge;

import com.tacz.guns.api.item.IGun;
import org.figuramc.figura.lua.api.world.ItemStackAPI;

public class ItemStackAPIPlatformImpl {

    public static IGun taczAsGun(ItemStackAPI item) {
        if (item.itemStack.getItem() instanceof IGun iGun) {
            return iGun;
        }
        return null;
    }

    public static boolean taczIsGun(ItemStackAPI item) {
        return item.itemStack.getItem() instanceof IGun;
    }

    public static boolean taczIsChambered(ItemStackAPI item) {
        if (taczIsGun(item)) {
            return taczAsGun(item).hasBulletInBarrel(item.itemStack);
        }
        return false;
    }
}
