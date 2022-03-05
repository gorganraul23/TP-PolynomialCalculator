package TestPolynomial;

import org.junit.Test;
import polynomialCalculator.Model.Operations;
import polynomialCalculator.Model.ParsingData;
import polynomialCalculator.Model.Polynomial.Polinom;
import polynomialCalculator.exceptions.IllegalDivisionException;

import static org.junit.Assert.assertEquals;

public class DivideTest {

    @Test
    public void divisionTest() throws IllegalDivisionException {
        String pol1 = "x^3-2x^2+6x+1", pol2 = "x^2-1";
        Polinom p1 = ParsingData.ParseData(pol1);
        Polinom p2 = ParsingData.ParseData(pol2);

        assertEquals(Operations.division(p1, p2) , "q: x-2.00, r: 7.00x-7.00");
    }
}
