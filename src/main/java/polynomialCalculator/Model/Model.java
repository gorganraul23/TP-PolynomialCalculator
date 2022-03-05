package polynomialCalculator.Model;

import java.math.BigDecimal;

public class Model {

    private static final String RESET_VALUE = "0";
    private BigDecimal displayed_value;

    public Model() {
        reset();
    }

    public void reset() {
        displayed_value = new BigDecimal(RESET_VALUE);      //functie de reset pentru model
    }

    public void setValue(String value) {
        displayed_value = new BigDecimal(value);
    }

    public static String getResetValue() {
        return RESET_VALUE;
    }       //getter pentru constanta clasei
}
