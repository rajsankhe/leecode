class Solution {
    public int maxArea(int[] height) {
        int length= height.length;
        int area=Integer.MIN_VALUE;
        
        int i = 0;
        int j = height.length - 1;
        
        while(i < j) {
            area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
            System.out.println(area);
            if(height[i] < height[j]){
                i++;
            } else{
                j--;
            }
        }
        
        return area;
}
}