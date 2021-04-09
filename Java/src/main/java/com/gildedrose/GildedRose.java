package com.gildedrose;

class GildedRose {
    Item[] items;

    private final UpdateItem updateAgedBrieItem;
    private final UpdateItem updateBackstageItem;
    private final UpdateItem updateGenericItem;
    private final UpdateItem sulfurasUpdateItem;

    public GildedRose(Item[] items) {
        this.items = items;
        updateAgedBrieItem = new UpdateAgedBrieItem();
        updateBackstageItem = new UpdateBackstageItem();
        updateGenericItem = new UpdateGenericItem();
        sulfurasUpdateItem = new SulfurasUpdateItem();
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        if (sulfurasUpdateItem.canHandle(item)) {
            sulfurasUpdateItem.handle(item);
        }else if (updateAgedBrieItem.canHandle(item)) {
            updateAgedBrieItem.handle(item);
        } else if (updateBackstageItem.canHandle(item)) {
            updateBackstageItem.handle(item);
        } else if(updateGenericItem.canHandle(item)) {
            updateGenericItem.handle(item);
        }
    }

}