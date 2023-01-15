package net.lurchfresser.tutorialmod.entity.effect;

import net.lurchfresser.tutorialmod.TutorialMod;
import net.lurchfresser.tutorialmod.entity.effect.custom.Exploding;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final StatusEffect EXPLODING = registerEffect("exploding",new Exploding());

    private static StatusEffect registerEffect(String name, StatusEffect effect){
        return Registry.register(Registries.STATUS_EFFECT,new Identifier(TutorialMod.MOD_ID,name),effect);
    }
    public static void registerModEffects(){
        TutorialMod.LOGGER.debug("Registering Mod Effects for "+ TutorialMod.MOD_ID);
    }
}
