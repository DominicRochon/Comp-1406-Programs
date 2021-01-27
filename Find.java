/** Assignment 1 - Winter 2021
  * <p>
  * Problem 1
  * <p>
  * In the provided Find.java file, complete the locateSequence method. 
  * For a given target sequence (non-empty array of integers), the method 
  * searches the input array (of integers) to find an occurrence of the 
  * target sequence if it is present. If the sequence is present, the 
  * method returns the array index position of where it starts in the array. 
  * If the sequence is not present, the method returns -1.
  */

public class Find{

    public static void main(String args[])  {
        int[] seq = {5,3};
        int[] arr = {5,3,2,1,4,5,3,7};
        System.out.println(locateSequence(seq,arr));
    }
  
  /** Finds the last occurrence of the sequence in the array or indicates that 
    * the sequence is not present.
    * 
    * @param sequence is an array of one or more integers. 
    *        It is the target sequence we are looking for.
    * 
    * @param array is an array integers. 
    * 
    * @return the starting position of the last occurrence of the target sequence in the 
    *         array if it exists. Returns -1 otherwise.
    */
  
  public static int locateSequence(int[] sequence, int[] array){
    int i;
    boolean seqFound = false;
    int foundSpot = -1;
    for (int p = 0; p < array.length - 1; p++){
        i = 0;
        seqFound = false;
        while (!seqFound && array[p + i] == sequence[i] ){
            if (i == sequence.length - 1){
                seqFound = true;
                foundSpot = p;
            }
            i++;
        }
    }
    return foundSpot;
  }
  
}