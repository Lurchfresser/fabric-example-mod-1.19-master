package net.lurchfresser.tutorialmod.entity.effect.custom;

import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.gl.ShaderProgramSetupView;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class Exploding extends StatusEffect {

    public Exploding(){
        super(StatusEffectCategory.HARMFUL,
                0x8fe38f);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        this.duration = duration;
        if (duration == 1 || duration == 100) return true;
        return false;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier){
        if (duration == 60){
            sound(entity);
        }
        if (!entity.world.isClient && duration == 1){
            double x = entity.getX();
            double y = entity.getY();
            double z = entity.getZ();
            entity.world.createExplosion(entity, null,null, x + 0.5D, y + 0.5d, z + 0.5d,3F * amplifier,false, World.ExplosionSourceType.MOB);
        }
    }

    private void applyShader(LivingEntity player){

    }
    private void sound(LivingEntity entity){
        entity.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 0.5F);
    }
    private int duration;
}
