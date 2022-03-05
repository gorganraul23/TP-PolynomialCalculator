package TestPolynomial;

import org.junit.Test;
import polynomialCalculator.Model.Operations;
import polynomialCalculator.Model.ParsingData;
import polynomialCalculator.Model.Polynomial.Polinom;

import static org.junit.Assert.assertEquals;

public class SumTest {

    @Test
    public void sumTest() {
        String pol1 = "x^3-2x^2+6x+1", pol2 = "x^2-1";
        Polinom p1 = ParsingData.ParseData(pol1);
        Polinom p2 = ParsingData.ParseData(pol2);

        assertEquals(Operations.sum(p1, p2).toString(false), "x^3-x^2+6x");
    }

}
