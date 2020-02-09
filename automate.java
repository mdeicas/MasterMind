import java.util.ArrayList;
public class automate{
    private static int iteration = 0; // number of guesses program makes before solving
    private static int[] iarr = new int[1296]; //index is the round#, element is iteration
    private static int round = 0;
    private static int code = 0; // the actual code
    private static ArrayList<Integer> allCodes = new ArrayList<Integer>();



    //iteration stuff
    public static void addIteration(){
        iteration++;
    }
    public static void addRound(){
        round++;
    }
    public static int getRound(){
        return round;
    }
    public static void saveIteration(){ 
        iarr[round] = iteration;
    }
    public static void printIterations(){
        double avg = 0;
        for(int i = 0; i<1296; i++){
            //System.out.print(iarr[i] + " ");
            avg += iarr[i];
        }
        avg = avg/1296;
        System.out.println("The average number of guesses this program takes to find the secret code is " + avg);
    }
    
    public static void zeroIteration(){
        iteration = 0;
    }
    
    
    


    //
    public static ArrayList getAllCodes(){
        return allCodes;
    }

    public static void createCode(){
        code = (int) allCodes.get(round);
    }

    //this checks the actual secret code with the guess of that iteration. 
    public static void recieveCheck(){
        support.modifyCheck(support.getCheck(code, support.getGuess()));
    }
    
    public static void printRound(){
        System.out.print(round + "--");
    }
    
    public static void printActualCode(){
        System.out.println(code);
    }













}