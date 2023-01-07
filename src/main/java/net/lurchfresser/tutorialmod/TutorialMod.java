package net.lurchfresser.tutorialmod;

import net.fabricmc.api.ModInitializer;
import net.lurchfresser.tutorialmod.block.ModBlocks;
import net.lurchfresser.tutorialmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	//cahhhzuvucu
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
