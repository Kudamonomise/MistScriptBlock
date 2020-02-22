package github.nyasroryo.mistscriptblock.listener;

/**
 *
 */
public enum TriggerType {
  
  /**
   * 触发动作的枚举
   */
  LEFT_CLICK("LEFT_CLICK", 1),
  RIGHT_CLICK("RIGHT_CLICK", 2),
  WALK("WALK", 3),
  BREAK("BREAK", 4),
  ;
  
  public final String strName;
  
  public final int intVal;
  
  TriggerType(String name, int intVal) {
    this.strName = name;
    this.intVal = intVal;
  }
  
  @Override
  public String toString(){
    return strName;
  }
  
}
