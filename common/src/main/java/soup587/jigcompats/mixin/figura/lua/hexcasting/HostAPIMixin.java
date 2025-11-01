package soup587.jigcompats.mixin.figura.lua.hexcasting;

import at.petrak.hexcasting.xplat.IXplatAbstractions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import org.figuramc.figura.lua.LuaWhitelist;
import org.figuramc.figura.lua.api.HostAPI;
import org.figuramc.figura.lua.docs.LuaMethodDoc;
import org.figuramc.figura.math.vector.FiguraVec3;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import java.util.HashMap;
import java.util.Map;

@Mixin(value = HostAPI.class)
public abstract class HostAPIMixin {

    @Shadow
    public abstract boolean isHost();

    @Shadow
    @Final
    private Minecraft minecraft;

    @Unique
    @LuaWhitelist
    @LuaMethodDoc("host.hex.get_sentinel")
    public Map<String, Object> hexGetSentinel() {
        Map<String, Object> sentdata = new HashMap<String, Object>();
        LocalPlayer player = this.minecraft.player;
        if (!isHost() || player == null)
            return null;

        var sentinel = IXplatAbstractions.INSTANCE.getSentinel(player);
        if (sentinel == null)
            return null;

        sentdata.put("extendsRange", sentinel.extendsRange());
        sentdata.put("position", FiguraVec3.fromVec3(sentinel.position()));
        sentdata.put("dimension", sentinel.dimension().location().toString());
        return sentdata;
    }
}
