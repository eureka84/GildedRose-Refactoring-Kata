package com.gildedrose;

class GildedRose {

    Item[] items;

    private final UpdateItem[] updateItems;

    public GildedRose(Item[] items) {
        this.items = items;

        updateItems = new UpdateItem[]{
                new UpdateSulfurasItem(),
                new UpdateAgedBrieItem(),
                new UpdateBackstageItem(),
                new UpdateGenericItem()
        };
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        for (UpdateItem updateItem : updateItems) {
            if (updateItem.canHandle(item)){
                updateItem.handle(item);
                return;
            }
        }
    }

}