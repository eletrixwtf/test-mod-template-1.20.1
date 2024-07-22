package net.eletrixgg.testmod;

import net.eletrixgg.testmod.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TestModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack(); //create the pack

		pack.addProvider(ModBlockTagProvider::new); // adds a provider of tags as the mod block tag prov
		pack.addProvider(ModItemTagProvider::new); // adds a provider of tags as the mod item tag prov
		pack.addProvider(ModLootTableProvider::new); // adds a provider of tags as the mod loot table prov
		pack.addProvider(ModModelProvider::new); // adds a provider of tags as the mod model prov
		pack.addProvider(ModRecipeProvider::new); // adds a provider of tags as the mod recipe prov
	}
}
