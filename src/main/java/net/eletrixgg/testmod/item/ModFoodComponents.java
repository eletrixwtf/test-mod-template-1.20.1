package net.eletrixgg.testmod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent TOMATO = new FoodComponent.Builder().hunger(3).saturationModifier(0.225f) //hunger amount is how much hunger bars will be filled and the saturationmodifier is something idk
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200), 1).build(); // this line says if u want status effect
                                                                                                                // possible status effects will be showed as autocomplete in intellij
                                                                                                                // the first value is for duration and then the second is for chance of u getting effect
}
