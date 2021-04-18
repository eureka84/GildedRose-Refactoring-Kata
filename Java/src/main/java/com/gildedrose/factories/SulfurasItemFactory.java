package com.gildedrose.factories;

import com.gildedrose.items.Item;
import com.gildedrose.items.SulfurasItem;

public class SulfurasItemFactory implements ConditionalItemFactory {
    @Override
    public boolean canHandle(String name) {
        return "Sulfuras, Hand of Ragnaros".equals(name);
    }

    @Override
    public Item create(String name, int sellIn, int quality) {
        return new SulfurasItem(sellIn, quality);
    }
}
