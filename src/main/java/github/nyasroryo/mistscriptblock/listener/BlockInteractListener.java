package github.nyasroryo.mistscriptblock.listener;

import github.nyasroryo.mistscriptblock.script.execute.ScriptTrigger;

import org.bukkit.event.*;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.*;

public class BlockInteractListener implements Listener {
  
  @EventHandler(priority = EventPriority.LOWEST)
  public void onInteract(PlayerInteractEvent e) {
    switch(e.getAction()) {
      case LEFT_CLICK_BLOCK:
        ScriptTrigger.trigger(TriggerType.LEFT_CLICK, e.getPlayer());
        break;
      case RIGHT_CLICK_BLOCK:
        ScriptTrigger.trigger(TriggerType.RIGHT_CLICK, e.getPlayer());
        break;
      default:
    }
  }
  
  @EventHandler(priority = EventPriority.LOWEST)
  public void onWalk(PlayerMoveEvent e) {
    ScriptTrigger.trigger(TriggerType.WALK, e.getPlayer());
  }
  
  @EventHandler(priority = EventPriority.LOWEST)
  public void onBreak(BlockBreakEvent e) {
    ScriptTrigger.trigger(TriggerType.BREAK, e.getPlayer());
  }
  
}
