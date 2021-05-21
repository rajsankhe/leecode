class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] r = new int[length];
        
        r[length-1] = 1;
        for (int i= length-2; i>= 0; i--){
            r[i] = r[i+1] * nums[i+1];
        }
        
        int left = 1;
        for(int i=1; i<length;i++){
            left = left * nums[i-1];
            r[i] = left * r[i];
        }
        
        return r;
    }
}