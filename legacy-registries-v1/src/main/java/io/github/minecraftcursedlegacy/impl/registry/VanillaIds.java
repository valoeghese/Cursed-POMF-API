/*
 * Copyright (c) 2020 The Cursed Legacy Team.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package io.github.minecraftcursedlegacy.impl.registry;

import static net.minecraft.item.ItemType.*;
import static net.minecraft.tile.Tile.*;

import java.util.HashMap;
import java.util.Map;

import io.github.minecraftcursedlegacy.accessor.registry.AccessorCompoundTag;
import io.github.minecraftcursedlegacy.api.registry.Id;
import net.minecraft.item.ItemType;
import net.minecraft.tile.Tile;
import net.minecraft.util.io.CompoundTag;

/**
 * Vanilla ids and compat for older api versions.
 * Most names are autogenerated from a script which can be found in the source code.
 * @since 1.1.0
 */
class VanillaIds {
	private static final Map<Tile, Id> TILE_IDS = new HashMap<>();
	private static final Map<ItemType, Id> ITEM_IDS = new HashMap<>();

	private static final Map<Id, Id> TILE_LEGACY_COMPAT = new HashMap<>();
	private static final Map<Id, Id> ITEM_LEGACY_COMPAT = new HashMap<>();

	static Id getVanillaId(Tile tile) {
		return TILE_IDS.get(tile);
	}

	// do not use with tile items, instead look up the tile and call getVanillaId(Tile)
	static Id getVanillaId(ItemType item) {
		return ITEM_IDS.get(item);
	}

	static Id correctLegacyTileId(Id existing) {
		return TILE_LEGACY_COMPAT.getOrDefault(existing, existing);
	}

	static Id correctLegacyItemId(Id existing) {
		return ITEM_LEGACY_COMPAT.getOrDefault(existing, existing);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	static void fixOldIds(CompoundTag registryData, boolean tile) {
		Map data = ((AccessorCompoundTag) registryData).getData();

		for (Map.Entry<Id, Id> idPair : (tile ? TILE_LEGACY_COMPAT : ITEM_LEGACY_COMPAT).entrySet()) {
			String key = idPair.getKey().toString();

			if (data.containsKey(key)) { // swap key to new one
				data.put(idPair.getValue().toString(), data.remove(key));
			}
		}
	}

	static void initialiseTiles() {
		// ===========
		//    Tiles
		// ===========

		// The first few ids
		set(STONE, "stone");
		set(GRASS, "grass");
		set(DIRT, "dirt");
		set(COBBLESTONE, "cobblestone");
		set(WOOD, "planks"); // Making it different due to the game calling it thus.
		set(SAPLING, "sapling");
		set(BEDROCK, "bedrock");

		// Fluids
		set(FLOWING_WATER, "flowing_water");
		set(STILL_WATER, "water"); // this is basically convention
		set(FLOWING_LAVA, "flowing_lava");
		set(STILL_LAVA, "lava");

		// Let's continue
		set(SAND, "sand");
		set(GRAVEL, "gravel");
		set(GOLD_ORE, "gold_ore");
		set(IRON_ORE, "iron_ore");
		set(COAL_ORE, "coal_ore");
		set(LOG, "log");
		set(LEAVES, "leaves");
		set(SPONGE, "sponge");
		set(GLASS, "glass");
		set(LAPIS_LAZULI_ORE, "lapis_lazuli_ore");
		set(LAPIS_LAZULI_BLOCK, "lapis_lazuli_block");
		set(DISPENSER, "dispenser");
		set(SANDSTONE, "sandstone");
		set(NOTEBLOCK, "noteblock");
		set(BED, "bed");
		set(GOLDEN_RAIL, "powered_rail");
		set(DETECTOR_RAIL, "detector_rail");
		set(STICKY_PISTON, "sticky_piston");
		set(WEB, "web");
		set(TALLGRASS, "tallgrass");
		set(DEADBUSH, "deadbush");
		set(PISTON, "piston");
		set(PISTON_HEAD, "piston_head");
		set(WOOL, "wool");
		set(MOVING_PISTON, "moving_piston");
		set(DANDELION, "dandelion");
		set(ROSE, "rose");
		set(BROWN_MUSHROOM, "brown_mushroom");
		set(RED_MUSHROOM, "red_mushroom");
		set(BLOCK_GOLD, "block_gold");
		set(BLOCK_IRON, "block_iron");
		set(DOUBLE_STONE_SLAB, "double_stone_slab");
		set(STONE_SLAB, "stone_slab");
		set(BRICK, "brick");
		set(TNT, "tnt");
		set(BOOKSHELF, "bookshelf");
		set(MOSSY_COBBLESTONE, "mossy_cobblestone");
		set(OBSIDIAN, "obsidian");
		set(TORCH, "torch");
		set(FIRE, "fire");
		set(MOB_SPAWNER, "mob_spawner");
		set(STAIRS_WOOD, "wooden_stairs");
		set(CHEST, "chest");
		set(REDSTONE_DUST, "redstone_dust");
		set(DIAMOND_ORE, "diamond_ore");
		set(BLOCK_DIAMOND, "diamond_block");
		set(WORKBENCH, "workbench");
		set(CROPS, "crops");
		set(FARMLAND, "farmland");
		set(FURNACE, "furnace");
		set(FURNACE_LIT, "lit_furnace");
		set(STANDING_SIGN, "standing_sign");
		set(DOOR_WOOD, "wooden_door");
		set(LADDER, "ladder");
		set(RAIL, "rail");
		set(STAIRS_STONE, "stone_stairs");
		set(WALL_SIGN, "wall_sign");
		set(LEVER, "lever");
		set(WOODEN_PRESSURE_PLATE, "wooden_pressure_plate");
		set(DOOR_IRON, "iron_door");
		set(STONE_PRESSURE_PLATE, "stone_pressure_plate");
		set(REDSTONE_ORE, "redstone_ore");
		set(REDSTONE_ORE_LIT, "lit_redstone_ore");
		set(REDSTONE_TORCH, "redstone_torch");
		set(REDSTONE_TORCH_LIT, "lit_redstone_torch");
		set(BUTTON, "button");
		set(SNOW, "snow");
		set(ICE, "ice");
		set(SNOW_BLOCK, "snow_block");
		set(CACTUS, "cactus");
		set(CLAY, "clay");
		set(REEDS, "reeds");
		set(JUKEBOX, "jukebox");
		set(FENCE, "fence");
		set(PUMPKIN, "pumpkin");
		set(NETHERRACK, "netherrack");
		set(SOUL_SAND, "soul_sand");
		set(GLOWSTONE, "glowstone");
		set(PORTAL, "portal");
		set(LIT_PUMPKIN, "lit_pumpkin");
		set(CAKE, "cake");
		set(REDSTONE_REPEATER, "redstone_repeater");
		set(REDSTONE_REPEATER_LIT, "lit_redstone_repeater");
		set(LOCKED_CHEST, "locked_chest");
		set(TRAPDOOR, "trapdoor");
	}

	static void initialiseItems() {
		// ===========
		//    Items
		// ===========

		set(shovelIron, "iron_shovel");
		set(pickaxeIron, "iron_pickaxe");
		set(hatchetIron, "iron_axe");
		set(flintAndSteel, "flint_and_steel");
		set(apple, "apple");
		set(bow, "bow");
		set(arrow, "arrow");
		set(coal, "coal");
		set(diamond, "diamond");
		set(ingotIron, "iron_ingot");
		set(ingotGold, "gold_ingot");
		set(swordIron, "iron_sword");
		set(swordWood, "wooden_sword");
		set(shovelWood, "wooden_shovel");
		set(pickaxeWood, "wooden_pickaxe");
		set(hatchetWood, "wooden_hatchet");
		set(swordStone, "stone_sword");
		set(shovelStone, "stone_shovel");
		set(pickaxeStone, "stone_pickaxe");
		set(hatchetStone, "stone_hatchet");
		set(swordDiamond, "sword_diamond");
		set(shovelDiamond, "shovel_diamond");
		set(pickaxeDiamond, "diamond_pickaxe");
		set(hatchetDiamond, "diamond_hatchet");
		set(stick, "stick");
		set(bowl, "bowl");
		set(mushroomStew, "mushroom_stew");
		set(swordGold, "gold_sword");
		set(shovelGold, "gold_shovel");
		set(pickaxeGold, "gold_pickaxe");
		set(hatchetGold, "gold_hatchet");
		set(string, "string");
		set(feather, "feather");
		set(sulphur, "sulphur");
		set(hoeWood, "wooden_hoe");
		set(hoeStone, "stone_hoe");
		set(hoeIron, "iron_hoe");
		set(hoeDiamond, "diamond_hoe");
		set(hoeGold, "gold_hoe");
		set(seeds, "seeds");
		set(wheat, "wheat");
		set(bread, "bread");
		set(helmetCloth, "cloth_helmet");
		set(chestplateCloth, "cloth_chestplate");
		set(leggingsCloth, "cloth_leggings");
		set(bootsCloth, "cloth_boots");
		set(helmetChain, "chain_helmet");
		set(chestplateChain, "chain_chestplate");
		set(leggingsChain, "chain_leggings");
		set(bootsChain, "chain_boots");
		set(helmetIron, "iron_helmet");
		set(chestplateIron, "iron_chestplate");
		set(leggingsIron, "iron_leggings");
		set(bootsIron, "iron_boots");
		set(helmetDiamond, "diamond_helmet");
		set(chestplateDiamond, "diamond_chestplate");
		set(leggingsDiamond, "diamond_leggings");
		set(bootsDiamond, "diamond_boots");
		set(helmetGold, "gold_helmet");
		set(chestplateGold, "gold_chestplate");
		set(leggingsGold, "gold_leggings");
		set(bootsGold, "gold_boots");
		set(flint, "flint");
		set(porkchopRaw, "raw_porkchop");
		set(porkchopCooked, "cooked_porkchop");
		set(painting, "painting");
		set(appleGold, "gold_apple");
		set(sign, "sign");
		set(doorWood, "wooden_door");
		set(bucket, "bucket");
		set(bucketWater, "water_bucket");
		set(bucketLava, "lava_bucket");
		set(minecart, "minecart");
		set(saddle, "saddle");
		set(doorIron, "iron_door");
		set(redstone, "redstone");
		set(snowball, "snowball");
		set(boat, "boat");
		set(leather, "leather");
		set(milk, "milk");
		set(brick, "brick");
		set(clay, "clay");
		set(reeds, "reeds");
		set(paper, "paper");
		set(book, "book");
		set(slimeball, "slimeball");
		set(minecartChest, "minecart_chest");
		set(minecartFurnace, "minecart_furnace");
		set(egg, "egg");
		set(compass, "compass");
		set(fishingRod, "fishing_rod");
		set(clock, "clock");
		set(yellowDust, "glowstone_dust");
		set(fishRaw, "raw_fish");
		set(fishCooked, "cooked_fish");
		set(dyePowder, "dye_powder");
		set(bone, "bone");
		set(sugar, "sugar");
		set(cake, "cake");
		set(bed, "bed");
		set(diode, "redstone_repeater");
		set(cookie, "cookie");
		set(map, "map");
		set(shears, "shears");
		set(record_13, "record_13");
		set(record_cat, "record_cat");
	}

	private static void set(Tile tile, String id) {
		Id id_ = new Id(id);
		TILE_IDS.put(tile, id_);

		// legacy
		String idPart = tile.method_1597();

		if (idPart == null) {
			idPart = "tile";
		} else {
			idPart = idPart.substring(5); // remove "tile."
		}

		Id legacy = new Id(idPart + "_" + tile.id);

		TILE_LEGACY_COMPAT.put(legacy, id_);
		ITEM_LEGACY_COMPAT.put(legacy, id_); // for tile items
	}

	private static void set(ItemType item, String id) {
		Id id_ = new Id(id);
		ITEM_IDS.put(item, id_);

		// legacy
		String idPart = item.getTranslationKey();

		if (idPart == null) {
			idPart = "itemtype";
		} else {
			idPart = idPart.substring(5); // remove "item."
		}

		ITEM_LEGACY_COMPAT.put(new Id(idPart + "_" + item.id), id_);
	}
}
