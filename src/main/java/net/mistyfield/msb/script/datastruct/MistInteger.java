package net.mistyfield.msb.script.datastruct;

/**
 * @author NyasRoryo
 * 整数的包装
 */
public final class MistInteger implements MistValue<Integer> {
  
  private int value;
  
  public MistInteger(int value) {
    this.value = value;
  }
  
  @Override
  public Integer getValue() {
    return value;
  }
  
  @Override
  public String getType() {
    return "_integer";
  }
  
  @Override
  public String toString() {
    return Integer.toString(value);
  }
  
  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    } else if (!(that instanceof MistInteger)) {
      return false;
    } else {
      return value == ((MistInteger) that).value;
    }
  }
  
  @Override
  public int hashCode() {
    return value;
  }
  
}
