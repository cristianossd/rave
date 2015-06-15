package edu.ufba.rave.command;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

import edu.ufba.rave.io.AbstractItemExporter;
import edu.ufba.rave.log.Logger;

public class ExportItemCommand implements ICommand {

  private static HashMap<String, AbstractItemExporter> exporterHash;

  static {
    exporterHash = new HashMap<String, AbstractItemExporter>();

    // importerHash.put("addCategory", new AddCategoryCommand());
  }

  public void execute(Object[] params) {
    if (params.length < 2) {
      Logger.err("Correct usage is <exporter type> <export file>.\n");
      return;
    }

    String exporterType = params[0].toString();
    String filePath = params[1].toString();

    AbstractItemExporter exporter = exporterHash.get(exporterType);
    File f = new File(filePath);

    try {
      if (!f.createNewFile()) throw new Exception();

      FileOutputStream out = new FileOutputStream(f);
      boolean res = exporter.exportItems(out);
      out.close();

      if (res) {
        Logger.info("Items exported with success!\n");
      } else {
        Logger.info("Items was not exported with success!\n");
      }
    } catch (Exception e) {
      Logger.err("The file was not found!\n");
      return;
    }
  }

}

