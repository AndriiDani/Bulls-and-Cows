package logics;


import javax.swing.*;

public class ErrorType {
    JOptionPane error = new JOptionPane();

    public void Error(Condition cond) {
        error.showMessageDialog(null, "Ви задали число неправильно формату.\nКількість цифр в числі правильного формату: " + cond.getSize());
    }

    public void Error1() {
        error.showMessageDialog(null, "Вами не було введено число.");
    }

    public void Error2() {
        error.showMessageDialog(null, "Ви вже вводили дане число");
    }

    public void GiveUp(GenerateNumb go) {
        error.showMessageDialog(null, "Ви програли!\nПравильним числом було:" + go.getNumbStr());
    }
}
