package polynomialCalculator.UI;

import polynomialCalculator.Model.Operations;
import polynomialCalculator.Model.Model;
import polynomialCalculator.Model.Polynomial.Polinom;
import polynomialCalculator.exceptions.IllegalDivisionException;
import polynomialCalculator.exceptions.NoInputException;
import polynomialCalculator.exceptions.WrongInputException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        view.addSumListener(new SumListener());
        view.addSubListener(new SubListener());
        view.addMulListener(new MulListener());
        view.addDivListener(new DivListener());
        view.addDerivListener(new DerivListener());
        view.addIntegrListener(new IntegrListener());
        view.addResetListener(new ResetListener());
        view.addExitListener(new ExitListener());
        view.addHelpListener(new HelpListener());
    }

    ////////////////////////////////////////////////////////////////////////////
    class SumListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Polinom p1, p2;

                p1 = Operations.getParsedInput(view.getFirstInput());
                p2 = Operations.getParsedInput((view.getSecondInput()));

                Polinom res = Operations.sum(p1, p2);
                view.setTotal(res.toString(false));
            } catch (NoInputException ne) {
                view.showError(ne.getMessage());
            } catch (WrongInputException we) {
                view.showError(we.getMessage());
            } catch (Exception ex) {
                view.showError("Something wrong! Please retry.");
            }
        }
    }

    class SubListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Polinom p1, p2;

                p1 = Operations.getParsedInput(view.getFirstInput());
                p2 = Operations.getParsedInput((view.getSecondInput()));

                Polinom res = Operations.subtract(p1, p2);
                view.setTotal(res.toString(false));
            } catch (NoInputException ne) {
                view.showError(ne.getMessage());
            } catch (WrongInputException we) {
                view.showError(we.getMessage());
            } catch (Exception ex) {
                view.showError("Something wrong! Please retry.");
            }
        }
    }

    class MulListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Polinom p1, p2;

                p1 = Operations.getParsedInput(view.getFirstInput());
                p2 = Operations.getParsedInput((view.getSecondInput()));

                Polinom res = Operations.multiplication(p1, p2);
                view.setTotal(res.toString(false));
            } catch (NoInputException ne) {
                view.showError(ne.getMessage());
            } catch (WrongInputException we) {
                view.showError(we.getMessage());
            } catch (Exception ex) {
                view.showError("Something wrong! Please retry.");
            }
        }
    }

    class DivListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Polinom p1, p2;
                p1 = Operations.getParsedInput(view.getFirstInput());
                p2 = Operations.getParsedInput(view.getSecondInput());

                String res = Operations.division(p1, p2);
                view.setTotal(res);
            } catch (NoInputException ne) {
                view.showError(ne.getMessage());
            } catch (WrongInputException we) {
                view.showError(we.getMessage());
            } catch (IllegalDivisionException de) {
                view.showError(de.getMessage());
            } catch (Exception ex) {
                view.showError("Something wrong! Please retry.");
            }
        }
    }

    class DerivListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Polinom p;
                p = Operations.getParsedInput(view.getFirstInput());

                Polinom res = Operations.derivative(p);
                view.setTotal(res.toString(false));
            } catch (NoInputException ne) {
                view.showError(ne.getMessage());
            } catch (WrongInputException we) {
                view.showError(we.getMessage());
            } catch (Exception ex) {
                view.showError("Something wrong! Please retry.");
            }
        }
    }

    class IntegrListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Polinom p;
                p = Operations.getParsedInput(view.getFirstInput());

                Polinom res = Operations.integrate(p);
                view.setTotal(res.toString(true));
            } catch (NoInputException ne) {
                view.showError(ne.getMessage());
            } catch (WrongInputException we) {
                view.showError(we.getMessage());
            } catch (Exception ex) {
                view.showError("Something wrong! Please retry.");
            }
        }
    }

    class ResetListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.reset();
            view.reset();
        }
    }

    class ExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    class HelpListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.createHelpPanel();
        }
    }

}
