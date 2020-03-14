package github.nyasroryo.mistscriptblock.util;

import static github.nyasroryo.mistscriptblock.util.Constants.*;

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
