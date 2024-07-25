package net.eletrixgg.testmod.config;

import com.mojang.datafixers.util.Pair;
import net.eletrixgg.testmod.TestMod;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;
// the below values say what the config stuff gonna be (string or stuff etc)
    public static int METALDETMAXDURA; // DO DOUBLE IF YOU WANT TO PUT LETTER AFTER THE VALUE SUCH AS 14F OR 19P or something
    public static int RUBYSWORD_DAMAGE;
    public static int RUBYSWORD_ATTACKDMG;
    public static int MAX_DAMAGE_DOWSING_ROD;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(TestMod.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }
//this is where u add the values then the defaults
    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("metaldetector.max_durability", 64), "Value can only be a number.");
        configs.addKeyValuePair(new Pair<>("rubysword_damage.value", 7), "int");
        configs.addKeyValuePair(new Pair<>("rubysword_attackspeed.value", 5), "Value can only be a number.");
        configs.addKeyValuePair(new Pair<>("dowsing.rod.max.damage", 32), "int");
    }
//THIS AREA ADDS AFTER THE CONFIG SO IT SAYS THE DEFAULT VALUE SO THE BELOW JUST PUTS SOME TEXT AFTER SAYING DEFAULT THEN THE LINE
    private static void assignConfigs() {
        METALDETMAXDURA = CONFIG.getOrDefault("metaldetector.max_durability", 64);
        RUBYSWORD_DAMAGE = CONFIG.getOrDefault("rubysword_damage.value", 7);
        RUBYSWORD_ATTACKDMG = CONFIG.getOrDefault("rubysword_attackspeed.value", 5);
        MAX_DAMAGE_DOWSING_ROD = CONFIG.getOrDefault("dowsing.rod.max.damage", 32);

        System.out.println("[TESTMOD] All " + configs.getConfigsList().size() + " configs have been set properly.");
    }
}