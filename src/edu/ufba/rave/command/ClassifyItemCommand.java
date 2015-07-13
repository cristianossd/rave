package edu.ufba.rave.command;

import java.util.HashMap;

import edu.ufba.rave.classifiers.ClassifyStrategy;
import edu.ufba.rave.log.Logger;
import edu.ufba.rave.model.Category;
import edu.ufba.rave.model.Item;
import edu.ufba.rave.model.ItemStorage;

public class ClassifyItemCommand implements ICommand {

  private static HashMap<String, ClassifyStrategy> classifierHash;

  static {
    classifierHash = new HashMap<String, ClassifyStrategy>();
  }

  public void execute(Object[] params) {

    if (params.length < 2) {
      Logger.err("Parameters usage is <classifier name> <item title>.\n");
      return;
    }

    String classifierName = params[0].toString();
    String itemTitle = params[1].toString();

    ClassifyStrategy classifier = classifierHash.get(classifierName);
    Item item = ItemStorage.getInstance().get(itemTitle);

    if (item == null) {
      Logger.err("Item '%s' does not exists.\n", itemTitle);
      return;
    }

    if (classifier == null) {
      Logger.err("Classifier '%s' does not exists.\n", classifierName);
      return;
    }

    Category category = classifier.classify(item);

    item.setCategory(category);

    Logger.info("Item %s categorized as %s with success\n", item.getTitle(), category.getName());
  }

}
