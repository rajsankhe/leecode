class Solution {
    enum Directions {
        NORTH,
        SOUTH,
        WEST,
        EAST
    }
    
    public boolean isRobotBounded(String instructions) {
        Directions direction  = Directions.NORTH;
        int x = 0,y = 0;
        
        for(char instruction : instructions.toCharArray()) {
            switch (instruction) {
                 case 'G':{
                     switch(direction){
                         case NORTH :
                             y++;
                             break;
                           case SOUTH :
                             y--;
                             break;
                           case EAST :
                             x++;
                             break;
                           case WEST :
                             x--;
                             break;
                     }
                 }
                break;
            case  'L':{
                switch(direction){
                         case NORTH :
                             direction = Directions.WEST;
                             break;
                           case SOUTH :
                            direction = Directions.EAST;
                             break;
                           case EAST :
                            direction = Directions.NORTH;
                             break;
                           case WEST :
                             direction = Directions.SOUTH;
                             break;
                     }
                 }
                break;
            case 'R':{
                switch(direction){
                         case NORTH :
                             direction = Directions.EAST;
                             break;
                           case SOUTH :
                            direction = Directions.WEST;
                             break;
                           case EAST :
                            direction = Directions.SOUTH;
                             break;
                           case WEST :
                             direction = Directions.NORTH;
                             break;
                     }
                 }
                break;   
            } 
        }
        
        if(x == 0 && y == 0){
            return true;
        }
        
        if(direction == Directions.NORTH){
            return false;
        }
        
        return true;
    }
}