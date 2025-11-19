package net.dollar.apex.entity.client;

import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModMysteriousSpecterRenderState extends HumanoidRenderState {
    private final int textureID;

    public ModMysteriousSpecterRenderState() {
        //Set textureID to a value between 0-4, which is used to determine which texture to render.
//        Random random = new Random();
//        this.textureID = random.nextInt(5);

        // Above was causing rapid swapping between textures for some reason, change to always 0.
        this.textureID = 0;
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
