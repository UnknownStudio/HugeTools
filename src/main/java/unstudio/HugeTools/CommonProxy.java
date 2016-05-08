package unstudio.HugeTools;


import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

public class CommonProxy {
    public void init(FMLInitializationEvent event){
        registerItem(HugeTools.hugeDiamondSword);
        registerItem(HugeTools.hugeIronSword);
        registerItem(HugeTools.hugeGoldenSword);
        registerItem(HugeTools.hugeStoneSword);
        
        registerItem(HugeTools.hugeDiamondAxe);
        registerItem(HugeTools.hugeIronAxe);
        registerItem(HugeTools.hugeGoldenAxe);
        registerItem(HugeTools.hugeStoneAxe);
        
        registerItem(HugeTools.hugeDiamondPickaxe);
        registerItem(HugeTools.hugeIronPickaxe);
        registerItem(HugeTools.hugeGoldenPickaxe);
        registerItem(HugeTools.hugeStonePickaxe);
        
        registerItem(HugeTools.hugeDiamondHoe);
        registerItem(HugeTools.hugeIronHoe);
        registerItem(HugeTools.hugeGoldenHoe);
        registerItem(HugeTools.hugeStoneHoe);
        
        registerItem(HugeTools.hugeDiamondShovel);
        registerItem(HugeTools.hugeIronShovel);
        registerItem(HugeTools.hugeGoldenShovel);
        registerItem(HugeTools.hugeStoneShovel);

        if (HugeTools.isNeverMineLoaded){
            GameRegistry.registerItem(HugeTools.neverMine.hugeBloodfury,HugeTools.neverMine.hugeBloodfury.getUnlocalizedName().substring(5));
            HugeTools.neverMine.hugeBloodfury.addRepices();
            GameRegistry.registerItem(HugeTools.neverMine.hugeRockBasherSword,HugeTools.neverMine.hugeRockBasherSword.getUnlocalizedName().substring(5));
            HugeTools.neverMine.hugeRockBasherSword.addRepices();
        }

	}

    public void registerItem(ItemHugeSword item){
        GameRegistry.registerItem(item,item.getUnlocalizedName().substring(5));
        item.addRepices();
    }
    public void registerItem(ItemHugeAXE item){
        GameRegistry.registerItem(item,item.getUnlocalizedName().substring(5));
        item.addRepices();
    }
    public void registerItem(ItemHugePickaxe item){
        GameRegistry.registerItem(item,item.getUnlocalizedName().substring(5));
        item.addRepices();
    }
    public void registerItem(ItemHugeHoe item){
        GameRegistry.registerItem(item,item.getUnlocalizedName().substring(5));
        item.addRepices();
    }
    public void registerItem(ItemHugeShovel item){
        GameRegistry.registerItem(item,item.getUnlocalizedName().substring(5));
        item.addRepices();
    }
    public void preInit(FMLPreInitializationEvent event) {

    }
}
