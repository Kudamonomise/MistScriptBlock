package github.nyasroryo.mistscriptblock.util;

import org.bukkit.block.Block;

import java.util.Arrays;

public class BlockHasher {
  
  private BlockHasher() {}
  
  /**
   * 一个 int 4Bytes
   * 初始化需要 4MB 内存
   */
  private static int[] hashCache = new int[1 << 20];
  
  static{
    Arrays.fill(hashCache, -1);
  }
  
  public static int hash(Block block){
    // 削到最高 1,048,575 (索引大小 - 1)
    int result = ((block.getX() << 16 ^ block.getY() << 24 ^ block.getZ()
        ^ block.getWorld().getName().hashCode() << 8) >> 11) & Integer.MAX_VALUE;
    if(hashCache[result] != -1){
      return hashCache[result];
    }
    return MurmurHash.hash(result) & Integer.MAX_VALUE;
  }
  
  
}
