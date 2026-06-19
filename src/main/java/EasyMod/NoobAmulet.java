package EasyMod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class NoobAmulet extends Item {

    // Регистрация амулета
    public NoobAmulet(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        // Проверка на то что мир не клиентский, а сущность - это игрок
        if (!world.isClient && entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;

            // Снижение урона в сторону игрока Сопративление I ур., повышение урона Сила II.
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 29, 1, false, false, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 29, 1, false, false, true));

            // Если прошло 100 тиков игры и уровень еды менее 20 (максимума) то выдаётся эффект Насыщения I
            if (player.getHungerManager().getFoodLevel() > 20 && world.getTime() % 100 == 0) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 10, 0, false, false, true));
            }
        }
    }
}
