package Logic;
import Interface.Reader;

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
        r1.area.setText((Integer.toString(cowcount)+" Корів і "+Integer.toString(bullcount)+" биків"));

}if(guessed == true){
        r1.area.append("Ви виграли за "+Integer.toString(guesses)+" спроб.");
}

}}
