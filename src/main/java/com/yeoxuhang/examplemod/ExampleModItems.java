package com.yeoxuhang.examplemod;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExampleModItems {


    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);

    public static final RegistryObject<ForgeSpawnEggItem> EXAMPLE_DYEABLE_ENTITY_SPAWN_EGG = ITEMS.register("example_dyeable_entity_spawn_egg",
            () -> new ForgeSpawnEggItem(ExampleModEntityTypes.EXAMPLE_DYEABLE_ENTITY,0, 0,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<ForgeSpawnEggItem> EXAMPLE_CLICK_ENTITY_SPAWN_EGG = ITEMS.register("example_click_entity_spawn_egg",
            () -> new ForgeSpawnEggItem(ExampleModEntityTypes.EXAMPLE_CLICK_ENTITY,0, 0,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}