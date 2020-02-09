import java.util.Scanner;
public class mastermind{
    public static void main(String[] args){
        System.out.println("Welcome! I will solve Mastermind for you.");
        support.fillRemainingPossibilities();
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter m if you would like to play manually. Otherwise enter any other key.");
        if (keyboard.nextLine().equals("m")){
                
                System.out.println("size:" + support.getSize());
                while(support.getRemainingPossibilities().size()>1){ //if there is more than 1 possible code left, loop will run
                
                    support.guessCode(support.getRemainingPossibilities()); //guesses code 
                    System.out.println("My guess is: " + support.getGuess()); //prints guess to user
                    support.recieveCheck();                                    //asks user for check and stores it 
                    
                    //for each remaining code, determine if it matches up with the guess and the check. 
                    //if it does not match up, change element to 0. If it matches up, do not change element
                    for(int i=0; i<support.getRemainingPossibilities().size(); i++){ 
                            if(support.checkGuess(support.getElement(i))){
                            }else{
                               support.setZero(i);    
                            }
                    }

                    //this method returns remainingPossibilities with all of elements = 0 removed
                    support.removeZeroesFromRemainingPossibilities(); 
                    System.out.println("size:" + support.getSize());
                    
                    //prints out all of the remaining possiblities. not required to run program
                    System.out.print("The remaining possibilities are: ");
                    for(int i = 0; i<support.getRemainingPossibilities().size(); i++){
                        System.out.print(support.getRemainingPossibilities().get(i) + "  ");
                    }
                    System.out.println("");
                    
                }
            
        }else{
            while(automate.getRound()<1296){
                while(support.getRemainingPossibilities().size()>1){
                    automate.createCode();
                    support.guessCode(support.getRemainingPossibilities());
                    //System.out.println("My guess is: " + support.passGuess());
                    automate.recieveCheck();
                    for(int i=0; i<support.getRemainingPossibilities().size(); i++){
                            if(support.checkGuess(support.getElement(i))){
                            }else{
                               support.setZero(i);    
                            }
                    }

                    support.removeZeroesFromRemainingPossibilities();
                    //System.out.println("size:" + support.getSize());
                    /**
                    for(int i = 0; i<support.getRemainingPossibilities().size(); i++){
                        System.out.print(support.getRemainingPossibilities().get(i) + "  ");
                    }
                    **/
                    //System.out.println("");
                    automate.addIteration();
                }
                support.fillRemainingPossibilities();
                automate.saveIteration();
                automate.addRound();
                automate.zeroIteration();
            }
            automate.printIterations();
            
        }    
    

    }       
}


