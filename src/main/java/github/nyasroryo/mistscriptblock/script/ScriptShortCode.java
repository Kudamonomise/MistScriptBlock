package github.nyasroryo.mistscriptblock.script;

public class ScriptShortCode {
  
  /**
   * 用于执行该短码的执行器
   */
  public final ScriptExecutor executor;
  
  /**
   * 参数都在解释器的数据栈内，请参考 {@link ScriptExecutor#PUSH} 等进行开发
   */
  public final ScriptValue<?> arg;
  
  public ScriptShortCode(ScriptExecutor executor, ScriptValue<?> arg) {
    this.executor = executor;
    this.arg = arg;
  }
  
  public void execute(ScriptEnvArgs environment){
    executor.execute(arg, environment);
  }
  
}
