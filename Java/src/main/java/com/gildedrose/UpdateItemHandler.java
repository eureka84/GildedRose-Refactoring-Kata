package com.gildedrose;

public interface UpdateItemHandler {

    boolean canHandle(Item item);
    void handle(Item item);

}
