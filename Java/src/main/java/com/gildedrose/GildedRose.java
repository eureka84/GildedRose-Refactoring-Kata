package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        if (item.name.equals("Aged Brie")) {
            updateAgedBrie(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            updateBackstagePass(item);
        } else {
            updateGenericItem(item);
        }

    }

    private void updateGenericItem(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        updateSellIn(item);
    }

    private void updateBackstagePass(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
        updateSellIn(item);
    }

    private void updateAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        updateSellIn(item);
    }

    private void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.name.equals("Aged Brie")) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item.quality = 0;
            } else {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }

            }
        }
    }
}