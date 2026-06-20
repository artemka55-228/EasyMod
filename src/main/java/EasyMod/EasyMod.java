package EasyMod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class EasyMod implements ModInitializer {
    // Создание переменной с амлуетом
    public static final Item NOOB_AMULET = new NoobAmulet(new Item.Settings().maxCount(1).group(ItemGroup.MISC));

    // Регистрация амулета
    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("easymod", "noob_amulet"), NOOB_AMULET);
    }
}
