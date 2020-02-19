package github.nyasroryo.mistscriptblock.util;

import com.google.common.hash.*;

/**
 * @author NyasRoryo
 *
 * MurmurHash 算法 java实现 原作者：
 * @author Austin Appleby
 * @author Dimitris Andreou
 * @author Kurt Alfred Kluever
 *
 * 为了实现是否是脚本方块的快速判定，本插件使用数组来实现快速调取，位置
 *
 */
class MurmurHash {
  
  /**
   * 种子是去 random.org 生成的真随机数
   * 引擎是 Google guava 提供的 MurmurHash
   */
  private static final HashFunction ENGINE = Hashing.murmur3_32(144876139);
  
  /**
   * 全是静态方法，不用实例化该类
   */
  private MurmurHash() { }
  
  /**
   *
   * @param arg 要取 hashcode 的数字
   * @return hashcode of arg
   */
  public static int hash(int arg){
    return ENGINE.hashInt(arg).asInt();
  }
  
  
}
