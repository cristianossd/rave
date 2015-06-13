package edu.ufba.rave.command;

import edu.ufba.rave.log.Logger;
import edu.ufba.rave.model.Item;
import edu.ufba.rave.model.ItemStorage;

public class AddItemCommand implements ICommand {

  public void execute(Object[] params) {
    if (params.length < 2) {
      Logger.err("Correct usage is <item title> <item content>.\n");
      return;
    }

    String itemTitle = params[0].toString();
    String content = "";

    for (int i = 1; i < params.length; i++) {
      content += params[i] + " ";
    }

    String itemContent = content;

    Item item = new Item();

    item.setTitle(itemTitle);
    item.setContent(itemContent);

    ItemStorage.getInstance().add(item);

    Logger.info("Item '%s' added to our database\n", item.getTitle());
  }

}
