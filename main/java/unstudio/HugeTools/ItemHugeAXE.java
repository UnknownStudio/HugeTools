package unstudio.HugeTools;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemHugeAXE extends ItemAxe implements ItemHuge{
    private HugeItemIcon hugeIcon;
    private Item baseItem;

    public ItemHugeAXE(ToolMaterial toolMaterial,Item basicItem) {
        super(toolMaterial);
        setCreativeTab(HugeTools.tabSword);
        this.baseItem = basicItem;
        setMaxDamage(baseItem.getMaxDamage()*9);
        setUnlocalizedName("huge"+baseItem.getUnlocalizedName().substring(5));
        this.baseItem = basicItem;
    }
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return baseItem.getIsRepairable(par1ItemStack,par2ItemStack);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = baseItem.getIconFromDamage(0);
        this.hugeIcon = new HugeItemIcon(this.itemIcon, 0.3125F, 0.1875F);
    }

    public IIcon getIcon(ItemStack stack, int pass)
    {
        if (pass == -1)
            return this.hugeIcon;

        return super.getIcon(stack, pass);
    }

    @Override
    public void addRepices(){
        GameRegistry.addShapelessRecipe(new ItemStack(this,1),baseItem,baseItem,baseItem,baseItem,baseItem,baseItem,baseItem,baseItem,baseItem);
    }
}
