package edu.ufba.rave.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class ItemStorage {

  private static ItemStorage instance;
  private HashMap<String, Item> itemHash;

  public static ItemStorage getInstance() {
    if (instance == null)
      instance = new ItemStorage();

    return instance;
  }

  private ItemStorage() {
    itemHash = new HashMap<String, Item>();
  }

  public void add(Item item) {
    itemHash.put(item.getTitle(), item);
  }

  public boolean remove(String itemName) {
    return itemHash.remove(itemName) != null;
  }

  public Item get(String itemName) {
    return itemHash.get(itemName);
  }

  public ArrayList<Item> getAll() {
    ArrayList<Item> items = new ArrayList<Item>();

    for (Entry<String, Item> entry:itemHash.entrySet()) {
      items.add(entry.getValue());
    }

    return items;
  }

}

