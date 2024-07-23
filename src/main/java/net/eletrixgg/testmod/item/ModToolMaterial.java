//© 2024 eletrixgg
// this file is for adding custom tools to the game
// in this instance its adding ruby tools
// ALSO MINING LEVEL THE LEVEL OF THE ITEM SO NETHERITE IS MINING LEVEL 4 AND RUBY IS 5 MEANING ITS HIGHER
// and also this file is a enum java class
package net.eletrixgg.testmod.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial { // if you want to check out the vanilla items and their properties click on ToolMaterial and then press CTRL+H and then double click on ToolMaterials (the net.minecraft.item version not the moditems ver)

    RUBY(5, 3022, 15f, 3.5f, 26, //the first value is mining lvl, second item dura, 3rd mining speed, 4th attackdamage, and 5th enchantability
                 () -> Ingredient.ofItems(ModItems.RUBY)); // the values above are significantly higher than netherite btw
// IF YOU WANT TO ADD ANOTHER MATERIAL THEN YOU JUST HAVE TO COPY AND PASTE THE 2 ABOVE VALUES DONT MAKE ANOTHER WHOLE CLASS AND CHANGE THE DOT COLON TO JUST A COLON
    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attckDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attckDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
