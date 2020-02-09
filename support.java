import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class support{

    //holds the user inputted check
    //index 0 is for black, index 1 is for white
    private static int check[] = new int[2]; 
  
    //holds the code that the program will guess and present to the user
    private static int guess = 0;
    
    //contains all codes that are still possible solutions 
    private static ArrayList<Integer> remainingPossibilities = new ArrayList<Integer>();
    

    // this method prompts the user to input the number of white and black pins, aka the check. Called after program outputs a guess
    public static void recieveCheck(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the number of colors/numbers that are in the correct spot AND the correct color/number, AKA BLACK.");
        check[0] = keyboard.nextInt();

        System.out.println("Enter the number of colors/numbers that are the correct color/number, but not in the correct spot, AKA WHITE.");
        check[1] = keyboard.nextInt();
    }

    //this method determines if the program's guess, the user provided check, and the iterated code in remainingPossibilities are equal/valid
    public static boolean checkGuess(int code_in_array){
        int check2[] = getCheck(guess, code_in_array);
        if(check[0]==check2[0] && check[1]==check2[1]){
            return true;
        }else{
            return false;
        }
    }

    //this method returns the check for two codes. 
    //returns an array[2] where [0] is for black and [1] is for white. Still works if you input the codes (guess, code_in_array) in any order. 
    public static int[] getCheck(int guess, int code_in_array){
        
        int a, b, c;
        a=guess%1000;
        b=a%100;
        c=b%10;
        int code1digit1= (guess-a)/1000;
        int code1digit2= (a-b)/100;
        int code1digit3= (b-c)/10;
        int code1digit4= c; 

        a = code_in_array%1000;
        b=a%100;
        c=b%10;
        int code2digit1= (code_in_array-a)/1000;
        int code2digit2= (a-b)/100;
        int code2digit3= (b-c)/10;
        int code2digit4= c;

        int blackCount = 0;
        int whiteCount = 0;
        
        boolean d11, d12, d13, d14, d21, d22, d23, d24; 
        d11 = true;
        d12 = true;
        d13 = true;
        d14 = true;
        d21 = true;
        d22 = true;
        d23 = true;
        d24 = true;
        
        //check for black digits
        if(code1digit1==code2digit1){
            blackCount++;
            d11 = false;
            d21 = false;
        }
        if(d12 && d22 && code1digit2==code2digit2){
            blackCount++;
            d12 = false;
            d22 = false;
        }
        if(d13 && d23 && code1digit3==code2digit3){
            blackCount++;
            d13 = false;
            d23 = false;
        }
        if(d14 && d24 && code1digit4 == code2digit4){
            blackCount++;
            d14 = false;
            d24 = false;
        } 

        //check for white digits
        if (d11 && d22 && code1digit1==code2digit2){
            whiteCount++;
            d11 = false; 
            d22 = false;
        }else if(d11 && d23 && code1digit1==code2digit3){
            whiteCount++;
            d11 = false;
            d23 = false;
        }else if(d11 && d24 && code1digit1==code2digit4){
            whiteCount++;           
            d11 = false;
            d24 = false;
        }

        if(d12 && d21 && code1digit2==code2digit1){
            whiteCount++;
            d12 = false;
            d21 = false;
        }else if(d12 && d23 && code1digit2==code2digit3){
            whiteCount++;
            d12 = false;
            d23 = false;
        }else if(d12 && d24 && code1digit2==code2digit4){
            whiteCount++;
            d12 = false;
            d24 = false;
        }
       
        if(d13 && d21 && code1digit3==code2digit1){
            whiteCount++;
            d13 = false;
            d21 = false;
        }else if(d13 && d22 && code1digit3==code2digit2){
            whiteCount++;
            d13 = false;
            d22 = false;
        }else if(d13 && d24 && code1digit3==code2digit4){
            whiteCount++;
            d13 = false;
            d24 = false;
        }
        
        if(d14 && d21 && code1digit4==code2digit1){
            whiteCount++;
        }else if (d14 && d22 && code1digit4 == code2digit2){
            whiteCount++;
        }else if (d14 && d23 && code1digit4 == code2digit3){
            whiteCount++;
        }
        
        int z[] = new int[2];
        z[0] = blackCount;
        z[1] = whiteCount;
        return z;
    }


    //this method selects which code to guess 
    public static int guessCode(ArrayList remainingPossibilities){
         
        if(remainingPossibilities.contains(1122)){
            guess = 1122;
            return 1122;
        }
        
        if(remainingPossibilities.contains(2233)){
            guess = 2233;
            return 2233;
        }
        if(remainingPossibilities.contains(3344)){
            guess = 3344;
            return 3344;
        }
        
        if(remainingPossibilities.contains(4455)){
            guess = 4455;
            return 4455;
        }
        if(remainingPossibilities.contains(5566)){
            guess = 5566;
            return 5566;
        }
        if(remainingPossibilities.contains(1133)){
            guess = 1133;
            return 1133;
        }
        if(remainingPossibilities.contains(1144)){
            guess = 1144;
            return 1144;
        }
        if(remainingPossibilities.contains(1155)){
            guess = 1155;
            return 1155;
        }
        if(remainingPossibilities.contains(1166)){
            guess = 1166;
            return 1166;
        }
        if(remainingPossibilities.contains(2211)){
            guess = 2211;
            return 2211;
        }
        if(remainingPossibilities.contains(2233)){
            guess = 2233;
            return 2233;
        }
        if(remainingPossibilities.contains(2244)){
            guess = 2244;
            return 2244;
        }
        if(remainingPossibilities.contains(2255)){
            guess = 2255;
            return 2255;
        }
        if(remainingPossibilities.contains(2266)){
            guess = 2266;
            return 2266;
        }
        if(remainingPossibilities.contains(3355)){
            guess = 3355;
            return 3355;
        }
        if(remainingPossibilities.contains(3366)){
            guess = 3366;
            return 3366;
        }
        
            Integer q = (Integer) remainingPossibilities.get(remainingPossibilities.size()/2);
            guess = q;
            return q;
            
        
    }
    
    //getter method for remainingPossibilities
    public static ArrayList getRemainingPossibilities(){
        return remainingPossibilities;
    }

    //this method removes an element from remainingPossibilities at a desired index
    public static void removeFromRemainingPossibilities(int i){  
        remainingPossibilities.remove(i);
    }
    
    //getter method for remainingPossibilities
    public static int getElement(int i){
        return (int) remainingPossibilities.get(i);
    }

    //returns size of remainingPossibilities arrayList
    public static int getSize(){
        return remainingPossibilities.size();
    }
    
    //sets a desired index in remainingPossibilities to 0. 
    public static void setZero(int i){
        remainingPossibilities.set(i, 0);
    }
    
    //this method removes all zeroes from remainingPossibilities
    public static void removeZeroesFromRemainingPossibilities(){
        Object[] temp_array = remainingPossibilities.toArray();
        remainingPossibilities.clear();
        for(int i = 0; i < temp_array.length; i++){
            if((int) temp_array[i] == 0){
            }else{
                remainingPossibilities.add((int) temp_array[i]);
            }
        }
    }
   
    //getter method for var guess
    public static int getGuess(){
       return guess;
    }


    //this method is used for the automation class.
    public static void modifyCheck(int[] check1){
        check[0] = check1[0];
        check[1] = check1[1];
    }
    
    //this method fills the arrayList with every possible code. called once at beginning of program
    public static void fillRemainingPossibilities(){
            int i = 0;
            for(int a = 1; a<=6; a++){
                for(int b = 1; b<=6;b++){
                    for (int c = 1; c<=6;c++){
                        for(int d = 1;d<=6;d++){
                             
                            String as = Integer.toString(a);
                            String bs = Integer.toString(b);
                            String cs = Integer.toString(c);
                            String ds = Integer.toString(d);
                                   
                            remainingPossibilities.add(Integer.parseInt(as + bs + cs + ds));
                            automate.getAllCodes().add(Integer.parseInt(as + bs + cs + ds));
                            
                            i++;
                        }
                    }
                }
            }
    }
}

