package github.nyasroryo.mistscriptblock.script.file;

import github.nyasroryo.mistscriptblock.listener.TriggerType;
import github.nyasroryo.mistscriptblock.script.ScriptManager;
import github.nyasroryo.mistscriptblock.script.compile.ScriptCompiler;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static github.nyasroryo.mistscriptblock.util.Constants.*;

public class BlockReader {
  
  private static File blockFile;
  private static YamlConfiguration blockYml = new YamlConfiguration();
  
  public static void init(){
    blockFile = new File(dataFolder, "scripts.yml");
    try {
      if(!blockFile.exists()){
        blockFile.createNewFile();
      }
      blockYml.load(blockFile);
      if(!blockYml.isSet("blocks")){
        blockYml.set("scripts", new ArrayList<HashMap<String, ?>>());
        blockYml.save(blockFile);
      }
      for(Map<?, ?> m : blockYml.getMapList("blocks")){
        Location loc = new Location(
            server.getWorld((String) m.get("x")),
            (Integer) m.get("x"),
            (Integer) m.get("y"),
            (Integer) m.get("z")
        );
        loc.setPitch(TriggerType.valueOf((String) m.get("type")).intVal);
        loc.setYaw(TriggerType.valueOf((String) m.get("type")).intVal ^ 180);
        ScriptManager.fastIndex.put(loc, ScriptManager.scriptGroupList.get((String) m.get("script")));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
}
