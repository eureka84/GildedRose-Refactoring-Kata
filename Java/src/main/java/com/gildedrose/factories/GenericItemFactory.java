package com.gildedrose.factories;

import com.gildedrose.items.GenericItem;
import com.gildedrose.items.Item;

public class GenericItemFactory implements ItemFactory {

    @Override
    public Item create(String name, int sellIn, int quality) {
        return new GenericItem(name, sellIn, quality);
    }
}
