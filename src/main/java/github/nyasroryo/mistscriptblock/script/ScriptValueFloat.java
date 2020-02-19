package github.nyasroryo.mistscriptblock.script;

public class ScriptValueFloat implements ScriptValue<Double> {
  
  private final double value;
  
  public ScriptValueFloat(double value) {
    this.value = value;
  }
  
  @Override
  public Double getValue() {
    return value;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ScriptValueFloat)) {
      return false;
    }
    return value == ((ScriptValueFloat) o).value;
  }
  
  @Override
  public int hashCode() {
    return Double.hashCode(value);
  }
  
  @Override
  public String toString() {
    return Double.toString(value);
  }
  
}
