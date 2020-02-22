package github.nyasroryo.mistscriptblock.script.file;

import github.nyasroryo.mistscriptblock.script.ScriptManager;
import github.nyasroryo.mistscriptblock.script.compile.ScriptCompiler;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.*;

import static github.nyasroryo.mistscriptblock.util.Constants.dataFolder;

public class ScriptsReader {
  
  private static File scriptFile;
  private static YamlConfiguration scriptYml = new YamlConfiguration();
  
  public static void init(){
    scriptFile = new File(dataFolder, "scripts.yml");
    try {
      if(!scriptFile.exists()){
        scriptFile.createNewFile();
      }
      scriptYml.load(scriptFile);
      if(!scriptYml.isSet("scripts")){
        scriptYml.set("scripts", new ArrayList<HashMap<String, ?>>());
        scriptYml.save(scriptFile);
      }
      for(Map<?, ?> m : scriptYml.getMapList("scripts")){
        ScriptManager.scriptGroupList.put((String) m.get("name"), ScriptCompiler.compile((List<String>) m.get("script")));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
}
