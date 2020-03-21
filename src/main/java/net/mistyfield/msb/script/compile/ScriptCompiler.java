package net.mistyfield.msb.script.compile;

import net.mistyfield.msb.script.datastruct.*;

import java.util.*;

public class ScriptCompiler {
  
  public static final Map<String, ShortCode> NO_ARG_SHORT_CODE = new HashMap<String, ShortCode>(){{
    put("@nope", ShortCodeStdImpls.NOPE);
    put("@cmd", ShortCodeStdImpls.CMD);
    put("@cmdop", ShortCodeStdImpls.CMD_BYPASS);
    put("@cmdcon", ShortCodeStdImpls.CMD_CONSOLE);
  }};
  
  public static ShortCode[] compile(List<String> raw){
    List<ShortCode> result = new ArrayList<>();
    List<String> cache = new ArrayList<>();
    raw.forEach(s -> {
      List<String> l = Arrays.asList(s.split("<-"));
      Collections.reverse(l);
      cache.addAll(l);
    });
    cache.forEach(s -> {
      if(s.startsWith("@")){
        ShortCode sc = NO_ARG_SHORT_CODE.get(s.toLowerCase());
        if(sc == null){
          throw new RuntimeException("Illegal Code: " + s);
        }
        result.add(sc);
      }else if(s.matches("'.*'")){
        result.add(new ShortCodeStdImpls.PUSH(new MistString(s.substring(1,s.length()-1))));
      }else if(s.matches("-?[0-9]+")){
        result.add(new ShortCodeStdImpls.PUSH(new MistInteger(Integer.parseInt(s))));
      }else if(s.matches("-?[0-9]+\\.[0-9]+")){
        result.add(new ShortCodeStdImpls.PUSH(new MistFloat(Float.parseFloat(s))));
      }
    });
    return result.toArray(new ShortCode[0]);
  }
  
}
