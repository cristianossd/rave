package edu.ufba.rave.command;

import edu.ufba.rave.instances.CategoriesCtrl;
import edu.ufba.rave.log.Logger;
import edu.ufba.rave.model.Category;
import edu.ufba.rave.model.Item;
import edu.ufba.rave.model.ItemStorage;

public class AddCategoryToItemCommand implements ICommand {

  public void execute(Object[] params) {
    if (params.length < 2) {
      Logger.err("Parameters usage is <item contant> <category name>.\n");
      return;
    }

    String itemTitle = params[0].toString();
    String categoryName = params[1].toString();

    Category category = CategoriesCtrl.getInstance().get(categoryName);

    if (category == null) {
      Logger.err("Category '%s' does not exists.\n", categoryName);
      return;
    }

    Item item = ItemStorage.getInstance().get(itemTitle);

    if (item == null) {
      Logger.err("Item '%s' does not exists.\n", itemTitle);
      return;
    }

    item.setCategory(category);
    Logger.info("Item %s categorized as %s with success\n", item.getTitle(), category.getName());
  }

}

