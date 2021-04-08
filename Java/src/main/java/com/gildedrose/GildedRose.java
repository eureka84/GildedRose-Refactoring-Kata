package com.gildedrose;

class GildedRose {
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    Item[] items;

    private UpdateItemHandler[] handlers;

    public GildedRose(Item[] items) {
        this.items = items;
        this.handlers = new UpdateItemHandler[]{
            new AgedBrieUpdateHandler()
        };
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        for (UpdateItemHandler handler : this.handlers) {
            if (handler.canHandle(item)){
                handler.handle(item);
                break;
            }
        }
        switch (item.name) {
            case SULFURAS_HAND_OF_RAGNAROS:
                return;
            case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                updateBackstage(item);
                return;
            default:
                if (!AGED_BRIE.equals(item.name)) {
                    updateGenericItem(item);
                }
                return;
        }
    }

    private void updateGenericItem(Item item) {
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

    private void updateBackstage(Item item) {
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

    private void updateAgedBrie(Item item) {
        item.sellIn -= 1;
        if (item.quality < 50) {
            item.quality += 1;
        }
        if (item.sellIn < 0) {
            item.quality += 1;
        }
    }
}