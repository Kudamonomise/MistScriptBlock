package github.nyasroryo.mistscriptblock.script;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.LinkedList;

import static github.nyasroryo.mistscriptblock.util.Constants.*;

/**
 * @author NyasRoryo
 * 脚本解释器，其实只是顺序执行。。
 */
public class ScriptInterpreter implements Runnable {
  
  private ScriptExecutor[] scripts;
  private int lineNumber = 0;
  public final ScriptEnvArgs env;
  
  /**
   * 实际上变量的赋值都是用这个寄存器完成的，所以理论上写:
   * 'example'
   * $setVar
   * 也能够赋值一个变量
   *
   * 哈哈 不过还是推荐用语义清晰的 $setVar<-'example'
   */
  final LinkedList<ScriptValue<?>> dataStack = new LinkedList<>();
  
  /**
   *
   * @param scripts
   * @param player
   * @param block
   */
  HashMap<String, ScriptValue<?>> fastAccessValues;
  
  public ScriptInterpreter(ScriptExecutor[] scripts, Player player, Block block){
    this.scripts = scripts;
    env = new ScriptEnvArgs(this, player, block);
  }
  
  @Override
  public void run() {
    while(++lineNumber < scripts.length){
      try {
        scripts[lineNumber - 1].execute(env);
      } catch (Exception e){
        e.printStackTrace();
      }
    }
  }
  
  public void pushStack(ScriptValue<?> val){
    dataStack.addFirst(val);
  }
  
  public ScriptValue<?> popStack(){
    return dataStack.removeFirst();
  }
  
  public ScriptValue<?> peekStack(){
    return dataStack.get(0);
  }
  
  /**
   * @param count 需要获取的参数的数量
   * @return 参数
   * 我推荐使用这个方法来获取参数
   */
  public ScriptValue<?>[] getArgs(int count){
    ScriptValue<?>[] result = new ScriptValue[count];
    for (int i = 0; i < count; i++) {
      result[(count - 1) - i] = popStack();
    }
    return result;
  }
  
  public void addLineNumber(int count){
    lineNumber += count;
  }
  
  public void setLineNumber(int count){
    lineNumber = count;
  }
  
}
