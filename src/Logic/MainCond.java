package Logic;
import Interface.Reader;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MainCond extends GenerateNumb {
public int guesses = 0;
Reader r1 = new Reader(null);

public void cond(){
    boolean guessed = false;
    int bullcount = 0;
    int cowcount = 0;
    for(int i= 0;i < 4;i++){
        if(r1.guessStr.charAt(i) == numbStr.charAt(i)){
            bullcount++;
        }else if(numbStr.contains(r1.guessStr.charAt(i)+"")){
            cowcount++;
        }
    }
    if(bullcount == 4){
        guessed = true;
    }else{
        System.out.println(cowcount+" Корів і "+bullcount+" биків");

}if(guessed == true){
    System.out.println("Ви виграли за "+guesses+" спроб.");
}

}}
