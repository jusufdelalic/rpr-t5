package ba.unsa.etf.rpr.tutorijal05;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class Controller {


    private String displayText;
    private int lastOperation;
    private String firstInput;
    private ArrayList<Button> digits = new ArrayList<>(10);
    private ArrayList<Button> operators = new ArrayList<>(7);

    boolean decimalSeparator = false;
    boolean newNumber = false;

    public Label display;

    public Controller() {
        displayText = "0";
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String value) {

        displayText = value;
    }

    private void numberInput(String number) {

        if (lastOperation == 0) {
            if (getDisplayText().length() > 9)
                return;
            setDisplayText(getDisplayText() + number); //adding a new number
        }
        else {
            if (newNumber) {
                setDisplayText(number);
                newNumber = false;
                decimalSeparator = false;
            }
            else {
                if (getDisplayText().length() > 9)
                    return;
                setDisplayText(getDisplayText() + number);
            }
        }
        if (getDisplayText().charAt(0) == '0' && getDisplayText().length() == 2 && getDisplayText().charAt(1) != '.')
            setDisplayText(getDisplayText().substring(1)); // 05 = 5
    }

    public void inputZero(ActionEvent actionEvent) {
        numberInput("0");
    }
    public void inputOne(ActionEvent actionEvent) {
        numberInput("1");
    }
    public void inputTwo(ActionEvent actionEvent) {
        numberInput("2");
    }
    public void inputThree(ActionEvent actionEvent) {
        numberInput("3");
    }
    public void inputFour(ActionEvent actionEvent) {
        numberInput("4");
    }
    public void inputFive(ActionEvent actionEvent) {
        numberInput("5");
    }
    public void inputSix(ActionEvent actionEvent) {
        numberInput("6");
    }
    public void inputSeven(ActionEvent actionEvent) {
        numberInput("7");
    }
    public void inputEight(ActionEvent actionEvent) {
        numberInput("8");
    }
    public void inputNine(ActionEvent actionEvent) {
        numberInput("9");
    }




}
