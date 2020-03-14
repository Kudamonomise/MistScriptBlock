package github.nyasroryo.mistscriptblock.script.file;

import github.nyasroryo.mistscriptblock.script.ScriptManager;
import github.nyasroryo.mistscriptblock.script.compile.ScriptCompiler;
import github.nyasroryo.mistscriptblock.util.ToString;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.*;

import static github.nyasroryo.mistscriptblock.util.Constants.*;

public class Config {
  
  private static File scriptFile;
  private static YamlConfiguration scriptYml = new YamlConfiguration();
  private static File blockFile;
  private static YamlConfiguration blockYml = new YamlConfiguration();
  
  public static void load() {
    file();
    getScripts();
    getBlocks();
  }
  
  private static void getScripts(){
    ScriptManager.scriptGroupList.put("", null);
    List<Map<?,?>> lmScripts = scriptYml.getMapList("scripts");
    lmScripts.forEach(m -> {
      System.out.println(ToString.map(m));
      ScriptManager.scriptGroupList.put((String) m.get("name"),
          ScriptCompiler.compile((List<String>) m.get("script")));
    });
  }
  
  private static void getBlocks(){
    ScriptManager.scriptGroupList.put("", null);
    List<Map<?,?>> lmScripts = blockYml.getMapList("blocks");
    lmScripts.forEach(m -> {
      System.out.println(ToString.map(m));
      ScriptManager.fastIndex.put(
          (Long) m.get("uniqueLocId"),
          (String) m.get("script")
        );}
    );
  }
  
  private static void file(){
    if(!dataFolder.exists()){
      dataFolder.mkdirs();
    }
    
    scriptFile = new File(dataFolder, "scripts.yml");
    try {
      if (!scriptFile.exists()) {
        instance.saveResource("scripts.yml", true);
      }
      scriptYml.load(scriptFile);
    } catch (Exception e) {
      e.printStackTrace();
    }
    blockFile = new File(dataFolder, "blocks.yml");
    try {
      if (!blockFile.exists()) {
        instance.saveResource("blocks.yml", true);
      }
      blockYml.load(blockFile);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
