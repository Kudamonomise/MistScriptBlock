package net.mistyfield.msb.script;

import net.mistyfield.msb.script.datastruct.ShortCode;

import java.util.HashMap;
import java.util.Map;

public class ScriptManager {
  
  /**
   * 不会真的有人丧心病狂地设置4097个方块吧？别恶心我
   * 不会真的有人丧心病狂地写513个脚本组吧？别恶心我
   *
   * 这没有事，反正能扩容
   */
  public static final Map<Long, String> fastIndex = new HashMap<>(4096);
  
  public static final Map<String, ShortCode[]> scriptGroups = new HashMap<>(512);
  
}
