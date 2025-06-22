package net.wintercresce.portfoliomod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.wintercresce.portfoliomod.PortfolioMod;

public class ModBlocks {

    public static final String BLOOD_DIAMOND_BLOCK_ID = "blood_diamond_block";


    public static final Block BLOOD_DIAMOND_BLOCK = registerBlock("blood_diamond_block", new Block(AbstractBlock.Settings.create()
            .requiresTool().sounds(BlockSoundGroup.DEEPSLATE)
            .instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(3.0F, 3.0F).registryKey(RegistryKey.of(Registries.BLOCK.getKey(), Identifier.of(PortfolioMod.MOD_ID, BLOOD_DIAMOND_BLOCK_ID)))));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(PortfolioMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(PortfolioMod.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        PortfolioMod.LOGGER.info("Registering the Mod Blocks for " + PortfolioMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
        entries.add(ModBlocks.BLOOD_DIAMOND_BLOCK);
        });
    }
}
