package cc.procon;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。

 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。

 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。

 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/3sum">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author procon
 * @since 2022-10-27
 */
@Slf4j
public class ThreeSum {

    public static void main(String[] args) {
       int[] nums = {0,0,1};
        List<List<Integer>> result = threeSum(nums);
        log.info("结果是：{}",result);
    }

    /**
     * 三数相加双指针法
     * @param nums 数组
     * @return 结果集合
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        //0.先对数组进行排序
        Arrays.sort(nums);
        for (int i = 0; i < n;i++){
            //1.判断最小的是否大于0
            if(nums[i] > 0){
                break;
            }
            //2.判断之前是否已经遍历过
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            //3.定义左右指针
            int lp = i + 1;
            int rp = n-1;
            while(lp < rp){
                int sum  = nums[i] + nums[lp] + nums[rp];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[lp],nums[rp]));
                    lp++;
                    rp--;
                    while(lp < rp && nums[lp] == nums[lp -1]){
                        lp++;
                    }
                    while (lp < rp && nums[rp] == nums[rp+1]){
                        rp --;
                    }
                } else if(sum<0){
                    lp++;
                }else {
                    rp--;
                }
            }
        }
        return result;
    }
}
