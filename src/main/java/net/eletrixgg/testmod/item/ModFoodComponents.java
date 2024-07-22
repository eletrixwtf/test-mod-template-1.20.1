package net.eletrixgg.testmod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent TOMATO = new FoodComponent.Builder().hunger(3).saturationModifier(0.225f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200), 1).build();
}
