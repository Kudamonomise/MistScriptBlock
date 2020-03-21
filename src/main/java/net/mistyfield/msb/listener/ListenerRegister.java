package net.mistyfield.msb.listener;

import net.mistyfield.msb.util.Constants;

/**
 * @author NyasRoryo
 * 注册所有监听器
 */
public final class ListenerRegister {
  
  /**
   * 我并不知道为什么有人会实例化这个类，但还是写一个保险吧
   */
  private ListenerRegister(){}
  
  
  private static boolean isRegistered = false;
  
  /**
   * 只能调用一次
   */
  public static void registerAll(){
    if(!isRegistered) {
      isRegistered = true;
      Constants.pluginManager.registerEvents(new BlockInteractListener(), Constants.instance);
    }
  }
  
  
}
