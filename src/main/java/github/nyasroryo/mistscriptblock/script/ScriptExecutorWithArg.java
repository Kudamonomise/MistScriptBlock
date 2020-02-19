package github.nyasroryo.mistscriptblock.script;

/**
 * {@link ScriptCompiler} 为了编译一些特殊文本而作出的 hack
 * 未来会开发对编译器的拓展方法
 */
public abstract class ScriptExecutorWithArg implements ScriptExecutor{
  
  final ScriptValue<?> arg;
  
  public ScriptExecutorWithArg(ScriptValue<?> arg){
    this.arg = arg;
  }
  
  @Override
  public abstract void execute(ScriptEnvArgs env);
}
