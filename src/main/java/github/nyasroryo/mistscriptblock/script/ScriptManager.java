package github.nyasroryo.mistscriptblock.script;

import github.nyasroryo.mistscriptblock.util.BlockHasher;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.*;

import static github.nyasroryo.mistscriptblock.util.Constants.*;

public class ScriptManager {
  
  private static File scriptFile;
  private static YamlConfiguration scriptYaml = new YamlConfiguration();
  private static HashMap<String, ArrayList<String>> scripts = new HashMap<>();
  
  private static HashMap<String, ScriptExecutor[]> scriptGroups = new HashMap<>();
  
  /**
   * 一个 int 4Bytes
   * 初始化需要 12MB 内存
   */
  private static ScriptExecutor[][][] scriptFastIndex = new ScriptExecutor[3][1 << 20][];
  
  public static void init() {
    scriptFile = new File(dataFolder, "scripts.yml");
    if (!scriptFile.exists()) {
      try {
        scriptFile.createNewFile();
        scriptYaml.load(scriptFile);
        if(scriptYaml.get("scripts") == null){
          scriptYaml.set("scripts", new ArrayList<HashMap<String, Object>>());
        }
      } catch (Exception e) {
        e.printStackTrace();
        logger.warning("加载脚本失败！");
        pluginManager.disablePlugin(instance);
      }
    }
  }
  
  public static void compileAll(){
    List<Map<?, ?>> waitFormat = scriptYaml.getMapList("scripts");
    for(Map<?, ?> m : waitFormat){
      String name = (String) m.get("name");
      List<?> cache = (List<?>) m.get("script");
      String[] scripts = new String[cache.size()];
      for (int i = 0; i < scripts.length; i++) {
        scripts[i] = (String) cache.get(i);
      }
      scriptGroups.put(name, ScriptCompiler.compile(scripts));
    }
  }
  
  public static void serialize(){
  
  }
  
  public static void bind()
  
  public static void run (Player p, Block b){
    ScriptExecutor[] scripts = scriptFastIndex[BlockHasher.hash(b)];
    if (scripts != null) {
      new Thread(new ScriptInterpreter(scripts, p, b)).start();
    }
  }
  
}
