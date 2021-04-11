package com.gildedrose;

class UpdateSulfurasItem implements UpdateItem {

    @Override
    public boolean canHandle(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    @Override
    public void handle(Item item) { }

}
