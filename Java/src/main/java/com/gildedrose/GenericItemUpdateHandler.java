package com.gildedrose;

public class GenericItemUpdateHandler  implements UpdateItemHandler{
    @Override
    public boolean canHandle(Item item) {
        return true;
    }

    @Override
    public void handle(Item item) {
        item.sellIn -= 1;
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }
}
