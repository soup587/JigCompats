package soup587.jigcompats.mixin.forge.lua;

import net.minecraft.world.entity.Entity;
import org.figuramc.figura.lua.api.entity.EntityAPI;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.UUID;

@Mixin(value = EntityAPI.class, remap = false)
public abstract class EntityAPIMixin<T extends Entity> {

    @Shadow protected abstract boolean checkEntity();
    @Shadow protected T entity;
    @Shadow @Final protected UUID entityUUID;

}