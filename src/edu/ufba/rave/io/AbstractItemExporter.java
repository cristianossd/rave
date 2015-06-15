package edu.ufba.rave.io;

import java.io.OutputStream;
import java.util.ArrayList;

import edu.ufba.rave.model.Item;
import edu.ufba.rave.model.ItemStorage;

public abstract class AbstractItemExporter {

  public boolean exportItems(OutputStream out) {
    ArrayList<Item> items = ItemStorage.getInstance().getAll();

    for (Item item:items) {
      if (item.getCategory() == null) continue;

      byte[] itemData = parse(item);
      boolean res = exportItem(out, itemData);

      if (!res) return false;
    }

    return true;
  }

  public abstract byte[] parse(Item i);

  public abstract boolean exportItem(OutputStream out, byte[] itemData);

}

