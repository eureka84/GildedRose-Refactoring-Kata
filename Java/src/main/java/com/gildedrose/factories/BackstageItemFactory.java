package com.gildedrose.factories;

import com.gildedrose.items.BackstagePassItem;
import com.gildedrose.items.Item;

public class BackstageItemFactory implements ConditionalItemFactory {
    @Override
    public boolean canHandle(String name) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(name);
    }

    @Override
    public Item create(String name, int sellIn, int quality) {
        return new BackstagePassItem(sellIn, quality);
    }
}
