class Solution {
    public int trap(int[] height) {
        int length = height.length;
        
        if (length == 0)
            return 0;
        
        int leftMax[] =  new int[length];
        int rightMax[] = new int[length];
        leftMax[0] = height[0];
        rightMax[length-1] = height[length -1];
        for (int i = 1; i< length; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        
        for (int i = length-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        
        int waterAccumulate = 0;
         for (int i = 0; i< length; i++){
            waterAccumulate += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
         
        return waterAccumulate;
    }
}