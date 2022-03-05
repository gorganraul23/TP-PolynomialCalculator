package polynomialCalculator;

import polynomialCalculator.Model.Model;
import polynomialCalculator.UI.Controller;
import polynomialCalculator.UI.View;

public class Main {

    public static void main(String[] args) {

        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);

        view.setVisible(true);
    }

}
