package github.nyasroryo.mistscriptblock.script.execute;

import github.nyasroryo.mistscriptblock.listener.TriggerType;

import github.nyasroryo.mistscriptblock.script.ScriptManager;
import github.nyasroryo.mistscriptblock.script.datastruct.ShortCode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class ScriptTrigger {
  
  private ScriptTrigger(){}
  
  /**
   * 尝试触发一个脚本
   * @param tt 动作类型
   * @param p 玩家
   */
  public static void trigger(TriggerType tt, Player p){
    Location loc = p.getLocation().getBlock().getLocation().subtract(0, 1, 0);
    // 这个是为了使不同动作的location的hashCode不同，算是一个hack吧... 以后会改的
    loc.setPitch(tt.intVal);
    loc.setYaw(tt.intVal ^ 180);
  
    ShortCode[] code;
    
    if ((code = ScriptManager.fastIndex.get(loc)) != null){
      new Thread(new ScriptInterpreter(code, p, loc)).start();
    }
  }
  
  
  
  

}
