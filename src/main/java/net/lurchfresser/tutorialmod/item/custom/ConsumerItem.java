package net.lurchfresser.tutorialmod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.w3c.dom.Text;


public class ConsumerItem extends Item {
    public ConsumerItem(Settings settings){
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        double x = user.getX();
        double y = user.getY();
        double z = user.getZ();

        if(!user.world.isClient) {
            if (entity instanceof ZombieEntity) {
                entity.discard();
                user.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(19), 100));
            } else if (entity instanceof CreeperEntity) {
                entity.discard();
                user.world.createExplosion(user, null,null, x + 0.5D, y + 0.5d, z + 0.5d,3F,false,World.ExplosionSourceType.MOB);
            }
        }
        return super.useOnEntity(stack, user, entity, hand);
    }

    public final void discard(LivingEntity entity) {
        entity.remove(Entity.RemovalReason.DISCARDED);
    }
}
