class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //int l1=nums1.length;
        //int n=nums2.length;
        //int m=l1-n;
       int[] ans=new int[m+n];
       for(int i=0;i<m+n;i++){
        if(i<m) ans[i]=nums1[i];
        else ans[i]=nums2[i-m];

       } 
       Arrays.sort(ans);
       for(int i=0;i<m+n;i++){
        nums1[i]=ans[i];
       }
       //return ans[];
    }
}