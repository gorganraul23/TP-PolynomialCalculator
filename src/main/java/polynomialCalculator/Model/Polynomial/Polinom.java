package polynomialCalculator.Model.Polynomial;

import polynomialCalculator.Model.Monomial.Monom;

import java.util.ArrayList;
import java.util.List;

public class Polinom {

    private List<Monom> list;

    public Polinom() {
        list = new ArrayList<Monom>();
    }

    public List<Monom> getPolinom() {
        return this.list;
    }

    public String toString(boolean withDecimals) {
        String result = "";
        for (Monom m : this.list)
            if (m.getCoeficient() != 0)
                result = result + m.toString(withDecimals);

        return (result.startsWith("+")) ? result.substring(1) : result;
    }

}
