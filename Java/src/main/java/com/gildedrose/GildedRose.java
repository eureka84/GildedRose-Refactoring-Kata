package com.gildedrose;

class GildedRose {
    Item[] items;

    private final UpdateItem updateAgedBrieItem;
    private final UpdateItem updateBackstageItem;

    public GildedRose(Item[] items) {
        this.items = items;
        updateAgedBrieItem = new UpdateAgedBrieItem();
        updateBackstageItem = new UpdateBackstageItem();
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
        if (updateAgedBrieItem.canHandle(item)) {
            updateAgedBrieItem.handle(item);
        } else if (updateBackstageItem.canHandle(item)) {
            updateBackstageItem.handle(item);
        } else {
            updateGenericItem(item);
        }

    }

    private void updateGenericItem(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }

}