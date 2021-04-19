package com.gildedrose;

public class AgedBrieItem extends Item {

    public AgedBrieItem(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void update() {
        this.increaseQuality();
        this.decreaseSellIn();

        if (this.getSellIn() < 0) {
            this.increaseQuality();
        }
    }
}
