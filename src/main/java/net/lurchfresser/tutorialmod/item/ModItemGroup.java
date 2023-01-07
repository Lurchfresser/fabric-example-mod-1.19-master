package net.lurchfresser.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.lurchfresser.tutorialmod.TutorialMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup TANZANITE = FabricItemGroup.builder(new Identifier(TutorialMod.MOD_ID,"tanzanite")).icon(() ->new ItemStack(ModItems.TANZANITE)).build();
}
