package edu.ufba.rave;

import java.util.HashMap;
import java.util.Scanner;

import edu.ufba.rave.command.AddCategoryCommand;
import edu.ufba.rave.command.AddCategoryToItemCommand;
import edu.ufba.rave.command.AddItemCommand;
import edu.ufba.rave.command.ClassifyItemCommand;
import edu.ufba.rave.command.ExportItemCommand;
import edu.ufba.rave.command.ICommand;
import edu.ufba.rave.command.ImportItemCommand;
import edu.ufba.rave.command.RemoveCategoryCommand;
import edu.ufba.rave.log.Logger;

public class FrameworkRunner {

  private static HashMap<String, ICommand> commandHash;

  static {
    commandHash = new HashMap<String, ICommand>();

    commandHash.put("addCategory", new AddCategoryCommand());
    commandHash.put("removeCategory", new RemoveCategoryCommand());
    commandHash.put("addItem", new AddItemCommand());
    commandHash.put("addCategoryToItem", new AddCategoryToItemCommand());
    commandHash.put("importItem", new ImportItemCommand());
    commandHash.put("exportItem", new ExportItemCommand());
    commandHash.put("classifyItem", new ClassifyItemCommand());
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Logger.configure(System.out);

    System.out.print("Welcome to Rave CLI 0.1 version\nType help for more commands information.\n\n");

    String cmdLine;

    do {
      System.out.print("> ");
      cmdLine = scanner.nextLine();

      boolean successExec = parseAndExecute(cmdLine);

      if (!cmdLine.equals("exit") && !successExec)
        System.out.println("Invalid Command");

    } while (!cmdLine.equals("exit"));

    scanner.close();
  }

  public static boolean parseAndExecute(String cmdLine) {
    String[] cmdParts = cmdLine.split(" ");

    String cmd = cmdParts[0];
    String[] params = new String[cmdParts.length - 1];

    for (int i = 1; i < cmdParts.length; i++) {
      params[i - 1] = cmdParts[i];
    }

    return execute(cmd, params);
  }

  public static boolean execute(String cmd, Object[] params) {
    ICommand command = commandHash.get(cmd);

    if (command == null)
      return false;

    command.execute(params);
    return true;
  }

}

