package net.mistyfield.msb.util;

import static net.mistyfield.msb.util.Constants.*;

public class Log {
  
  public static void output(String msg){
    logger.info(msg);
  }
  
  public static void output(String msg, String level){
    switch (level){
      default:
      case "info":
        logger.info(msg);
        break;
      case "warning":
        logger.warning(msg);
        break;
      case "severe":
        logger.severe(msg);
        break;
      case "fine":
        logger.fine(msg);
        break;
      case "debug":
        debug(msg);
        break;
    }
  }
  
  public static void debug(String msg){
    if(debugMode){
      logger.warning("Debug >> " + msg);
    }
  }
  
}
