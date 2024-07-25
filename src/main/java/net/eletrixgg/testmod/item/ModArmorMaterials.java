// 2024 eletrixgg
// THIS FILE ADDS CUSTOM ARMOR TO THE GAME (YOU STILL NEED TO ADD OTHER STUFF IN OTHER FILES BTW)
// THIS FILE IS ALSO A JAVA CLASS ENUM
// IN THIS CASE THIS FILE ADDS CUSTOM RUBY ARMOR
// YOU DONT NEED TO MAKE MORE CLASSES FOR DIFFERENT ARMOR TYPES BTW
// this file is basically like the modtoolmaterial
package net.eletrixgg.testmod.item;

import net.eletrixgg.testmod.TestMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial { // if you want to check out the vanilla armor sets and their properties click on ArmorMaterial and then press CTRL+H and then double click on ArmorMaterials (the net.minecraft.item version not the moditems ver) and the code is a bit strange there
    RUBY("ruby", 25, new int[] { 3, 8, 6 ,3 }, 19,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3f, 0.2f, () -> Ingredient.ofItems(ModItems.RUBY)); //THE SOUND EVENTS IS THE SOUND ITS GONNA PLAY WHEN U EQUIP THE ARMOR, THEN TOUGHNESS OF THE ARMOR, THEN KNOCKBACK RESISTANCE, THEN THE INGREDIENT OF THE ARMOR WHICH IS RUBY
    // IF YOU WANT TO ADD ANOTHER ARMOR SET THEN YOU JUST HAVE TO COPY AND PASTE THE 2 ABOVE LINES ABOVE DONT MAKE ANOTHER WHOLE CLASS AND CHANGE THE DOT COLON TO JUST A COLON
    ;
    //THIS ADDS THE STUFF YOU NEED THIS WHEN MAKING ARMOR
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = {11, 16, 15, 13}; //the durability amounts based on the piece of armor (helmet, chestplate, leggings then boots)

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound,
                      float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier; // this is going to basically select a certain durablility and depending on the type of armor piece (helmet chestplate etc) gives a durability (its stated above) and then times by the durability multiplier which is also stated above
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return TestMod.MOD_ID + ":" + this.name; //THIS IS REALLY IMPORTANT BECAUSE IF YOU DONT DO THIS ITS GONNA PLACE THE TEXTURES NOT UNDER THE MOD ID
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}