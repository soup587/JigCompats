package soup587.jigcompats.mixin.neoforge.create;

import com.simibubi.create.content.equipment.armor.CardboardArmorStealthOverlay;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.figuramc.figura.avatar.Avatar;
import org.figuramc.figura.avatar.AvatarManager;
import org.figuramc.figura.utils.RenderUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import soup587.jigcompats.ducks.neoforge.lua.RendererAPIAccessor;

@Mixin(CardboardArmorStealthOverlay.class)
public class CardboardArmorStealthOverlayMixin {

    @Inject(
            method = "renderHelmetOverlay",
            at = @At("HEAD"),
            cancellable = true
    )
    private void renderHelmetOverlay(ItemStack stack, Player player, int width, int height, float partialTick, CallbackInfo ci) {
        Avatar a = AvatarManager.getAvatar(player);
        if (a != null && a.luaRuntime != null && !((RendererAPIAccessor) (Object) (a.luaRuntime.renderer)).shouldCardboardBox()) {
            ci.cancel();
        }
    }
}
