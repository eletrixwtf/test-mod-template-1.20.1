package net.eletrixgg.testmod;

import net.eletrixgg.testmod.datagen.ModBlockTagProvider;
import net.eletrixgg.testmod.datagen.ModItemTagProvider;
import net.eletrixgg.testmod.datagen.ModLootTableProvider;
import net.eletrixgg.testmod.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TestModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack(); //create the pack
//all providers in src/main/java/net/eletrixgg/testmod/datagen (src.main.java.net.eletrixgg.testmod.datagen)
		pack.addProvider(ModBlockTagProvider::new); // adds a provider of tags as the mod block tag prov
		pack.addProvider(ModItemTagProvider::new); // adds a provider of tags as the mod item tag prov
		pack.addProvider(ModLootTableProvider::new); // adds a provider of tags as the mod loot table prov
		pack.addProvider(ModRecipeProvider::new); // adds a provider of tags as the mod recipe prov
	}
}
