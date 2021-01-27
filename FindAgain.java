public class FindAgain {
    public static void main(String args[])  {
        int[] seq = {5,3};
        int[] arr = {5,3,2,1,4,5,3,7};
        System.out.println(java.util.Arrays.toString(locateAllSequenceLocations(seq,arr)));
    }


    public static int[] locateAllSequenceLocations(int[] target, int[] array){
        int i;
        boolean seqFound = false;
        int numOfTargets = 0;

        for (int p = 0; p < array.length - 1; p++){
            i = 0;
            seqFound = false;
            while (!seqFound && array[p + i] == target[i] ){
                if (i == target.length - 1){
                    numOfTargets++;
                    seqFound = true;
                }
                i++;
            }
        }

        seqFound = false;
        int[] foundSpots = new int[numOfTargets+1];
        foundSpots[0] = numOfTargets;
        int curSpot = 1;
        for (int p = 0; p < array.length - 1; p++){
            i = 0;
            seqFound = false;
            while (!seqFound && array[p + i] == target[i] ){
                if (i == target.length - 1){
                    seqFound = true;
                    foundSpots[curSpot] = p;
                    curSpot++;
                }
                i++;
            }
        }
        return foundSpots;
    }
    
}
