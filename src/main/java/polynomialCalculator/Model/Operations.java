package polynomialCalculator.Model;

import polynomialCalculator.Model.Monomial.Monom;
import polynomialCalculator.Model.Polynomial.Polinom;
import polynomialCalculator.exceptions.IllegalDivisionException;
import polynomialCalculator.exceptions.NoInputException;
import polynomialCalculator.exceptions.WrongInputException;

import java.util.Iterator;

public class Operations {

    public static Polinom sum(Polinom p1, Polinom p2) {
        Polinom result = new Polinom();
        Iterator it1 = p1.getPolinom().iterator(), it2 = p2.getPolinom().iterator();
        Monom mn1 = (Monom) it1.next(), mn2 = (Monom) it2.next(), stop = new Monom(0, -1), mn3;

        do {
            if (mn1.getGrad() > mn2.getGrad()) {        //daca gradul primului e mai mare -> il adaug la rezultat si iterez
                result.getPolinom().add(mn1);
                if (it1.hasNext())
                    mn1 = (Monom) it1.next();       //stop e ca un flag ca nu mai are elemente (cu hasNext nu puteam
                else mn1 = stop;                    //procesa ultimul element din fiecare polinom)
            } else if (mn1.getGrad() < mn2.getGrad()) {
                result.getPolinom().add(mn2);           //daca al doilea are grad mai mare, il adaug si il iterez
                if (it2.hasNext())
                    mn2 = (Monom) it2.next();
                else mn2 = stop;
            } else {
                mn3 = new Monom(mn1.getCoeficient() + mn2.getCoeficient(), mn1.getGrad());
                result.getPolinom().add(mn3);
                if (it1.hasNext())
                    mn1 = (Monom) it1.next();       //daca sunt egale ca grad, se aduna coeficientii si se itereaza ambele
                else mn1 = stop;
                if (it2.hasNext())
                    mn2 = (Monom) it2.next();
                else mn2 = stop;
            }
        } while (mn1.getGrad() != -1 || mn2.getGrad() != -1);   //cat timp mai sunt monoame in cele 2 polinoame
        return result;
    }

    public static Polinom subtract(Polinom p1, Polinom p2) {
        for (Monom monom : p2.getPolinom()) {                   //inmultesc P2 cu -1 si adun la P1
            monom.setCoeficient(monom.getCoeficient() * (-1));
        }
        return sum(p1, p2);
    }

    public static Polinom derivative(Polinom p) {
        for (Monom m : p.getPolinom()) {
            m.setCoeficient(m.getCoeficient() * m.getGrad());   //noul coef e coef*grad
            if (m.getGrad() != 0)
                m.setGrad(m.getGrad() - 1);     //daca gradul nu e deja 0, scadem
        }
        return p;
    }

    public static Polinom integrate(Polinom p) {
        for (Monom m : p.getPolinom()) {
            m.setCoeficient(m.getCoeficient() / (m.getGrad() + 1));
            m.setGrad(m.getGrad() + 1);
        }
        return p;
    }

    public static Polinom multiplication(Polinom p1, Polinom p2) {
        Polinom firstResult = new Polinom(), result = new Polinom(), temp;
        Monom monom;
        for (Monom m1 : p1.getPolinom()) {    //fac toate inmultirile, element cu element
            for (Monom m2 : p2.getPolinom()) {
                monom = new Monom(m1.getCoeficient() * m2.getCoeficient(), m1.getGrad() + m2.getGrad());
                firstResult.getPolinom().add(monom);
            }
        }
        for (Monom m : firstResult.getPolinom()) {       //adunari succesive pentru a finaliza result
            temp = new Polinom();
            temp.getPolinom().add(m);
            if (result.getPolinom().size() == 0)
                result.getPolinom().add(new Monom(0, 0));
            result = sum(result, temp);
        }
        return result;
    }

    public static String division(Polinom p, Polinom q) throws IllegalDivisionException {
        Polinom quotient = new Polinom(), reminder = new Polinom(), qTemp = new Polinom();
        Monom quotientMonom;    //monomul din quotient folosit la inmultirea cu Q
        double coefP, coefQ = q.getPolinom().get(0).getCoeficient();
        int gradP = p.getPolinom().get(0).getGrad(), gradQ = q.getPolinom().get(0).getGrad();
        if (coefQ == 0 || gradP < gradQ) {
            throw new IllegalDivisionException("Incorrect degrees! Please retry");
        }

        while (p.getPolinom().size() != 0 && p.getPolinom().get(0).getGrad() >= q.getPolinom().get(0).getGrad()) {        //gradul lui p >= grad q sau se imparte exact la q
            coefP = p.getPolinom().get(0).getCoeficient();
            gradP = p.getPolinom().get(0).getGrad();
            coefQ = q.getPolinom().get(0).getCoeficient();
            gradQ = q.getPolinom().get(0).getGrad();
            quotientMonom = new Monom(coefP / coefQ, gradP - gradQ);    //impart primii monomi
            quotient.getPolinom().add(quotientMonom);       //adaug noul rezultat
            qTemp.getPolinom().clear();
            qTemp.getPolinom().add(quotientMonom);      //tin in qTemp doar monomul cu care inmultesc (multiplication ia ca argumente 2 polinoame
            reminder = subtract(p, multiplication(qTemp, q));
            p.getPolinom().clear();
            for (Monom m : reminder.getPolinom())    //copiez reminder in p, dar doar monomii cu coeficienti nenuli
                if (m.getCoeficient() != 0)
                    p.getPolinom().add(m);
        }
        return "Q: " + quotient.toString(true) + "; R: " + reminder.toString(true);
    }

    public static Polinom getParsedInput(String viewInput) throws WrongInputException, NoInputException {
        Polinom p;          //functie cu care iau direct inputul parsat
        String input = "";
        if (viewInput.equals(""))
            throw new NoInputException("Please complete the polynomials."); //exceptie daca nu se da nimic la input
        input += viewInput;
        p = ParsingData.ParseData(input);
        if (!p.toString(false).equals(input))   //dupa parsare, reconstruiesc stringul
            if (!input.equals("0"))
                throw new WrongInputException("Wrong input! Please retry.");    //daca nu e la fel - input gresit(nu respecta pattern)

        return p;
    }

}
