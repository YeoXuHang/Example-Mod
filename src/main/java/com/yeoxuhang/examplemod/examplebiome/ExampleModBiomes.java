package com.yeoxuhang.examplemod.examplebiome;

import com.yeoxuhang.examplemod.ExampleMod;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;

public class ExampleModBiomes {
    public static final DeferredRegister<Biome> BIOME =
            DeferredRegister.create(ForgeRegistries.BIOMES, ExampleMod.MOD_ID);

    public static final RegistryObject<Biome> EXAMPLE_CAVE_BIOME;

    public static Biome exampleCave() {
        MobSpawnSettings.Builder mobBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeBuilder);
        BiomeDefaultFeatures.monsters(mobBuilder, 100, 25, 100, false);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomeBuilder);
        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DRIPSTONE_CAVES);
        return biome(-1F, 0.5F, mobBuilder, biomeBuilder, music, 4159204);
    }

    static {
        EXAMPLE_CAVE_BIOME = BIOME.register("example_cave_biome", ExampleModBiomes::exampleCave);
    }
    private static Biome biome(float temperature, float downFall, MobSpawnSettings.Builder mobBuilder, BiomeGenerationSettings.Builder generationBuilder, @Nullable Music music, int waterColor) {
        return biome(temperature, downFall, waterColor, 329011, mobBuilder, generationBuilder, music);
    }

    private static Biome biome(float temperature, float downFall, int waterColor, int p_194857_, MobSpawnSettings.Builder mobBuilder, BiomeGenerationSettings.Builder generationBuilder, @Nullable Music music) {
        return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.UNDERGROUND).temperature(temperature).downfall(downFall).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColor).waterFogColor(p_194857_).fogColor(12638463).skyColor(calculateSkyColor(temperature)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build()).mobSpawnSettings(mobBuilder.build()).generationSettings(generationBuilder.build()).build();
    }

    protected static int calculateSkyColor(float temperature) {
        float value = temperature / 3.0F;
        value = Mth.clamp(value, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - value * 0.05F, 0.5F + value * 0.1F, 1.0F);
    }

    public static void register(IEventBus eventBus) {
        BIOME.register(eventBus);
    }
}
