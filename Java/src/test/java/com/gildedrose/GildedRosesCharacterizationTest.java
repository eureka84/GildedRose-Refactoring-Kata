package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRosesCharacterizationTest {

    @Test
    @DisplayName("Sulfuras stay unchanged")
    void sulfuras() {
        Item item = Item.create("Sulfuras, Hand of Ragnaros", 10, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(10, item.sellIn);
        assertEquals(10, item.quality);
    }

    @Test
    @DisplayName("Aged Brie with quality over 50 and sellIn over 0")
    void brie1() {
        Item item = Item.create("Aged Brie", 10, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    @DisplayName("Aged Brie with quality under 50 and sellIn over 0")
    void brie2() {
        Item item = Item.create("Aged Brie", 10, 48);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(49, item.quality);
    }

    @Test
    @DisplayName("Aged Brie with quality under 50 and sellIn under 0")
    void brie3() {
        Item item = Item.create("Aged Brie", -1, 48);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(-2, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    @DisplayName("Aged Brie with quality 50 and sellIn under 0")
    void brie4() {
        Item item = Item.create("Aged Brie", -1, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(-2, item.sellIn);
        assertEquals(50, item.quality);
    }


    @Test
    @DisplayName("Backstage pass with quality over 50")
    void backstage1() {
        Item item = Item.create("Backstage passes to a TAFKAL80ETC concert", 10, 50);

        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    @DisplayName("Backstage pass with quality under 50 and sellIn over 10")
    void backstage2() {
        Item item = Item.create("Backstage passes to a TAFKAL80ETC concert", 11, 49);

        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(10, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    @DisplayName("Backstage pass with quality 49 and sellIn between 6 and 10")
    void backstage3() {
        Item item = Item.create("Backstage passes to a TAFKAL80ETC concert", 6, 49);

        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(5, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    @DisplayName("Backstage pass with quality under 49 and sellIn between 6 and 10")
    void backstage4() {
        Item item = Item.create("Backstage passes to a TAFKAL80ETC concert", 6, 48);

        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(5, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    @DisplayName("Backstage pass with quality 49 and sellIn under 6")
    void backstage5() {
        Item item = Item.create("Backstage passes to a TAFKAL80ETC concert", 5, 48);

        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(4, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    @DisplayName("Backstage pass with quality 48 and sellIn under 6")
    void backstage6() {
        Item item = Item.create("Backstage passes to a TAFKAL80ETC concert", 5, 48);

        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(4, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    @DisplayName("Backstage pass with quality under 48 and sellIn under 6")
    void backstage7() {
        Item item = Item.create("Backstage passes to a TAFKAL80ETC concert", 5, 14);

        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(4, item.sellIn);
        assertEquals(17, item.quality);
    }

    @Test
    @DisplayName("Backstage pass with sellIn below 0")
    void backstage8() {
        Item item = Item.create("Backstage passes to a TAFKAL80ETC concert", -1, 14);

        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(-2, item.sellIn);
        assertEquals(0, item.quality);
    }
    @Test
    @DisplayName("Backstage pass sellIn temporal coupling")
    void backstage9() {
        Item item = Item.create("Backstage passes to a TAFKAL80ETC concert", 11, 24);

        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(10, item.sellIn);
        assertEquals(25, item.quality);
    }

    @Test
    @DisplayName("Generic item with sellIn and quality greater than 0")
    void generic1() {
        Item item = Item.create("An Item", 10, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(9, item.quality);
    }

    @Test
    @DisplayName("Generic item with sellIn > 0 and quality 0")
    void generic2() {
        Item item = Item.create("An Item", 10, 0);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    @DisplayName("Generic item with sellIn < 0 and quality > 0")
    void generic3() {
        Item item = Item.create("An Item", -1, 10);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(-2, item.sellIn);
        assertEquals(8, item.quality);
    }
}
