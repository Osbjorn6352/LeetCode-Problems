class TwoSum.java {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; i < nums.length; i++){
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return null;
    }
    //we are also challenged to find a solution which reduces the amount of steps required to speed up the program
    //See OptimizedTwoSum.java for my solution to this
}
