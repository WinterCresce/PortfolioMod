package net.wintercresce.portfoliomod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.wintercresce.portfoliomod.PortfolioMod;

public class ModItems {

    public static final Item BLOOD_DIAMOND = registerItem( "blood_diamond", new Item(register(new Item.Settings(), "blood_diamond"))) ;

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of("portfoliomod", name), item);
    }


    private static Item register(Item.Settings itemSettings, String name) {
        Identifier id = Identifier.of(PortfolioMod.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings settings = itemSettings.registryKey(key);

        return Registry.register(Registries.ITEM, key, new Item(settings));
    }

    public static void registerModItems() {
        PortfolioMod.LOGGER.info("registering mod items for" + PortfolioMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(BLOOD_DIAMOND);
        });
    }
}
