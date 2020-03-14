package github.nyasroryo.mistscriptblock.script.execute;

import github.nyasroryo.mistscriptblock.script.ScriptManager;
import github.nyasroryo.mistscriptblock.util.Hash;
import github.nyasroryo.mistscriptblock.util.ToString;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class ScriptTrigger {
  
  private ScriptTrigger(){}
  
  /**
   * 尝试触发一个脚本
   * @param type 动作类型
   * @param p 玩家
   */
  public static void trigger(int type, Location loc, Player p){
    loc = loc.clone();
    // 这个是为了使不同动作的location的hashCode不同，算是一个hack吧... 以后会改的
    loc.setYaw(type);
    loc.setPitch(90-type);
    
    long hash = Hash.location(loc);
  
    String code;
    if ((code = ScriptManager.fastIndex.get(hash)) != null){
      new Thread(new ScriptInterpreter(ScriptManager.scriptGroupList.get(code), p, loc)).start();
    }
  }
  
  
  
  

}
