package net.mistyfield.msb.script.file;

import net.mistyfield.msb.script.ScriptManager;
import net.mistyfield.msb.script.compile.ScriptCompiler;
import net.mistyfield.msb.util.ToString;
import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

import static net.mistyfield.msb.util.Constants.*;

public class ConfigLoading {
  
  static YamlConfiguration scriptYml = new YamlConfiguration();
  static YamlConfiguration blockYml = new YamlConfiguration();
  
  public static void load() {
    file();
    getScripts();
    getBlocks();
  }
  
  private static void getScripts(){
    MemorySection msScripts = (MemorySection) scriptYml.get("scripts");
    msScripts.getKeys(false).forEach(key -> {
      ScriptManager.scriptGroups.put(key, ScriptCompiler.compile(msScripts.getStringList("script")));
    });
    System.out.println(ToString.map(ScriptManager.scriptGroups));
  }
  
  private static void getBlocks(){
    MemorySection msBlocks = (MemorySection) blockYml.get("blocks");
    msBlocks.getKeys(false).forEach(key -> {
      ScriptManager.fastIndex.put(Long.valueOf(key), msBlocks.getString(key));
    });
    System.out.println(ToString.map(ScriptManager.fastIndex));
  }
  
  private static void file(){
    if(!dataFolder.exists()){
      dataFolder.mkdirs();
    }
    
    File scriptFile = new File(dataFolder, "scripts.yml");
    try {
      if (!scriptFile.exists()) {
        instance.saveResource("scripts.yml", true);
      }
      scriptYml.load(scriptFile);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    File blockFile = new File(dataFolder, "blocks.yml");
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
