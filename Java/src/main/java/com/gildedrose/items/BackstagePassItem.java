package com.gildedrose.items;

public class BackstagePassItem extends Item {

    public BackstagePassItem(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    public void update() {
        this.increaseQuality();

        if (this.getSellIn() < 11) {
            this.increaseQuality();
        }

        if (this.getSellIn() < 6) {
            this.increaseQuality();
        }

        this.decreaseSellIn();

        if (this.getSellIn() < 0) {
            this.resetQuality();
        }
    }
}
