package net.dollar.apex.entity.client;

import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.random.RandomGenerator;

@OnlyIn(Dist.CLIENT)
public class ModMysteriousSpecterRenderState extends HumanoidRenderState {
    private final int textureID;

    public ModMysteriousSpecterRenderState() {
        //Set textureID to a value between 0-4, which is used to determine which texture to render.
        this.textureID = RandomGenerator.getDefault().nextInt(5);
    }



    /**
     * Gets the textureID field (in range of 0-4), which will determine which texture to load for the
     *  Entity associated with this RenderState instance.
     * @return The textureID field value
     */
    public int getTextureID() {
        return textureID;
    }
}
