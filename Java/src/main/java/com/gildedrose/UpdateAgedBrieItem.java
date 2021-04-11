package com.gildedrose;

class UpdateAgedBrieItem implements UpdateItem {

    @Override
    public boolean canHandle(Item item) {
        return item.name.equals("Aged Brie");
    }

    @Override
    public void handle(Item item) {
        item.increaseQuality();
        item.decreaseSellIn();

        if (item.sellIn < 0) {
            item.increaseQuality();
        }
    }

}
