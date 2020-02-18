package github.nyasroryo.mistscriptblock.script;

import java.util.*;


/**
 * 编译文本形式的脚本到短码，来加速运行
 */
public class ScriptCompiler {
  
  public static ScriptShortCode[] compile(String[] source) {
    ArrayList<String> waitCompile = new ArrayList<>();
    for(String s : source){
      List<String> cache = Arrays.asList(s.split(" *<- *"));
      Collections.reverse(cache);
      waitCompile.addAll(cache);
    }
    
    return new ScriptShortCode[0];
  }
  
  private static ScriptShortCode compile1(String s){
    ScriptExecutor result = null;
    if((result = ScriptExecutor.byName(s)) != null){
      return new ScriptShortCode(result, null);
    }
  }
  
}
