/** Assignment 1 - Winter 2021
  * <p>
  * Problem 3
  * <p> 
  * In this problem, you will complete three methods to check if a SUDOKU game is valid or not.
  */
  public class SudokuChecker{
   

    /** checks if row 'row' is OK in the grid */	
  public static boolean checkRow(int row, byte[][] grid){
    return baseCheck(row, grid, 0);
  }

    /** checks if column 'col' is OK in the grid */
  public static boolean checkColumn(int col, byte[][] grid){
    return baseCheck(col, grid, 1);
  }

    /** checks if the subregion 'region' is OK in the grid */
  public static boolean checkSubregion(int region, byte[][] grid){
    return baseCheck(region, grid, 2);
  }

  public static boolean baseCheck(int num, byte[][] grid, int type){
      boolean valid = true;
      boolean[] numsHad = {false,false,false,false,false,false,false,false,false};
      int x = 0;
      int y = 0;

      for (int k = 0; k < 9; k++){
        if (type == 0){
            y = k;
            x = num;
        }else if(type == 1){
            x = k;
            y = num;
        }else if (type == 2){
            x = (k / 3) + (num / 3)*3;
            y = (num % 3)*3 + (k % 3);
        }
          if (numsHad[grid[x][y]-1]){
              valid = false;
          }else{
              numsHad[grid[x][y]-1] = true;
          }
        }
        return valid;
  }


  public static boolean check(byte[][] grid){
    // check the subregions
    for(int subregion=0; subregion<9; subregion+=1){  
      if( !checkSubregion(subregion, grid) ){
        return false;
      }
    }

    // check the rows
    for(int row=0; row<9; row+=1){                    
      if( !checkRow(row, grid) ){
        return false;
      }
    }

   // check the cols
   for(int col=0; col<9; col+=1){                    
      if( !checkColumn(col, grid) ){
        return false;
      }
    }
  
        
        // if we get this far then we conclude that the grid
        // must be valid (because if it was not, we would have
        // returned false somewhere above)
    return true;
  }
    


  public static void main(String[] args){

    System.out.print("exmample1 | expected output is true  | actual output is ");
    System.out.println(check(example1));

    System.out.print("exmample2 | expected output is false | actual output is ");
    System.out.println(check(example2));

  }


    /** sample valid game */
  public static byte[][] example1 = new byte[][]{
    {5,3,4,6,7,8,9,1,2},
    {6,7,2,1,9,5,3,4,8},
    {1,9,8,3,4,2,5,6,7},
    {8,5,9,7,6,1,4,2,3},
    {4,2,6,8,5,3,7,9,1},
    {7,1,3,9,2,4,8,5,6},
    {9,6,1,5,3,7,2,8,4},
    {2,8,7,4,1,9,6,3,5},
    {3,4,5,2,8,6,1,7,9}};

  /** sample invalid game */
  public static byte[][] example2 = new byte[][]{
    {5,3,4,6,7,8,9,1,2},
    {6,7,2,1,9,5,3,4,8},
    {1,9,8,3,4,2,5,6,7},
    {8,5,9,7,6,1,4,2,3},
    {4,2,6,8,5,3,7,9,1},
    {7,1,3,9,2,4,8,5,6},
    {9,6,1,5,3,7,2,8,3},
    {2,8,7,4,1,9,6,2,6},
    {3,4,5,2,8,6,1,8,8}};

}