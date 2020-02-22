package github.nyasroryo.mistscriptblock.script.datastruct;

/**
 * @author NyasRoryo
 * 字符串的包装
 */
public final class MistString implements MistValue<String> {
  
  private String value;
  
  public MistString(String value) {
    this.value = value;
  }
  
  @Override
  public String getValue() {
    return value;
  }
  
  @Override
  public String getType() {
    return "_string";
  }
  
  @Override
  public String toString() {
    return value;
  }
  
  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    } else if (!(that instanceof MistString)) {
      return false;
    } else {
      return value.equals(((MistString) that).value);
    }
  }
  
  @Override
  public int hashCode() {
    return value.hashCode();
  }
  
}
