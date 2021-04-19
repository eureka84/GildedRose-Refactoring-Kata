package com.gildedrose;

public class GenericItem extends Item {

    public GenericItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        this.decreaseQuality();
        this.decreaseSellIn();

        if (this.getSellIn() < 0) {
            this.decreaseQuality();
        }
    }
}
