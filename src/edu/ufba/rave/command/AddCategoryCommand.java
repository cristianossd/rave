package edu.ufba.rave.command;

import edu.ufba.rave.instances.CategoriesCtrl;
import edu.ufba.rave.log.Logger;
import edu.ufba.rave.model.Category;

public class AddCategoryCommand implements ICommand {

  public void execute(Object[] params) {
    String categoryName = params[0].toString();

    Category category = new Category(categoryName);
    CategoriesCtrl.getInstance().add(category);
    Logger.info("Category %s added to our database\n", category.getName());
  }

}

