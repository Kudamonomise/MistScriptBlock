package github.nyasroryo.mistscriptblock.util;

import github.nyasroryo.mistscriptblock.Main;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;

import java.io.File;
import java.util.logging.Logger;

/**
 * @author NyasRoryo
 * 经常调用的全局常量
 */
public class Constants {
  
  public static Main instance;
  public static Logger logger;
  public static Server server;
  public static PluginManager pluginManager;
  public static File dataFolder;
  public static FileConfiguration config;
  
  public static void init(Main main){
    instance = main;
    logger = main.getLogger();
    server = main.getServer();
    pluginManager = main.getServer().getPluginManager();
    dataFolder = main.getDataFolder();
    config = main.getConfig();
  }
  
  
}
