package net.eletrixgg.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.eletrixgg.testmod.block.ModBlocks;
import net.eletrixgg.testmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(ModItems.RAW_RUBY, //defines list kind of like defining idk
            ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE, ModBlocks.END_STONE_RUBY_ORE); //literally just smeltable list

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, //normal furnace using ruby smeltables list
                0.7f, 200, "ruby");
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, //blast furnace using ruby smeltables list
                0.7f, 100, "ruby");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.DECORATIONS,
                ModBlocks.RUBY_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_RUBY, 1) //crafting recipe for the 9x9 ruby to ruby block
                .pattern("SSS")
                .pattern("SRS")
                .pattern("SSS")
                .input('S', Items.STONE) //the s above in the pattern is stone
                .input('R', ModItems.RUBY) //the r above in the pattern is ruby
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE)) //if the player has stone in inventory then unlock the recipe
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY)) //if the player has ruby in inventory unlock recipe
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_RUBY)));
    }
}
//IMPORTANT TO NOTE: YOU NEEDS TO ALWAYS RUN DATA GENERATOR AFTER ADDING ITEMS SO THE JSONS GENERATE