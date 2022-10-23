package com.yeoxuhang.examplemod.examplebiome.util;

import com.mojang.datafixers.util.Pair;
import com.yeoxuhang.examplemod.examplebiome.ExampleModBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;

import java.util.function.Consumer;

public class BiomeReagentHandler {
    public static final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);
    public static final Climate.Parameter CAVE_BIOME_RANGE = Climate.Parameter.span(0.2F, 0.9F);
    public static final Climate.ParameterPoint EXAMPLE_CAVE_PARAMETER;

    public BiomeReagentHandler() {
    }

    public static void init(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
        consumer.accept(Pair.of(EXAMPLE_CAVE_PARAMETER, ExampleModBiomes.EXAMPLE_CAVE_BIOME.getKey()));
    }

    static {
        EXAMPLE_CAVE_PARAMETER = Climate.parameters(Climate.Parameter.span(-1.0F, -0.45F), Climate.Parameter.span(-1.0F, -0.35F), Climate.Parameter.span(0.03F, 0.3F), Climate.Parameter.span(-0.2225F, 0.45F), CAVE_BIOME_RANGE, FULL_RANGE, 0.0F);
    }
}
