package net.eletrixgg.testmod.datagen;

import net.eletrixgg.testmod.block.ModBlocks;
import net.eletrixgg.testmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //Models for the blocks (normal cube all)
blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK);
blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_RUBY_BLOCK);
blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_RUBY_ORE);
blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_RUBY_ORE);
blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_RUBY_ORE);
blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);
    }

    @Override //and generating the items
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_RUBY, Models.GENERATED);

    itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED);
    itemModelGenerator.register(ModItems.FINE_COAL, Models.GENERATED);
    itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);
    }
}
