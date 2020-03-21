package net.mistyfield.msb.command;

import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MsbCmd implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender p, Command c, String l, String[] args) {
    if(!"msb".equalsIgnoreCase(l)){
      return false;
    }
    if(args.length == 0){
      p.sendMessage(HELP[0]);
    }
    switch(args[0]){
      case "help":{
        // 简洁但是可读性不好
        try {
          p.sendMessage(HELP[Integer.parseInt(args[1])]);
        } catch(Exception e){
          p.sendMessage(HELP[0]);
        }
        break;
      }
      
      case "bind":{
        if(!(p instanceof Player)){
          p.sendMessage("只有玩家才能执行该指令");
          break;
        }
        Block b = ((Player) p).getTargetBlock(null, 10);
        System.out.println(b);
        
      }
      
      default: {
        p.sendMessage("未知子命令, 正在显示帮助");
        p.sendMessage(HELP[0]);
        break;
      }
    }
    return true;
  }
  
  private static final String[][] HELP = new String[][]{
      new String[]{
          "=-=-=-=-= MistScriptBlock 帮助 =-=-=-=-=",
          "/msb help - 显示此帮助",
          "",
          "/msb bind <类型> <脚本组名> - 将该脚本组绑定到准星指向的方块",
          "<类型>: walk, left_click, right_click, break",
          "<脚本组名>: 在script.yml里你填写的脚本组名",
          "",
          "/msb unbind - 移除准星指向的方块上的脚本组绑定",
          "=-=-=-=-=-= 第 1 页,  共 1 页 =-=-=-=-=-=",
      },
  };
  
}