package edu.ufba.rave.command;

import edu.ufba.rave.instances.CategoriesCtrl;
import edu.ufba.rave.log.Logger;

public class RemoveCategoryCommand implements ICommand {

  public void execute(Object[] params) {
    String categoryName = params[0].toString();

    boolean result = CategoriesCtrl.getInstance().remove(categoryName);

    if (result) {
      Logger.info("Category %s removed with success.\n", categoryName);
    } else {
      Logger.err("Category %s is not a valid category.\n", categoryName);
    }
  }

}

