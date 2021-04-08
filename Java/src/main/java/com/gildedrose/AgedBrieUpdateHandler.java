package com.gildedrose;

public class AgedBrieUpdateHandler implements UpdateItemHandler {

    private static final String AGED_BRIE = "Aged Brie";

    @Override
    public boolean canHandle(Item item) {
        return AGED_BRIE.equals(item.name);
    }

    @Override
    public void handle(Item item) {
        item.sellIn -= 1;
        if (item.quality < 50) {
            item.quality += 1;
        }
        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality += 1;
            }
        }
    }
}
