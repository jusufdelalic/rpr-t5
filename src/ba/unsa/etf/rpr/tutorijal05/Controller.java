package ba.unsa.etf.rpr.tutorijal05;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.ArrayList;

public class Controller {


    private String displayText;
    private int lastOperation;
    private String firstInput;
    private ArrayList<Button> digits = new ArrayList<Button>(10);
    private ArrayList<Button> operators = new ArrayList<Button>(7);

    boolean decimalSeparator = false;
    boolean newNumber = false;

    public Label display;

    public Controller() {
        displayText = new String("0");
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

    public void inputOne(ActionEvent actionEvent) {
        numberInput("1");
    }


}
