package soup587.jigcompats.mixin.forge.lua;

import com.simibubi.create.content.equipment.armor.CardboardArmorHandler;
import com.simibubi.create.content.kinetics.chainConveyor.ServerChainConveyorHandler;
import net.minecraft.world.entity.LivingEntity;
import org.figuramc.figura.lua.LuaWhitelist;
import org.figuramc.figura.lua.api.entity.LivingEntityAPI;
import org.figuramc.figura.lua.docs.LuaMethodDoc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import soup587.jigcompats.mixin.forge.create.PlayerSkyhookRendererAccessor;

@Mixin(value = LivingEntityAPI.class, remap = false)
public abstract class LivingEntityAPIMixin<T extends LivingEntity> extends EntityAPIMixin<T> {

    @Unique
    @LuaWhitelist
    @LuaMethodDoc("living_entity.create.is_riding_chain_conveyor")
    public boolean isRidingChainConveyor() {
        checkEntity();
        return PlayerSkyhookRendererAccessor.getHangingPlayers().contains(entityUUID);
    }

    @Unique
    @LuaWhitelist
    @LuaMethodDoc("living_entity.create.is_cardboard_stealth")
    public boolean isCardboardStealth() {
        checkEntity();
        return CardboardArmorHandler.testForStealth(entity);
    }

}
