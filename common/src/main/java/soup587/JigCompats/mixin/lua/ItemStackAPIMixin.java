package soup587.JigCompats.mixin.lua;

import org.figuramc.figura.lua.LuaWhitelist;
import org.figuramc.figura.lua.api.world.ItemStackAPI;
import org.figuramc.figura.lua.docs.LuaMethodDoc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import soup587.JigCompats.lua.ItemStackAPIPlatform;

@Mixin(value = ItemStackAPI.class, remap = false)
public class ItemStackAPIMixin {

    @Unique
    @LuaWhitelist
    @LuaMethodDoc("itemstack.tacz_is_gun")
    public boolean taczIsGun() {
        return ItemStackAPIPlatform.taczIsGun((ItemStackAPI)(Object) this);
    }

    @Unique
    @LuaWhitelist
    @LuaMethodDoc("itemstack.tacz_is_chambered")
    public boolean taczIsChambered() {
        return ItemStackAPIPlatform.taczIsChambered((ItemStackAPI)(Object) this);
    }
}
