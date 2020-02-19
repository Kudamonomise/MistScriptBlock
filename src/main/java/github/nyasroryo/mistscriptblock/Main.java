package github.nyasroryo.mistscriptblock;

import github.nyasroryo.mistscriptblock.util.Constants;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
  
  private static Main instance;
  
  @Override
  public void onEnable() {
    instance = this;
    reload();
  }
  
  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }
  
  public static void reload(){
    Constants.init(instance);
  }
  
}
