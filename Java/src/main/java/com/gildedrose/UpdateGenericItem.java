package com.gildedrose;

class UpdateGenericItem implements UpdateItem {

    @Override
    public boolean canHandle(Item item) {
        return true;
    }

    @Override
    public void handle(Item item) {
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
