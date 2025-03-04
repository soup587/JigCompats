package soup587.jigcompats.mixin.forge.create;

import com.simibubi.create.content.equipment.armor.CardboardArmorHandlerClient;
import net.minecraftforge.client.event.RenderPlayerEvent;
import org.figuramc.figura.avatar.Avatar;
import org.figuramc.figura.avatar.AvatarManager;
import org.figuramc.figura.utils.RenderUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import soup587.jigcompats.ducks.forge.RendererAPIAccessor;

@Mixin(value = CardboardArmorHandlerClient.class, remap = false)
public class CardboardArmorHandlerClientMixin {

    @Inject(
            method = "playerRendersAsBoxWhenSneaking",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void jigcreate$playerRendersAsBoxWhenSneaking(RenderPlayerEvent.Pre event, CallbackInfo ci) {
        Avatar a = AvatarManager.getAvatar(event.getEntity());
        if (RenderUtils.vanillaModelAndScript(a)) {
            if (!((RendererAPIAccessor) (Object) (a.luaRuntime.renderer)).shouldCardboardBox()) {
                ci.cancel();
            }
        }
    }
}
