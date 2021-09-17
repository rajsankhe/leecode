class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums.length == 0){
            return nums.length;
        }
        
        int i= 0;
        int j = 1;
        
        while(j < nums.length)   {
            while(j < nums.length && nums[i] == nums[j]){
                j++;
            }
            
            if(j< nums.length){
                nums[++i] = nums[j];
            }
            
        }
        
        return i + 1;
    }
}