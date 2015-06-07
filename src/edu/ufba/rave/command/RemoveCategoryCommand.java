package edu.ufba.rave.command;

import edu.ufba.rave.instances.CategoriesCtrl;

public class RemoveCategoryCommand implements ICommand {

  public void execute(Object[] params) {
    String categoryName = params[0].toString();

    CategoriesCtrl.getInstance().remove(categoryName);
  }

}

