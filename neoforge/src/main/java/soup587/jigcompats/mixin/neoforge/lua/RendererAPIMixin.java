package soup587.jigcompats.mixin.neoforge.lua;

import org.figuramc.figura.lua.LuaWhitelist;
import org.figuramc.figura.lua.api.RendererAPI;
import org.figuramc.figura.lua.docs.LuaMethodDoc;
import org.spongepowered.asm.mixin.Mixin;
import soup587.mixin.ducks.lua.RendererAPIAccessor;

@Mixin(value = RendererAPI.class, remap = false)
public abstract class RendererAPIMixin implements RendererAPIAccessor {
    private boolean skyHookAnimation = true;

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
}
