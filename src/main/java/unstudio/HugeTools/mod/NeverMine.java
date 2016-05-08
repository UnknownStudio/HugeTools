package unstudio.HugeTools.mod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.nevermine.izer.equipment.Weaponizer;
import unstudio.HugeTools.ItemHugeSword;

/**
 * Use for nothing.
 * Created by trychen on 15/11/28.
 */
public class NeverMine {
//    public Item hugeBloodfury = new HugeBloodfury(EnumHelper.addToolMaterial("TIER5", 4, 2000, 4.0F, 23.0F, 10));
//    public Item UnderworldGreatblade = new UnderworldGreatblade(1000, 18.0F).func_77655_b("UnderworldGreatblade").func_111206_d("nevermine:underworldGreatblade");
    public ItemHugeSword hugeBloodfury= new ItemHugeSword(EnumHelper.addToolMaterial("TIER5", 4, 2000, 4.0F, 23.0F, 10), Weaponizer.Bloodfury);
    public HugeRockBasherSword hugeRockBasherSword= new HugeRockBasherSword(EnumHelper.addToolMaterial("TIER4", 4, 2000, 4.0F, 20.0F, 10));
}
