package com.gildedrose;

public interface UpdateItem {

    void handle(Item item);

    boolean canHandle(Item item);

}
