package soup587.jigcompats.mixin.figura.lua.hexcasting;

import at.petrak.hexcasting.api.addldata.ADMediaHolder;
import at.petrak.hexcasting.xplat.IXplatAbstractions;
import net.minecraft.world.item.ItemStack;
import org.figuramc.figura.lua.LuaWhitelist;
import org.figuramc.figura.lua.api.world.ItemStackAPI;
import org.figuramc.figura.lua.docs.LuaMethodDoc;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = ItemStackAPI.class, remap = false)
public class ItemStackAPIMixin {

    @Shadow
    @Final
    public ItemStack itemStack;

    @Unique
    @LuaWhitelist
    @LuaMethodDoc("itemstack.hex.can_hold_media")
    public boolean hexCanHoldMedia() {
        return (IXplatAbstractions.INSTANCE.findMediaHolder(itemStack) != null);
    }

    @Unique
    @LuaWhitelist
    @LuaMethodDoc("itemstack.hex.get_media")
    public long hexGetMedia() {
        ADMediaHolder mediaholder = IXplatAbstractions.INSTANCE.findMediaHolder(itemStack);
        if (mediaholder == null)
            return 0;
        return mediaholder.getMedia();
    }

    @Unique
    @LuaWhitelist
    @LuaMethodDoc("itemstack.hex.get_max_media")
    public long hexGetMaxMedia() {
        ADMediaHolder mediaholder = IXplatAbstractions.INSTANCE.findMediaHolder(itemStack);
        if (mediaholder == null)
            return 0;
        return mediaholder.getMaxMedia();
    }

    @Unique
    @LuaWhitelist
    @LuaMethodDoc("itemstack.hex.can_recharge")
    public boolean hexCanRecharge() {
        ADMediaHolder mediaholder = IXplatAbstractions.INSTANCE.findMediaHolder(itemStack);
        if (mediaholder == null)
            return false;
        return mediaholder.canRecharge();
    }

    @Unique
    @LuaWhitelist
    @LuaMethodDoc("itemstack.hex.can_provide_media")
    public boolean hexCanProvideMedia() {
        ADMediaHolder mediaholder = IXplatAbstractions.INSTANCE.findMediaHolder(itemStack);
        if (mediaholder == null)
            return false;
        return mediaholder.canProvide();
    }

    @Unique
    @LuaWhitelist
    @LuaMethodDoc("itemstack.hex.get_media_priority")
    public int hexGetMediaPriority() {
        ADMediaHolder mediaholder = IXplatAbstractions.INSTANCE.findMediaHolder(itemStack);
        if (mediaholder == null)
            return 0;
        return mediaholder.getConsumptionPriority();
    }

    @Unique
    @LuaWhitelist
    @LuaMethodDoc("itemstack.hex.can_craft_battery")
    public boolean hexCanCraftBattery() {
        ADMediaHolder mediaholder = IXplatAbstractions.INSTANCE.findMediaHolder(itemStack);
        if (mediaholder == null)
            return false;
        return mediaholder.canConstructBattery();
    }
}
