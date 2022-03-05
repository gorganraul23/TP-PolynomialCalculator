package polynomialCalculator.Model;

import polynomialCalculator.Model.Monomial.Monom;
import polynomialCalculator.Model.Polynomial.Polinom;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingData {

    public static Polinom ParseData(String string) {
        final String regex = ("(\\+|-)?(\\d+x|\\d+|x|-x)(\\^\\d+)?");
        String coefString = "", gradString = "";
        Polinom polinom = new Polinom();
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {                            //pentru fiecare monom, iau fiecare grup
            if (!matcher.group(0).isEmpty()) {
                if (matcher.group(1) != null && matcher.group(1).equals("-"))       //grupul de semn
                    coefString += "-";
                if (matcher.group(2) != null && (matcher.group(2).equals("x") || matcher.group(2).equals("1")))
                    coefString += "1";
                else if (matcher.group(2) != null) {
                    if (matcher.group(2).length() == 1)     //constriesc coef din grupul 2 care contine coef si x
                        coefString += matcher.group(2);
                    else
                        coefString += matcher.group(2).substring(0, matcher.group(2).length() - 1);  //ultimul e x, il scot
                }
                if (matcher.group(3) != null) {     //grupul 3 e puterea
                    gradString += matcher.group(3).substring(1);    //daca e null inseamna ca e grad 0 sau 1
                } else {
                    if (matcher.group(2) != null && matcher.group(2).endsWith("x"))     //daca contine x, e 1, daca nu e 0
                        gradString += "1";
                    else if (matcher.group(2) != null)
                        gradString += "0";
                }
            }
            polinom.getPolinom().add(new Monom(Double.parseDouble(coefString), Integer.parseInt(gradString)));
            coefString = "";
            gradString = "";
        }
        return polinom;
    }

}





