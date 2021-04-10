package com.gildedrose;

class UpdateGenericItem implements UpdateItem {

    @Override
    public boolean canHandle(Item item) {
        return true;
    }

    @Override
    public void handle(Item item) {
        item.decreaseQuality();
        item.decreaseSellIn();

        if (item.sellIn < 0) {
            item.decreaseQuality();
        }
    }

}
