package github.nyasroryo.mistscriptblock.script.execute;

import github.nyasroryo.mistscriptblock.script.datastruct.*;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class ScriptInterpreter implements Runnable {
  
  private final ScriptRuntime runtime;
  private final ShortCode[] code;

  public ScriptInterpreter(ShortCode[] code, Player p, Location loc){
    this.code = code;
    this.runtime = new ScriptRuntime(this, p, loc);
  }
  
  @Override
  public void run() {
    for(ShortCode s : code){
      s.execute(runtime);
    }
  }
  
}
