package soup587.jigcompats.mixin.forge.create;

import com.simibubi.create.foundation.render.PlayerSkyhookRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.player.Player;
import org.figuramc.figura.avatar.Avatar;
import org.figuramc.figura.avatar.AvatarManager;
import org.figuramc.figura.utils.RenderUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import soup587.jigcompats.ducks.forge.RendererAPIAccessor;

@Mixin(value = PlayerSkyhookRenderer.class, remap = false)
public class PlayerSkyhookRendererMixin {

    @Inject(
            method = "afterSetupAnim",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void jigcreate$afterSetupAnim(Player player, HumanoidModel<?> model, CallbackInfo ci) {
        Avatar a = AvatarManager.getAvatar(player);
        if (RenderUtils.vanillaModelAndScript(a)) {
            if (!((RendererAPIAccessor) (Object) (a.luaRuntime.renderer)).shouldSkyhookAnimation()) {
                ci.cancel();
            }
        }
    }
}
