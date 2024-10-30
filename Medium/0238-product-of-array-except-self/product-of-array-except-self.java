
class Solution {
    public int[] productExceptSelf(int[] nums) {
        Integer numsSize = nums.length;

        int[] pre = new int[numsSize];
        int[] pos = new int[numsSize];


        for (int i = 0; i < numsSize; i++) {
            if (i == 0) {
                pre[i] = nums[i];
                pos[numsSize-i-1] = nums[numsSize-i-1];
                continue;
            }

            pre[i] = nums[i] * pre[i-1];
            pos[numsSize-i-1] = nums[numsSize-i-1] * pos[numsSize-i];
        }

        for (int i = 0; i < numsSize; i++) {
            System.out.println(pre[i] + " " + pos[i]);
        }

        int[] res = new int[numsSize];

        for (int i = 0; i < numsSize; i++) {
            if (i == 0) {
                res[i] = pos[i+1];
                continue;
            }

            if (i == numsSize-1) {
                res[numsSize-1] = pre[numsSize-2];
                continue;
            }

            res[i] = pre[i-1] * pos[i+1];
        }

        return res;
    }
}