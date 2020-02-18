package github.nyasroryo.mistscriptblock.script;

/**
 * 总共有三种类型，一种是String，一种是Long，一种是Double
 * String -> regex: ^\'.*\')$
 * Long -> regex: ^[0-9]+$
 * Double -> regex: ^[0-9]+\.?[0-9]*$
 */
public interface ScriptValue<T> {
  
  T getValue();
  
  @Override
  boolean equals(Object o);
  
  @Override
  int hashCode();
  
  @Override
  String toString();
  
}
