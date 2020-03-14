package github.nyasroryo.mistscriptblock.util;

import java.util.*;

public class ToString {
  
  public static String map(Map map) {
    StringBuilder sb = new StringBuilder();
    for(Object et : map.entrySet()){
      sb.append(((Map.Entry)et).getKey()).append('=').append(((Map.Entry)et).getValue()).append(',').append(' ');
    }
    return sb.toString();
  }
  
}

