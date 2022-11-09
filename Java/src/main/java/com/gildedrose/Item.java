package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    protected Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static Item create(String name, int sellIn, int quality) {
        switch (name) {
            case SulfurasItem.NAME:
                return new SulfurasItem(sellIn, quality);
            case AgedBrieItem.NAME:
                return new AgedBrieItem(sellIn, quality);
            default:
                return new Item(name, sellIn, quality);
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    private boolean isBackstagePass() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    protected void increaseQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    private void reduceQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    public void update() {
        if (isBackstagePass()) {
            increaseQuality();
            if (sellIn < 11) {
                increaseQuality();
            }

            if (sellIn < 6) {
                increaseQuality();
            }
            sellIn = sellIn - 1;
            if (sellIn < 0) {
                quality = 0;
            }

        } else {
            reduceQuality();
            sellIn = sellIn - 1;

            if (sellIn < 0) {
                reduceQuality();
            }
        }
    }
}
