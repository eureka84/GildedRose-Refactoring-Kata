package com.gildedrose;

class GildedRose {

    Item[] items;

    private UpdateItemHandler[] handlers;

    public GildedRose(Item[] items) {
        this.items = items;
        this.handlers = new UpdateItemHandler[]{
                new AgedBrieUpdateHandler(),
                new BackstagePassUpdateHandler(),
                new SulfurasUpdateHandler(),
                new GenericItemUpdateHandler()
        };
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        for (UpdateItemHandler handler : this.handlers) {
            if (handler.canHandle(item)) {
                handler.handle(item);
                break;
            }
        }
    }

}