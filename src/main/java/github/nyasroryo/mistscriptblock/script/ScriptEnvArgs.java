package github.nyasroryo.mistscriptblock.script;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class ScriptEnvArgs {
  
  public final ScriptInterpreter interpreter;
  public final Player player;
  public final Block block;
  
  public ScriptEnvArgs(ScriptInterpreter interpreter, Player player, Block block) {
    this.interpreter = interpreter;
    this.player = player;
    this.block = block;
  }
  
}
