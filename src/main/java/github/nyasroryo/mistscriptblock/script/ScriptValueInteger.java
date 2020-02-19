package github.nyasroryo.mistscriptblock.script;

public class ScriptValueInteger implements ScriptValue<Long> {
  
  private final long value;
  
  public ScriptValueInteger(long value) {
    this.value = value;
  }
  
  @Override
  public Long getValue() {
    return value;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ScriptValueInteger)) {
      return false;
    }
    return value == ((ScriptValueInteger) o).value;
  }
  
  @Override
  public int hashCode() {
    return Long.hashCode(value);
  }
  
  @Override
  public String toString() {
    return Long.toString(value);
  }
  
}
