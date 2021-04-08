package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRosesCharacterizationTest {

    @Test
    void sulfurusSellIn() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(10, item.sellIn);
        assertEquals(10, item.quality);
    }

    @Test
    void brieQualityBiggerThanOrEqualTo50() {
        Item item = new Item("Aged Brie", 10, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    void brieQualityLessThan50() {
        Item item = new Item("Aged Brie", 10, 48);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(49, item.quality);
    }

    @Test
    void brieQualityLessThan50AndSellInLessThan0() {
        Item item = new Item("Aged Brie", -1, 48);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(-2, item.sellIn);
        assertEquals(50, item.quality);
    }

}
