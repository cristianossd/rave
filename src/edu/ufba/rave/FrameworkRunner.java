package edu.ufba.rave;

import java.util.HashMap;
import java.util.Scanner;

import edu.ufba.rave.command.AddCategoryCommand;
import edu.ufba.rave.command.ICommand;
import edu.ufba.rave.command.RemoveCategoryCommand;

public class FrameworkRunner {

  private static HashMap<String, ICommand> commandHash;

  static {
    commandHash = new HashMap<String, ICommand>();

    commandHash.put("addCategory", new AddCategoryCommand());
    commandHash.put("removeCategory", new RemoveCategoryCommand());
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

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
    String[] params = new String[cmdParts.length];

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

