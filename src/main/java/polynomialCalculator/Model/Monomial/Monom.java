package polynomialCalculator.Model.Monomial;

public class Monom {

    private double coeficient;
    private int grad;

    public Monom(double coeficient, int grad) {
        this.coeficient = coeficient;
        this.grad = grad;
    }

    public double getCoeficient() {
        return this.coeficient;
    }

    public int getGrad() {
        return this.grad;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public String toString(boolean withDecimals) {
        String result = "";
        if (coeficient > 0) {
            if (coeficient == 1) {
                if (grad == 0)
                    result = (withDecimals) ? "+" + String.format("%.2f", coeficient) : "+" + (int) coeficient;
                else
                    result = "+";
            } else
                result = (withDecimals) ? "+" + String.format("%.2f", coeficient) : "+" + (int) coeficient;
        } else {
            if (coeficient == -1) {
                if (grad == 0)
                    result = (withDecimals) ? "" + String.format("%.2f", coeficient) : "" + (int) coeficient;
                else
                    result = "-";
            } else
                result = (withDecimals) ? "" + String.format("%.2f", coeficient) : "" + (int) coeficient;
        }
        if (grad > 0) {
            if (grad == 1)
                result = result + "x";
            else
                result = result + "x^" + grad;
        }

        return result;
    }
}