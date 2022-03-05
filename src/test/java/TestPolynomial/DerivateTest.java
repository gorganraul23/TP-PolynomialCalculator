package TestPolynomial;

import org.junit.Test;
import polynomialCalculator.Model.Operations;
import polynomialCalculator.Model.ParsingData;
import polynomialCalculator.Model.Polynomial.Polinom;

import static org.junit.Assert.assertEquals;

public class DerivateTest {

    @Test
    public void derivateTest() {
        String pol1 = "x^3-2x^2+6x+1";
        Polinom p1 = ParsingData.ParseData(pol1);

        assertEquals(Operations.derivative(p1).toString(false), "3x^2-4x+6");
    }
}
