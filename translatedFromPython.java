public class translatedFromPython {
    public static void main(String[] args){

        int size = 10;
        int [] numbers = new int[size];
        for (int i = 0; i < size; i++){
            if (i < 3){
                numbers[i] = i;
            }else if (i < 6){
                numbers[i] = i + 10;
            }else{
                numbers[i] = i*10;
            }
        }

        for (int k = 0; k < size; k++){
            System.out.print(numbers[k]);
        }
    }
}
