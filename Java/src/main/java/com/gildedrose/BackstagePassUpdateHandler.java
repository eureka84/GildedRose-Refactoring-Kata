package com.gildedrose;

public class BackstagePassUpdateHandler implements UpdateItemHandler {

    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    @Override
    public boolean canHandle(Item item) {
        return BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.equals(item.name);
    }

    @Override
    public void handle(Item item) {
        item.sellIn -= 1;
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
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
