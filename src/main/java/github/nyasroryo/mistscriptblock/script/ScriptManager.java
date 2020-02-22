package github.nyasroryo.mistscriptblock.script;

import github.nyasroryo.mistscriptblock.script.datastruct.ShortCode;
import org.bukkit.Location;

import java.util.HashMap;

public class ScriptManager {
  
  /**
   * 不会真的有人丧心病狂地设置4097个方块吧？别恶心我
   * 不会真的有人丧心病狂地写513个脚本组吧？别恶心我
   */
  public static final HashMap<Location, ShortCode[]> fastIndex = new HashMap<>(4096);
  
  public static final HashMap<String, ShortCode[]> scriptGroupList = new HashMap<>(512);
  
  
  
}
