package github.nyasroryo.mistscriptblock.script;

import org.bukkit.entity.Player;

import static github.nyasroryo.mistscriptblock.util.Constants.*;

public class ScriptExecutorImpl {
  
  /**
   * 这是个存放 {@link ScriptExecutor} 的实现的类
   * 无需实例化
   */
  private ScriptExecutorImpl(){}
  
  /**
   * 什么也不做
   */
  public static final ScriptExecutor NOPE = env -> { };
  
  /**
   * 玩家执行一条指令
   */
  public static final ScriptExecutor COMMAND = env -> {
    env.player.performCommand(env.interpreter.getArgs(1)[0].toString());
  };
  
  /**
   * 玩家以op身份执行一条指令
   */
  public static final ScriptExecutor COMMAND_OP = env -> {
    Player p = env.player;
    p.setOp(true);
    p.performCommand(env.interpreter.getArgs(1)[0].toString());
    p.setOp(false);
  };
  
  /**
   * 控制台执行一条指令
   */
  public static final ScriptExecutor COMMAND_CONSOLE = env -> {
    server.dispatchCommand(server.getConsoleSender(), env.interpreter.getArgs(1)[0].toString());
  };
  
  public static final class PUSH extends ScriptExecutorWithArg{
    public PUSH(ScriptValue<?> arg) {
      super(arg);
    }
    
    @Override
    public void execute(ScriptEnvArgs env) {
      env.interpreter.pushStack(arg);
    }
  }
  
}
