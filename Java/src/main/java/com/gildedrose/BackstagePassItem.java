package com.gildedrose;

public class BackstagePassItem extends Item {

    static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    protected BackstagePassItem(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    @Override
    public void update() {
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
    }
}
