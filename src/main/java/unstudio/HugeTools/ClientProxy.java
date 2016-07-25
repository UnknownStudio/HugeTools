package unstudio.HugeTools;


import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy{
    @Override
    public void init(FMLInitializationEvent event){
        Minecraft mc = FMLClientHandler.instance().getClient();
        HugeItemRenderer hugeItemRenderer = new HugeItemRenderer(mc.gameSettings, mc.getTextureManager());
        MinecraftForgeClient.registerItemRenderer(HugeTools.hugeDiamondSword, hugeItemRenderer);
        MinecraftForgeClient.registerItemRenderer(HugeTools.hugeGoldenSword, hugeItemRenderer);
        MinecraftForgeClient.registerItemRenderer(HugeTools.hugeIronSword, hugeItemRenderer);
        MinecraftForgeClient.registerItemRenderer(HugeTools.hugeStoneSword, hugeItemRenderer);
        MinecraftForgeClient.registerItemRenderer(HugeTools.hugeDiamondAxe, hugeItemRenderer);
        MinecraftForgeClient.registerItemRenderer(HugeTools.hugeIronAxe, hugeItemRenderer);
        MinecraftForgeClient.registerItemRenderer(HugeTools.hugeGoldenAxe, hugeItemRenderer);
        MinecraftForgeClient.registerItemRenderer(HugeTools.hugeStoneAxe, hugeItemRenderer);
        MinecraftForgeClient.registerItemRenderer(HugeTools.hugeDiamondPickaxe, hugeItemRenderer);
        MinecraftForgeClient.registerItemRenderer(HugeTools.hugeIronPickaxe, hugeItemRenderer);
        MinecraftForgeClient.registerItemRenderer(HugeTools.hugeGoldenPickaxe, hugeItemRenderer);
        MinecraftForgeClient.registerItemRenderer(HugeTools.hugeStonePickaxe, hugeItemRenderer);
        MinecraftForgeClient.registerItemRenderer(HugeTools.hugeDiamondHoe, hugeItemRenderer);
        MinecraftForgeClient.registerItemRenderer(HugeTools.hugeIronHoe, hugeItemRenderer);
        MinecraftForgeClient.registerItemRenderer(HugeTools.hugeGoldenHoe, hugeItemRenderer);
        MinecraftForgeClient.registerItemRenderer(HugeTools.hugeStoneHoe, hugeItemRenderer);
        MinecraftForgeClient.registerItemRenderer(HugeTools.hugeDiamondShovel, hugeItemRenderer);
        MinecraftForgeClient.registerItemRenderer(HugeTools.hugeIronShovel, hugeItemRenderer);
        MinecraftForgeClient.registerItemRenderer(HugeTools.hugeGoldenShovel, hugeItemRenderer);
        MinecraftForgeClient.registerItemRenderer(HugeTools.hugeStoneShovel, hugeItemRenderer);
        super.init(event);
    }

}
