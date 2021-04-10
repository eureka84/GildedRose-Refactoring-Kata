package com.gildedrose;

class UpdateBackstageItem implements UpdateItem {

    @Override
    public boolean canHandle(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    @Override
    public void handle(Item item) {
        item.increaseQuality();

        if (item.sellIn < 11) {
            item.increaseQuality();
        }

        if (item.sellIn < 6) {
            item.increaseQuality();
        }

        item.decreaseSellIn();

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
