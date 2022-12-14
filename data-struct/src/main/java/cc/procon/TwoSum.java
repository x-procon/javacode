package cc.procon;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/two-sum">LeetCode</a>
 * </p>
 *
 * @author Procon
 * @since 2022/10/26
 */

@Slf4j
public class TwoSum {

    public static void main(String[] args) {
       int[] nums ={2,7,11,15};
       int target = 9;
        int[] ints = twoSum(nums, target);
        int[] ints2 = twoSum2(nums, target);
        log.info("方法1数组下标是:{}", ints);
        log.info("方法2数组下标是:{}", ints2);
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length ; i++) {
            int thatNum = target - nums[i];
            if(map.containsKey(thatNum) && map.get(thatNum) != i){
                return new int[]{i,map.get(thatNum)};
            }
        }
        throw new IllegalArgumentException();
    }

    public static int[] twoSum2(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int thatNum = target - nums[i];
            if(map.containsKey(thatNum) && map.get(thatNum) != i){
                return new int[]{map.get(thatNum),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException();
    }
}
