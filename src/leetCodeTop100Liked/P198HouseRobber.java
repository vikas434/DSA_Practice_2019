package leetCodeTop100Liked;

/* Created by Vikas Ranjan on 2020-07-19
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.



Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.


Constraints:

0 <= nums.length <= 100
0 <= nums[i] <= 400
 */
public class P198HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int dp[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i] + checkIfNumFeasible(i, dp);
            // System.out.println("dp of " + i + "is " + dp[i]);
        }

        // Highest can be the last or last but one
        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);

    }

    private int checkIfNumFeasible(int i, int[] dp) {
        if (i - 2 >= 0) {
            return dp[i - 2];
        }

        return 0;

    }
}
