package net.eletrixgg.testmod;

import net.eletrixgg.testmod.block.ModBlocks;
import net.eletrixgg.testmod.config.ModConfigs;
import net.eletrixgg.testmod.item.ModItems;
import net.eletrixgg.testmod.item.ModItemGroups;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "testmod"; //the mod id
    public static final Logger LOGGER = LoggerFactory.getLogger("TestMod"); //name that shows up in log.  Example: [Name] Mod started.
	public static final String VERSION = "0.1-1.20.1-ALPHA"; //the version if u want to put throughout the code

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("TestMod by eletrixgg has started sucessfully. Running version: " + VERSION);
		LOGGER.info("This mod is still in its Alpha State, please report any bugs to eletrixgg on Discord!");
		ModConfigs.registerConfigs(); // Register the configs first (MAKE SURE TO DO FIRST)
		ModItemGroups.registerItemGroups(); //Register the creative tabs (or item groups)
		ModItems.registerModItems(); // register the items
		ModBlocks.registerModBlocks(); //register blocks

		FuelRegistry.INSTANCE.add(ModItems.FINE_COAL, 200); //the value of 200 is how long the item burns (in ticks) (200 ticks = 10 secs)
	}
}