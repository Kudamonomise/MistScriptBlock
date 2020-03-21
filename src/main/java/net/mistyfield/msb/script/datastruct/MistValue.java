package net.mistyfield.msb.script.datastruct;

/**
 * @author NyasRoryo
 * 一个包装类，使整数、浮点数、字符串能统一为一个接口
 * 顺带提一下，建议实现 toString(), hashCode() 和 equals() 方法
 */
public interface MistValue<T> {
  
  /**
   * 获取其值
   * @return 存储的值
   */
  T getValue();
  
  /**
   * 获取其类型
   * 只是为了代码不充斥 instanceof ... 没重构之前还真的是这样
   * @return 其类型
   */
  String getType();
  
}
