package com.gildedrose;

class UpdateBackstageItem implements UpdateItem {

    @Override
    public boolean canHandle(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    @Override
    public void handle(Item item) {
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
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
