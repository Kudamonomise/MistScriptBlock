package github.nyasroryo.mistscriptblock.script;

/**
 * @author NyasRoryo
 * 解析执行脚本的引擎
 * 获取参数请参考 {@link ScriptExecutorImpl#COMMAND} 等
 */
public interface ScriptExecutor {
  
  /**
   * 运行一次该执行器能运行的功能
   * @param env 环境参数，根据触发时环境自动生成
   */
  void execute(ScriptEnvArgs env);
  
}
