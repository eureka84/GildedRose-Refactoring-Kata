package com.gildedrose;

public interface UpdateItem {
    void updateItem(Item item);

    boolean canHandle(Item item);
}
