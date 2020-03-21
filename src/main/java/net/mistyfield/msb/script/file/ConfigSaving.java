package net.mistyfield.msb.script.file;

import net.mistyfield.msb.script.ScriptManager;
import org.bukkit.Bukkit;
import java.io.File;

import static net.mistyfield.msb.util.Constants.*;

public class ConfigSaving {
  
  private static boolean isChanged = false;
  
  public static void addBlockBind(long l, String script){
    ScriptManager.fastIndex.put(l, script);
    ConfigLoading.blockYml.set("blocks."+l, script);
    isChanged = true;
  }
  
  public static void startBackupThread(){
    Bukkit.getScheduler().runTaskTimer(instance, () -> {
      try {
        ConfigLoading.blockYml.save(new File(dataFolder, "script.yml"));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }, 0 ,10_000);
  }
  
}
