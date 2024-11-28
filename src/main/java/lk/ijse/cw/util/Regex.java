package lk.ijse.cw.util;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static boolean isTextFieldValid(TxtField TXT, String text) {
        String field = "";

        switch (TXT) {
            case NAME:
                field = "^[A-Za-z]+$";
            case ADDRESS:
                field = "^[a-zA-Z ]+$";
                break;
            case DURATION:
                field = "^(?=.*\\b(?:months|years)\\b)(?=\\D*\\d{2}\\D*\\d{0})[0-9]{2} (months|years)$";
                break;
            case PRICE:
                field = "^[0-9]+$";
                break;
            case PRICEDOT:
                field = "^\\d[\\.\\d]*$";
                break;
            case TEL:
                field = "^\\d{10}$";
            case INTID:
                field = "^\\d+$";
                break;
            case EMAIL:
                field = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\n";
                break;
        }



        Pattern pattern = Pattern.compile(field);

        if (text != null && !text.trim().isEmpty()) {
            Matcher matcher = pattern.matcher(text);
            return matcher.matches();
        }
        return false;
    }

    public static boolean setTextColor(TxtField textField, javafx.scene.control.TextField fxTextField) {
        boolean isValid = isTextFieldValid(textField, fxTextField.getText());
        if (isValid) {
            fxTextField.setStyle("-fx-border-color: green; -fx-unfocus-color: green;");
        } else {
            fxTextField.setStyle("-fx-border-color: red; -fx-unfocus-color: red;");
        }
        return isValid;
    }
}