package com.gildedrose;

class UpdateAgedBrieItem implements UpdateItem {

    @Override
    public boolean canHandle(Item item) {
        return item.name.equals("Aged Brie");
    }

    @Override
    public void updateItem(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }
}
