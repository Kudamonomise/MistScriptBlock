package net.mistyfield.msb.script.datastruct;

/**
 * @author NyasRoryo
 * 简易的可执行指令
 * 设计成这样主要是为了可拓展性
 * 默认是无参
 */
public interface ShortCode {
  
  /**
   * 无返回值，返回请用压栈，参考 {@link ShortCodeStdImpls}
   * @param env 运行环境
   */
  void execute(ScriptRuntime env);
  
}
