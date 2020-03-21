package net.mistyfield.msb.script.datastruct;

import static net.mistyfield.msb.util.Constants.*;

/**
 * @author NyasRoryo
 * 我默认给你们提供的实现，不装扩展就能用的那种
 */
public class ShortCodeStdImpls {
  
  public static final ShortCode NOPE = env -> {};
  
  public static final ShortCode CMD = env ->
    env.p.performCommand(env.stack.pop().toString().replace("%player%", env.p.getName()));
  
  public static final ShortCode CMD_BYPASS = env -> {
    env.p.setOp(true);
    env.p.performCommand(env.stack.pop().toString().replace("%player%", env.p.getName()));
    env.p.setOp(false);
  };
  
  public static final ShortCode CMD_CONSOLE = env -> server.dispatchCommand(server.getConsoleSender(),
        env.stack.pop().toString().replace("%player%", env.p.getName()));
  
  /**
   * 一种带参数的，可以参考
   */
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
