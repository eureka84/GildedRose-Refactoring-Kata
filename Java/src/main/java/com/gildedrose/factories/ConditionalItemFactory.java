package com.gildedrose.factories;

public interface ConditionalItemFactory extends ItemFactory {

    boolean canHandle(String name);

}
