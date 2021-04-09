package com.gildedrose;

class GildedRose {
    Item[] items;

    private final UpdateItem updateAgedBrieItem;
    private final UpdateItem updateBackstageItem;
    private final UpdateItem updateGenericItem;

    public GildedRose(Item[] items) {
        this.items = items;
        updateAgedBrieItem = new UpdateAgedBrieItem();
        updateBackstageItem = new UpdateBackstageItem();
        updateGenericItem = new UpdateGenericItem();
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
        } else if(updateGenericItem.canHandle(item)) {
            updateGenericItem.handle(item);
        }

    }

}