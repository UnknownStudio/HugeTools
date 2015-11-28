package unstudio.HugeTools.mod;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.nevermine.item.weapon.sword.RockBasherSword;
import net.nevermine.izer.equipment.Weaponizer;
import unstudio.HugeTools.HugeItemIcon;
import unstudio.HugeTools.HugeTools;

/**
 * Use for nothing.
 * Created by trychen on 15/11/28.
 */
public class HugeRockBasherSword extends RockBasherSword {
    private HugeItemIcon hugeIcon;
    private Item baseItem = Weaponizer.RockBasherSword;
    public HugeRockBasherSword(ToolMaterial p_i45356_1_) {
        super(p_i45356_1_);
        setCreativeTab(HugeTools.tabSword);
        setMaxDamage(baseItem.getMaxDamage()*9);
        setUnlocalizedName("huge"+baseItem.getUnlocalizedName().substring(5));
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = baseItem.getIconFromDamage(0);
        this.hugeIcon = new HugeItemIcon(this.itemIcon, 0.1875F, 0.3125F);
    }

    public IIcon getIcon(ItemStack stack, int pass)
    {
        if (pass == -1)
            return this.hugeIcon;

        return super.getIcon(stack, pass);
    }

    public void addRepices(){
        GameRegistry.addShapelessRecipe(new ItemStack(this,1),baseItem,baseItem,baseItem,baseItem,baseItem,baseItem,baseItem,baseItem,baseItem);
    }
}
