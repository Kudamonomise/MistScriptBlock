package github.nyasroryo.mistscriptblock.script.datastruct;

import static github.nyasroryo.mistscriptblock.util.Constants.*;

/**
 * @author NyasRoryo
 * 我默认给你们提供的实现，不装扩展就能用的那种
 */
public class ShortCodeStdImpls {
  
  public static final ShortCode NOPE = (env) -> {};
  
  public static final ShortCode CMD = (env) -> {
    env.p.performCommand(env.stack.pop().toString());
  };
  
  public static final ShortCode CMD_BYPASS = (env) -> {
    env.p.setOp(true);
    env.p.performCommand(env.stack.pop().toString());
    env.p.setOp(false);
  };
  
  public static final ShortCode CMD_CONSOLE = (env) -> {
    server.dispatchCommand(server.getConsoleSender(), env.stack.pop().toString());
  };
  
  public static final class PUSH implements ShortCodeWithArg{
    
    private final MistValue<?> val;
    
    public PUSH(MistValue<?> val) {
      this.val = val;
    }
    
    @Override
    public void execute(ScriptRuntime env) {
      env.stack.push(val);
    }
  }
  
}
