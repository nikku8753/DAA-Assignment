class Solution {
    public int findKthLargest(int[] nums, int k) {
       /*for(int i=0;i<nums.length;i++){
        int count=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]>nums[i]) count++;
        }
        if(count==k-1) return nums[i];
        System.out.print(count);
       } 
       return -1;*/
       Arrays.sort(nums);
       return nums[nums.length-k];
    }
}