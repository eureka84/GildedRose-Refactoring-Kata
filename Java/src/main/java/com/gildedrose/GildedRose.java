package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].isAgedBrie()) {
                items[i].increaseQuality();

                items[i].sellIn = items[i].sellIn - 1;

                if (items[i].sellIn < 0) {
                    items[i].increaseQuality();
                }

            } else if (items[i].isBackstagePass()) {
                items[i].increaseQuality();
                if (items[i].sellIn < 11) {
                    items[i].increaseQuality();
                }

                if (items[i].sellIn < 6) {
                    items[i].increaseQuality();
                }
                items[i].sellIn = items[i].sellIn - 1;
                if (items[i].sellIn < 0) {
                    items[i].quality = 0;
                }

            } else if (items[i].isSulfuras()) {

            } else {
                items[i].reduceQuality();
                items[i].sellIn = items[i].sellIn - 1;

                if (items[i].sellIn < 0) {
                    items[i].reduceQuality();
                }
            }

        }
    }
}
