package com.gildedrose;

public class ItemFactory {

    static Item create(String name, int sellIn, int quality){
        switch (name){
            case "Aged Brie":
                return new AgedBrieItem(sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassItem(sellIn, quality);
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasItem(sellIn, quality);
            default:
                return new GenericItem(name, sellIn, quality);
        }
    }

}
