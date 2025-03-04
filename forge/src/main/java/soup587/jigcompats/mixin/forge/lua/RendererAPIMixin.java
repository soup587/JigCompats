package soup587.jigcompats.mixin.forge.lua;

import org.figuramc.figura.lua.LuaWhitelist;
import org.figuramc.figura.lua.api.RendererAPI;
import org.figuramc.figura.lua.docs.LuaMethodDoc;
import org.spongepowered.asm.mixin.Mixin;
import soup587.jigcompats.ducks.forge.RendererAPIAccessor;

@Mixin(value = RendererAPI.class, remap = false)
public abstract class RendererAPIMixin implements RendererAPIAccessor {
    private boolean skyHookAnimation = true;
    private boolean cardboardBox = true;

    @LuaWhitelist
    @LuaMethodDoc("renderer.create.set_skyhook_animation")
    public RendererAPI setSkyhookAnimation(boolean should) {
        skyHookAnimation = should;
        return ((RendererAPI) (Object) this);
    }

    @LuaWhitelist
    @LuaMethodDoc("renderer.create.should_skyhook_animation")
    public boolean shouldSkyhookAnimation() {
        return skyHookAnimation;
    }

    @LuaWhitelist
    @LuaMethodDoc("renderer.create.set_cardboard_box")
    public RendererAPI setCardboardBox(boolean should) {
        cardboardBox = should;
        return ((RendererAPI) (Object) this);
    }

    @LuaWhitelist
    @LuaMethodDoc("renderer.create.should_cardboard_box")
    public boolean shouldCardboardBox() {
        return cardboardBox;
    }
}
