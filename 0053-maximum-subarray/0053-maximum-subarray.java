class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum=Integer.MIN_VALUE;
        int currentsm=0;
        for(int i=0;i<nums.length;i++){
        currentsm+=nums[i];
        if(currentsm>maxsum){
            maxsum=currentsm;
        }
        if(currentsm<0){
            currentsm=0;
        }
    }
    return maxsum;
    }
}