package com.gildedrose.factories;

import com.gildedrose.items.AgedBrieItem;
import com.gildedrose.items.Item;

public class AgedBrieFactory implements ConditionalItemFactory {

    @Override
    public boolean canHandle(String name) {
        return "Aged Brie".equals(name);
    }

    @Override
    public Item create(String name, int sellIn, int quality) {
        return new AgedBrieItem(sellIn, quality);
    }
}
