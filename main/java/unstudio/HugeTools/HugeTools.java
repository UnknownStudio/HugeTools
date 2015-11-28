package unstudio.HugeTools;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;
import unstudio.HugeTools.mod.NeverMine;

@Mod(modid = HugeTools.MODID, name = HugeTools.NAME, version = HugeTools.VERSION)
public class HugeTools {
    public static final String[] test = {"1","2"};
    public static final String MODID = "hugesword";
    public static final String NAME = "HugeTools";
    public static final String VERSION = "1.0";
    public static final int OutPutVERSION = 2;
    public static boolean haveWarnedVersionOutOfDate = false;
    public static VersionChecker versionChecker = new VersionChecker();
    public static Listener listener = new Listener();
    public static boolean isNeverMineLoaded;
    @SidedProxy(clientSide = "unstudio.HugeTools.ClientProxy",
            serverSide = "unstudio.HugeTools.CommonProxy")
    public static CommonProxy proxy;
    public static NeverMine neverMine;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        isNeverMineLoaded = Loader.isModLoaded("nevermine");
        if (isNeverMineLoaded){
            neverMine = new NeverMine();
        }
        proxy.preInit(event);
        new Thread(versionChecker).start();
    }

    public static CreativeTabs tabSword = new CreativeTabs(StatCollector.translateToLocal("hugeItem")) {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return hugeDiamondSword;
        }
    };

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init(event);
        FMLCommonHandler.instance().bus().register(listener);
        MinecraftForge.EVENT_BUS.register(listener);
    }

    public static ItemHugeSword hugeDiamondSword = new ItemHugeSword(Item.ToolMaterial.EMERALD, Items.diamond_sword);
    public static ItemHugeSword hugeIronSword = new ItemHugeSword(Item.ToolMaterial.IRON, Items.iron_sword);
    public static ItemHugeSword hugeGoldenSword = new ItemHugeSword(Item.ToolMaterial.GOLD, Items.golden_sword);
    public static ItemHugeSword hugeStoneSword = new ItemHugeSword(Item.ToolMaterial.STONE, Items.stone_sword);

    public static ItemHugeAXE hugeDiamondAxe = new ItemHugeAXE(Item.ToolMaterial.EMERALD,Items.diamond_axe);
    public static ItemHugeAXE hugeIronAxe = new ItemHugeAXE(Item.ToolMaterial.IRON,Items.iron_axe);
    public static ItemHugeAXE hugeGoldenAxe = new ItemHugeAXE(Item.ToolMaterial.GOLD,Items.golden_axe);
    public static ItemHugeAXE hugeStoneAxe = new ItemHugeAXE(Item.ToolMaterial.STONE,Items.stone_axe);
    
    public static ItemHugePickaxe hugeDiamondPickaxe = new ItemHugePickaxe(Item.ToolMaterial.EMERALD,Items.diamond_pickaxe);
    public static ItemHugePickaxe hugeIronPickaxe = new ItemHugePickaxe(Item.ToolMaterial.IRON,Items.iron_pickaxe);
    public static ItemHugePickaxe hugeGoldenPickaxe = new ItemHugePickaxe(Item.ToolMaterial.GOLD,Items.golden_pickaxe);
    public static ItemHugePickaxe hugeStonePickaxe = new ItemHugePickaxe(Item.ToolMaterial.STONE,Items.stone_pickaxe);
    
    public static ItemHugeHoe hugeDiamondHoe = new ItemHugeHoe(Item.ToolMaterial.EMERALD,Items.diamond_hoe);
    public static ItemHugeHoe hugeIronHoe = new ItemHugeHoe(Item.ToolMaterial.IRON,Items.iron_hoe);
    public static ItemHugeHoe hugeGoldenHoe = new ItemHugeHoe(Item.ToolMaterial.GOLD,Items.golden_hoe);
    public static ItemHugeHoe hugeStoneHoe = new ItemHugeHoe(Item.ToolMaterial.STONE,Items.stone_hoe);
    
    public static ItemHugeShovel hugeDiamondShovel = new ItemHugeShovel(Item.ToolMaterial.EMERALD,Items.diamond_shovel);
    public static ItemHugeShovel hugeIronShovel = new ItemHugeShovel(Item.ToolMaterial.IRON,Items.iron_shovel);
    public static ItemHugeShovel hugeGoldenShovel = new ItemHugeShovel(Item.ToolMaterial.GOLD,Items.golden_shovel);
    public static ItemHugeShovel hugeStoneShovel = new ItemHugeShovel(Item.ToolMaterial.STONE,Items.stone_shovel);

}
