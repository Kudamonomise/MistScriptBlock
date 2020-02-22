package github.nyasroryo.mistscriptblock.script.datastruct;

import github.nyasroryo.mistscriptblock.script.execute.ScriptInterpreter;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.*;
/**
 * @author NyasRoryo
 * 存储脚本运行时需要的东西
 * 这个类主要是为了执行和数据分离
 */
public class ScriptRuntime {
  
  public final ScriptInterpreter itp;
  public final Stack<MistValue<?>> stack = new Stack<>();
  public final Player p;
  public final Location loc;
  
  public ScriptRuntime(ScriptInterpreter interpreter, Player player, Location loc) {
    this.itp = interpreter;
    this.p = player;
    this.loc = loc;
  }
  
}
