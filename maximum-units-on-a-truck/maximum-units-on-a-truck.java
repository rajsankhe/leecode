class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
                    int maxUnits = 0;

        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
            for(int value[] : boxTypes){

                if(truckSize >= value[0]){
                    maxUnits += value[0] * value[1];
                } else {
                    maxUnits += truckSize * value[1];
                    break;
                }

                truckSize = truckSize - value[0];
            }

            return maxUnits;
    }
}