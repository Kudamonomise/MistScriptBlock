package github.nyasroryo.mistscriptblock.script;

import java.util.*;

import static github.nyasroryo.mistscriptblock.script.ScriptExecutorImpl.*;

/**
 * @author NyasRoryo
 * 编译文本形式的脚本到短码，来加速运行
 */
public class ScriptCompiler {
  
  private static HashMap<String, ScriptExecutor> EXECUTORS = new HashMap<String, ScriptExecutor>(){{
    put("nope", NOPE);
    put("cmd", COMMAND);
    put("cmdop", COMMAND_OP);
    put("cmdconsole", COMMAND_CONSOLE);
  }};
  
  public static void registerExecutor(String name, ScriptExecutor executor){
    EXECUTORS.put(name, executor);
  }
  
  
  public static ScriptExecutor[] compile(String[] source) {
    ArrayList<ScriptExecutor> result = new ArrayList<>();
    for(String s : source){
      LinkedList<ScriptExecutor> cache = new LinkedList<>();
      // 先运行右边的再运行左边的( <-本义 )
      for(String str : s.split(" *<- *")){
        cache.addFirst(compileOne(str));
      }
    }
    
    return result.toArray(new ScriptExecutor[0]);
  }
  
  /**
   * String -> regex: ^\'.*\'$
   * Long -> regex: ^[0-9]+$
   * Double -> regex: ^[0-9]+(\.[0-9]*)?$
   */
  private static ScriptExecutor compileOne(String s){
    if(s == null || s.isEmpty()){
      return NOPE;
    }
    
    // 这个函数必须前缀@只是为了视觉清晰而作出的规定
    if(s.startsWith("@")){
      return EXECUTORS.get(s.substring(1).toLowerCase());
    }
    
     if(s.matches("^'.*'$")){
       return new PUSH(new ScriptValueString(s.substring(1, s.length() - 1)));
     } else if(s.matches("^[0-9]+$")){
       return new PUSH(new ScriptValueInteger(Long.parseLong(s)));
     } else if(s.matches("^[0-9]+(\\.[0-9]*)?$")){
       return new PUSH(new ScriptValueFloat(Double.parseDouble(s)));
     }
    
    return NOPE;
  }
  
}
