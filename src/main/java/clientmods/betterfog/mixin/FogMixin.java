package clientmods.betterfog.mixin;

import net.minecraft.client.render.WorldRenderer;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(WorldRenderer.class)
public class FogMixin {
    @ModifyVariable(at = @At("STORE"), method = "render", ordinal = 1)
    private float fog(float g) {
        int chunks = ((WorldRenderer)(Object)this).getCompletedChunkCount();
        float radius = MathHelper.sqrt((float)chunks/MathHelper.PI)*15F;
        return MathHelper.clamp(radius, 16F, g);
    }
}