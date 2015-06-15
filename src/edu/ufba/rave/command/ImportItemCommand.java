package edu.ufba.rave.command;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import edu.ufba.rave.io.AbstractItemImporter;
import edu.ufba.rave.log.Logger;

public class ImportItemCommand implements ICommand {

  private static HashMap<String, AbstractItemImporter> importerHash;

  static {
    importerHash = new HashMap<String, AbstractItemImporter>();

    // importerHash.put("addCategory", new AddCategoryCommand());
  }

  public void execute(Object[] params) {
    if (params.length < 2) {
      Logger.err("Correct usage is <importer type> <import file>.\n");
      return;
    }

    String importerType = params[0].toString();
    String filePath = params[1].toString();

    AbstractItemImporter importer = importerHash.get(importerType);
    File f = new File(filePath);

    try {
      FileInputStream in = new FileInputStream(f);
      boolean res = importer.importItems(in);
      in.close();

      if (res) {
        Logger.info("Items imported with success!\n");
      } else {
        Logger.info("Items was not imported with success!\n");
      }
    } catch (Exception e) {
      Logger.err("The file was not found!\n");
      return;
    }
  }

}

