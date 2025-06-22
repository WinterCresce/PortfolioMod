package net.wintercresce.portfoliomod;

import net.fabricmc.api.ModInitializer;

import net.wintercresce.portfoliomod.block.ModBlocks;
import net.wintercresce.portfoliomod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// very important comment
public class PortfolioMod implements ModInitializer {
	public static final String MOD_ID = "portfoliomod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}