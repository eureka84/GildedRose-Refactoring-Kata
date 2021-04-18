package com.gildedrose.factories;

import com.gildedrose.items.*;

public class ChainedItemFactory implements ItemFactory {

    private ConditionalItemFactory[] factories;
    private ItemFactory defaultFactory;

    public ChainedItemFactory() {
        factories = new ConditionalItemFactory[] {
                new AgedBrieFactory(),
                new BackstageItemFactory(),
                new SulfurasItemFactory()
        };
        defaultFactory = new GenericItemFactory();
    }

    @Override
    public Item create(String name, int sellIn, int quality) {
        for (ConditionalItemFactory factory : factories) {
            if (factory.canHandle(name)){
                return factory.create(name, sellIn, quality);
            }
        }
        return defaultFactory.create(name, sellIn, quality);
    }

}
