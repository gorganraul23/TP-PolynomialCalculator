package TestPolynomial;

import org.junit.Test;
import polynomialCalculator.Model.Operations;
import polynomialCalculator.Model.ParsingData;
import polynomialCalculator.Model.Polynomial.Polinom;

import static org.junit.Assert.assertEquals;

public class IntegrateTest {

    @Test
    public void integrateTest() {
        String pol1 = "x^3-2x^2+6x+1";
        Polinom p1 = ParsingData.ParseData(pol1);

        assertEquals(Operations.integrate(p1).toString(true), "0.25x^4-0.67x^3+3.00x^2+x");
    }
}
