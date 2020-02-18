package github.nyasroryo.mistscriptblock.script;

import java.util.HashMap;

public interface ScriptExecutor {
  
  /**
   * @param arg 参数，是用户自己写的
   * @param env 环境参数，根据触发时环境自动生成
   */
  void execute(ScriptValue<?> arg, ScriptEnvArgs env);
  
  HashMap<String, ScriptExecutor> EXECUTORS = new HashMap<String, ScriptExecutor>(128){{
    put("nope", NOPE);
  }};
  
  static ScriptExecutor byName(String name) {
    return EXECUTORS.get(name.toLowerCase());
  }
  
  static void registerExecutor(String name, ScriptExecutor se){
    EXECUTORS.put(name.toLowerCase(), se);
  }
  
  ScriptExecutor NOPE = (arg, env) -> { };
  
  ScriptExecutor PUSH = (arg, env) -> {
    env.interpreter.register = arg;
  };
  
  
}
