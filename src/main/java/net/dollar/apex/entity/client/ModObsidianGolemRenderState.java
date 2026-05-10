package net.dollar.apex.entity.client;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.Crackiness;

public class ModObsidianGolemRenderState extends LivingEntityRenderState {
    public float attackTicksRemaining;
    public Crackiness.Level crackiness;

    public ModObsidianGolemRenderState() {
        this.crackiness = Crackiness.Level.NONE;
    }
}
