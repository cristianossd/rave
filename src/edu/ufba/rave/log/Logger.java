package edu.ufba.rave.log;

import java.io.PrintStream;

public class Logger {

  private static PrintStream info, warn, err, debug;

  public static void configure(PrintStream out) {
    Logger.info = Logger.warn = Logger.err = Logger.debug = out;
  }

  public static void info(String msg, Object ... args) {
    info.printf(msg, args);
  }

  public static void warn(String msg, Object ... args) {
    warn.printf(msg, args);
  }

  public static void err(String msg, Object ... args) {
    err.printf(msg, args);
  }

  public static void debug(String msg, Object ... args) {
    debug.printf(msg, args);
  }

}

