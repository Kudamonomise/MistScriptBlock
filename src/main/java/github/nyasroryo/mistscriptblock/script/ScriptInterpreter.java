package github.nyasroryo.mistscriptblock.script;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class ScriptInterpreter implements Runnable {
  
  private ScriptShortCode[] scripts;
  final ScriptEnvArgs env;
  int lineNumber = 0;
  
  /**
   * 实际上变量的赋值都是用这个寄存器完成的，所以理论上写:
   * 'example'
   * $setVar
   * 也能够赋值一个变量
   *
   * 哈哈 不过还是推荐用语义清晰的 $setVar<-'example'
   */
  ScriptValue<?> register;
  
  public ScriptInterpreter(ScriptShortCode[] scripts, Player player, Block block){
    this.scripts = scripts;
    env = new ScriptEnvArgs(this, player, block);
  }
  
  @Override
  public void run() {
    while(lineNumber < scripts.length){
      scripts[lineNumber].execute(env);
    }
  }
  
}
