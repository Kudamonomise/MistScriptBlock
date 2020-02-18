package github.nyasroryo.mistscriptblock.script;

import java.util.Objects;

public class ScriptValueString implements ScriptValue<String> {
  
  private final String value;
  
  public ScriptValueString(String value) {
    this.value = value;
  }
  
  @Override
  public String getValue() {
    return value;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ScriptValueString)) {
      return false;
    }
    ScriptValueString that = (ScriptValueString) o;
    return value.equals(that.value);
  }
  
  @Override
  public int hashCode() {
    return value.hashCode();
  }
  
  @Override
  public String toString() {
    return value;
  }
  
}
