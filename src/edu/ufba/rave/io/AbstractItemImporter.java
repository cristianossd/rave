package edu.ufba.rave.io;

import java.io.InputStream;

import edu.ufba.rave.model.Item;
import edu.ufba.rave.model.ItemStorage;

public abstract class AbstractItemImporter {

  public boolean importItems(InputStream in) {
    try {
      while (!endOfImport(in)) {
        byte[] itemBytes = importItemBytes(in);
        Item nItem = parse(itemBytes);

        ItemStorage.getInstance().add(nItem);
      }
    } catch (Exception e) {
      return false;
    }

    return true;
  }

  public abstract boolean endOfImport(InputStream inStream);

  public abstract byte[] importItemBytes(InputStream inStream);

  public abstract Item parse(byte[] data);

}

