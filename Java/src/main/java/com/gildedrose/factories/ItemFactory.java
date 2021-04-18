package com.gildedrose.factories;

import com.gildedrose.items.Item;

public interface ItemFactory {
    Item create(String name, int sellIn, int quality);
}
