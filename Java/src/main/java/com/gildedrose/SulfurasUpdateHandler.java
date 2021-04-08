package com.gildedrose;

public class SulfurasUpdateHandler implements UpdateItemHandler {

    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    @Override
    public boolean canHandle(Item item) {
        return SULFURAS_HAND_OF_RAGNAROS.equals(item.name);
    }

    @Override
    public void handle(Item item) { }
}
