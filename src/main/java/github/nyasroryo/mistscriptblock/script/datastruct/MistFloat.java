package github.nyasroryo.mistscriptblock.script.datastruct;

/**
 * @author NyasRoryo
 * 浮点数的包装
 */
public final class MistFloat implements MistValue<Float> {
  
  private float value;
  
  public MistFloat(float value) {
    this.value = value;
  }
  
  @Override
  public Float getValue() {
    return value;
  }
  
  @Override
  public String getType() {
    return "_float";
  }
  
  @Override
  public String toString() {
    return Float.toString(value);
  }
  
  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    } else if (!(that instanceof MistFloat)) {
      return false;
    } else {
      return value == ((MistFloat) that).value;
    }
  }
  
  @Override
  public int hashCode() {
    return Float.hashCode(value);
  }
  
}
