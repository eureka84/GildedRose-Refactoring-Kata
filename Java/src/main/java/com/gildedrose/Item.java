package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    void increaseQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    void decreaseQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    void decreaseSellIn() {
        sellIn = sellIn - 1;
    }

    void resetQuality() {
        quality = 0;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
