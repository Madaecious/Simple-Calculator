package com.example.calculator;

// These are imports. ---------------------------------------------------------------------------------------
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

// This is the CalculatorController class. ------------------------------------------------------------------
public class CalculatorController {

    // These are FXML injections. ---------------------------------------------------------------------------
    @FXML private Label lblFirstNumber;
    @FXML private Label lblSecondNumber;
    @FXML private Label lblOperation;
    @FXML private TextField txtfldDisplay;
    @FXML private Button bttnSeven;
    @FXML private Button bttnSix;
    @FXML private Button bttnFive;
    @FXML private Button bttnFour;
    @FXML private Button bttnThree;
    @FXML private Button bttnZero;
    @FXML private Button bttnDecimalPoint;
    @FXML private Button bttnAdd;
    @FXML private Button bttnSubtract;
    @FXML private Button bttnMultiply;
    @FXML private Button bttnDivide;
    @FXML private Button bttnCalculate;
    @FXML private Button bttnClear;

    // These are variables. ---------------------------------------------------------------------------------
    boolean firstOperandSet, secondOperandSet;
    boolean containsDecimalPoint, operationPerformed;
    String operationToPerform;
    float firstOperand, secondOperand;
    double result;

    // These are constants. ---------------------------------------------------------------------------------
    String BLANK = "";
    String ADD = "add";
    String SUBTRACT = "subtract";
    String MULTIPLY = "multiply";
    String DIVIDE = "divide";

    // This handles keyboard presses. -----------------------------------------------------------------------
    public void keyboardPress() {
        txtfldDisplay.setText(BLANK);
    }

    // This section handles number button presses. ----------------------------------------------------------
    public void pressSeven() {
        if (maxLengthReached(txtfldDisplay.getText())) return;
        txtfldDisplay.setText(txtfldDisplay.getText() + 7);
    }

    public void pressEight() {
        if (maxLengthReached(txtfldDisplay.getText())) return;
        txtfldDisplay.setText(txtfldDisplay.getText() + 8);
    }

    public void pressNine() {
        if (maxLengthReached(txtfldDisplay.getText())) return;
        txtfldDisplay.setText(txtfldDisplay.getText() + 9);
    }

    public void pressFour() {
        if (maxLengthReached(txtfldDisplay.getText())) return;
        txtfldDisplay.setText(txtfldDisplay.getText() + 4);
    }

    public void pressFive() {
        if (maxLengthReached(txtfldDisplay.getText())) return;
        txtfldDisplay.setText(txtfldDisplay.getText() + 5);
    }

    public void pressSix() {
        if (maxLengthReached(txtfldDisplay.getText())) return;
        txtfldDisplay.setText(txtfldDisplay.getText() + 6);
    }

    public void pressOne() {
        if (maxLengthReached(txtfldDisplay.getText())) return;
        txtfldDisplay.setText(txtfldDisplay.getText() + 1);
    }

    public void pressTwo() {
        if (maxLengthReached(txtfldDisplay.getText())) return;
        txtfldDisplay.setText(txtfldDisplay.getText() + 2);
    }

    public void pressThree() {
        if (maxLengthReached(txtfldDisplay.getText())) return;
        txtfldDisplay.setText(txtfldDisplay.getText() + 3);
    }

    public void pressZero() {
        if (maxLengthReached(txtfldDisplay.getText())) return;
        txtfldDisplay.setText(txtfldDisplay.getText() + 0);
    }

    // This handles the decimal point button press. ---------------------------------------------------------
    public void pressDecimalPoint() {
        if (maxLengthReached(txtfldDisplay.getText()) || containsDecimalPoint) return;
        if (txtfldDisplay.getText().equals(BLANK)) return;
        txtfldDisplay.setText(txtfldDisplay.getText() + ".");
        containsDecimalPoint = true;
    }

    // This handles the add button press. -------------------------------------------------------------------
    public void pressAdd() {
        if (NotReadyForOperation()) return;
        lblFirstNumber.setText(txtfldDisplay.getText());
        setFirstOperand(lblFirstNumber.getText());
        lblOperation.setText("+");
        setOperationToPerform(ADD);
        txtfldDisplay.setText(BLANK);
    }

    // This handles the subtract button press. --------------------------------------------------------------
    public void pressSubtract() {
        if (NotReadyForOperation()) return;
        lblFirstNumber.setText(txtfldDisplay.getText());
        setFirstOperand(lblFirstNumber.getText());
        lblOperation.setText("-");
        setOperationToPerform(SUBTRACT);
        txtfldDisplay.setText(BLANK);
    }

    // This handles the multiply button press. --------------------------------------------------------------
    public void pressMultiply() {
        if (NotReadyForOperation()) return;
        lblFirstNumber.setText(txtfldDisplay.getText());
        setFirstOperand(lblFirstNumber.getText());
        lblOperation.setText("*");
        setOperationToPerform(MULTIPLY);
        txtfldDisplay.setText(BLANK);
    }

    // This handles the divide button press. ----------------------------------------------------------------
    public void pressDivide() {
        if (NotReadyForOperation()) return;
        lblFirstNumber.setText(txtfldDisplay.getText());
        setFirstOperand(lblFirstNumber.getText());
        lblOperation.setText("/");
        setOperationToPerform(DIVIDE);
        txtfldDisplay.setText(BLANK);
    }

    // This ensures that an operator is ready to be selected. -----------------------------------------------
    public boolean NotReadyForOperation() {
        if (operationPerformed) return true;
        if (txtfldDisplay.getText().equals(BLANK)) return true;
        return false;
    }

    // This handles the clear button press. -----------------------------------------------------------------
    public void pressClear() {
        if(operationPerformed) {
            clearDisplays();
            resetVariables();
            return;
        }
        txtfldDisplay.setText(BLANK);
    }

    // This handles the calculate button press. -------------------------------------------------------------
    public void pressCalculate() {
        if (!firstOperandSet || txtfldDisplay.getText().equals(BLANK)) return;
        lblSecondNumber.setText(txtfldDisplay.getText());
        setSecondOperand(txtfldDisplay.getText());
        secondOperandSet = true;

        switch (operationToPerform) {
            case "add":
                result = firstOperand + secondOperand;
                break;
            case "subtract":
                result = firstOperand - secondOperand;
                break;
            case "multiply":
                result = firstOperand * secondOperand;
                break;
            case "divide":
                result = firstOperand / secondOperand;
                break;
        }

        txtfldDisplay.setText(String.valueOf(result));
        operationPerformed = true;
    }

    // This clears all the displays. ------------------------------------------------------------------------
    public void clearDisplays() {
        lblFirstNumber.setText(BLANK);
        lblSecondNumber.setText(BLANK);
        lblOperation.setText(BLANK);
        txtfldDisplay.setText(BLANK);
    }

    // This resets all the variables to default values. -----------------------------------------------------
    public void resetVariables() {
        firstOperandSet = secondOperandSet = containsDecimalPoint = operationPerformed = false;
        operationToPerform = BLANK;
        firstOperand = secondOperand = 0.0F;
        result = 0.0;
    }

    // This sets the value of the first operand. ------------------------------------------------------------
    public void setFirstOperand(String strFirstOperand) {
        firstOperand = Float.parseFloat(strFirstOperand);
        firstOperandSet = true;
    }

    // This sets the value of the second operand. -----------------------------------------------------------
    public void setSecondOperand(String strSecondOperand) {
        secondOperand = Float.parseFloat(strSecondOperand);
    }

    // This sets the operation to perform. ------------------------------------------------------------------
    public void setOperationToPerform(String desiredOperation) {
        operationToPerform = desiredOperation;
    }

    // This ensures the length of the operands are less than eight digits. ----------------------------------
    public boolean maxLengthReached(String operand) {
        if (operand.length() >= 8) return true;
        return false;
    }

} // End of CalculatorController class. ---------------------------------------------------------------------