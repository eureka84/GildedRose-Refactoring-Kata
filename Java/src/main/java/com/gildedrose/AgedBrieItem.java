package com.gildedrose;

public class AgedBrieItem extends Item {

    static final String NAME = "Aged Brie";

    protected AgedBrieItem(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    @Override
    public void update() {
        increaseQuality();

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            increaseQuality();
        }
    }
}
