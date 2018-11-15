package ba.unsa.etf.rpr.tutorijal05;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class Controller {


    private SimpleStringProperty displayText;
    private int lastOperation;
    private String firstInput;

    public Label display;

    public Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;

    public Button equalsBtn;
    public Button plusBtn;
    public Button minusBtn;
    public Button percentageBtn;
    public Button multiplyBtn;
    public Button divideBtn;
    public Button dotBtn;

    private boolean decimalSeparator = false;
    private boolean newNumber = true;



    public Controller() {
        displayText = new SimpleStringProperty("0");
    }

    public SimpleStringProperty displayTextProperty () {
        return displayText;
    }

    public String getDisplayText() {
        return displayText.get();
    }

    public void setDisplayText(String value) {
        displayText.set(value);
    }

    private void numberInput(String number) {

        if (lastOperation == 0) {
            if (getDisplayText().length() > 9) // max length
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

    public void equalClick (ActionEvent actionEvent) throws IllegalArgumentException{


            String secondInput = getDisplayText();

            double firstNumber = Double.parseDouble(firstInput);
            double secondNumber = Double.parseDouble(secondInput);

            double result;
            switch (lastOperation) { // doing some math....
                case 1:
                    if((int) firstNumber != firstNumber || (int) secondNumber != secondNumber)
                        throw new IllegalArgumentException("Remainder not defined for non-integers");

                    result = firstNumber % secondNumber; // here "%" represents the remainder operator (defined only for integers) instead of the percentage
                    break;
                case 2:
                    if(secondNumber == 0) throw new IllegalArgumentException ("Division by zero");
                    result = firstNumber / secondNumber;
                    break;
                case 3:
                    result = firstNumber * secondNumber;
                    break;
                case 4:
                    result = firstNumber - secondNumber;
                    break;
                case 5:
                    result = firstNumber + secondNumber;
                    break;
                default:
                    return;
            }

            setDisplayText(String.valueOf(result));

            lastOperation = 0;
            newNumber = true;



        }

    public void decimalSeparatorClick(ActionEvent actionEvent) {
        if (lastOperation == 0 && !decimalSeparator) {
            setDisplayText(getDisplayText() + ".");
            decimalSeparator = true;
        } else if (lastOperation != 0) {
            if (newNumber) {
                setDisplayText("0.");
                newNumber = false;
                decimalSeparator = true;
            } else if (!decimalSeparator) {
                setDisplayText(getDisplayText() + ".");
                decimalSeparator = true;
            }
        }
    }

    private void operationInput (int number) {

        if (lastOperation != 0)
            equalClick(null);
        lastOperation = number;
        firstInput = getDisplayText();
    }

    public void percentageClick(ActionEvent actionEvent) {

        operationInput(1);
    }

    public void divideClick(ActionEvent actionEvent) {

        operationInput(2);
    }

    public void multiplyClick(ActionEvent actionEvent) {

        operationInput(3);
    }



    public void substractClick(ActionEvent actionEvent) {

        operationInput(4);
    }


    public void addClick(ActionEvent actionEvent) {

        operationInput(5);
    }


    public void inputZero(ActionEvent actionEvent) { numberInput("0"); }
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

    public void keyboardPress(javafx.scene.input.KeyEvent keyEvent) { // support for keyboard
        switch (keyEvent.getCode()) {
            case NUMPAD0:
                btn0.requestFocus();
                inputZero(null);
                break;
            case NUMPAD1:
                btn1.requestFocus();
                inputOne(null);
                break;
            case NUMPAD2:
                btn2.requestFocus();
                inputTwo(null);
                break;
            case NUMPAD3:
                btn3.requestFocus();
                inputThree(null);
                break;
            case NUMPAD4:
                btn4.requestFocus();
                inputFour(null);
                break;
            case NUMPAD5:
                btn5.requestFocus();
                inputFive(null);
                break;
            case NUMPAD6:
                btn6.requestFocus();
                inputSix(null);
                break;
            case NUMPAD7:
                btn7.requestFocus();
                inputSeven(null);
                break;
            case NUMPAD8:
                btn8.requestFocus();
                inputEight(null);
                break;
            case NUMPAD9:
                btn9.requestFocus();
                inputNine(null);
                break;
            case DECIMAL:
                dotBtn.requestFocus();
                decimalSeparatorClick(null);
                break;
            case DIVIDE:
                divideBtn.requestFocus();
                divideClick(null);
                break;
            case MULTIPLY:
                multiplyBtn.requestFocus();
                multiplyClick(null);
                break;
            case SUBTRACT:
                minusBtn.requestFocus();
                substractClick(null);
                break;
            case ADD:
                plusBtn.requestFocus();
                addClick(null);
                break;
            case PLUS:
                percentageBtn.requestFocus();
                percentageClick(null);
                break;
            case ENTER:
                equalsBtn.requestFocus();
                equalClick(null);
                break;
            case BACK_SPACE:
                display.requestFocus();
                if (displayText.get().length() != 0) {
                    if (displayText.get().charAt(displayText.get().length() - 1) == '.')
                        decimalSeparator = false;
                    displayText.set(displayText.get().substring(0, displayText.get().length() - 1)); // deleting one number or decimal separator
                }
                break;
            case DELETE: // default look
                display.requestFocus();
                displayText.set("0");
                decimalSeparator = false;
                break;
        }
    }
}



