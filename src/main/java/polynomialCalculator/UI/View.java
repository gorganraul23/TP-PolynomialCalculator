package polynomialCalculator.UI;

import polynomialCalculator.Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame{

    private Model model;

    private final JLabel l = new JLabel("Polynomial Calculator");
    private final JLabel l_first_polynomial = new JLabel("First Polynomial: ");
    private final JLabel l_second_polynomial = new JLabel("Second Polynomial: ");
    private final JLabel l_result = new JLabel("Result: ");
    private JTextField tf_first_pol = new JTextField(15);
    private JTextField tf_second_pol = new JTextField(15);
    private JTextField tf_result = new JTextField(15);
    private JButton btn_add = new JButton("Add");
    private JButton btn_sub = new JButton("Subtract");
    private JButton btn_mul = new JButton("Multiply");
    private JButton btn_div = new JButton("Divide");
    private JButton btn_deriv = new JButton("Derivative");
    private JButton btn_integr = new JButton("Integrate");
    private JButton btn_reset = new JButton("Reset");
    private JButton btn_exit = new JButton("Exit");
    private JButton btn_help = new JButton("Help");
    private JTextArea t_help = new JTextArea();

    public View(Model model) {
        this.model = model;
        model.setValue(Model.getResetValue());
        tf_result.setEditable(false);

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(10, 2));
        p1.add(l_first_polynomial);
        l_first_polynomial.setHorizontalAlignment(SwingConstants.CENTER);
        p1.add(tf_first_pol);
        p1.add(l_second_polynomial);
        l_second_polynomial.setHorizontalAlignment(SwingConstants.CENTER);
        p1.add(tf_second_pol);
        p1.add(l_result);
        l_result.setHorizontalAlignment(SwingConstants.CENTER);
        p1.add(tf_result);
        p1.add(Box.createRigidArea(new Dimension(0, 0)));
        p1.add(Box.createRigidArea(new Dimension(0, 0)));
        p1.add(btn_add);
        p1.add(btn_sub);
        p1.add(btn_mul);
        p1.add(btn_div);
        p1.add(btn_deriv);
        p1.add(btn_integr);
        p1.add(btn_reset);
        p1.add(btn_exit);
        p1.add(Box.createRigidArea(new Dimension(0, 0)));
        p1.add(Box.createRigidArea(new Dimension(0, 0)));
        p1.add(btn_help);
        btn_help.setBackground(Color.LIGHT_GRAY);

        JPanel cont1 = new JPanel();
        cont1.setLayout(new BoxLayout(cont1, BoxLayout.X_AXIS));
        cont1.add(Box.createRigidArea(new Dimension(15, 0)));
        cont1.add(p1);
        cont1.add(Box.createRigidArea(new Dimension(15, 0)));

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add(Box.createRigidArea(new Dimension(0, 15)));
        content.add(l);
        l.setAlignmentX(CENTER_ALIGNMENT);
        content.add(Box.createRigidArea(new Dimension(0, 15)));
        content.add(cont1);
        content.add(Box.createRigidArea(new Dimension(0, 15)));
        l.setFont(new Font("Sheriff", Font.BOLD, 19));

        this.setContentPane(content);
        this.pack();
        this.setTitle("Polynomial Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void addSumListener(ActionListener al) {
        btn_add.addActionListener(al);
    }

    void addSubListener(ActionListener al) {
        btn_sub.addActionListener(al);
    }

    void addMulListener(ActionListener al) {
        btn_mul.addActionListener(al);
    }

    void addDivListener(ActionListener al) {
        btn_div.addActionListener(al);
    }

    void addDerivListener(ActionListener al) {
        btn_deriv.addActionListener(al);
    }

    void addIntegrListener(ActionListener al) {
        btn_integr.addActionListener(al);
    }

    void addResetListener(ActionListener al) {
        btn_reset.addActionListener(al);
    }

    void addExitListener(ActionListener al) {
        btn_exit.addActionListener(al);
    }

    void addHelpListener(ActionListener al) {
        btn_help.addActionListener(al);
    }

    public String getFirstInput() {
        return tf_first_pol.getText();
    }

    public String getSecondInput() {
        return tf_second_pol.getText();
    }

    void setTotal(String newTotal) {        //seteaza textfield-ul rezultat
        if (newTotal.equals(""))
            tf_result.setText("0");         //daca e string gol, se afiseaza 0
        else
            tf_result.setText(newTotal);
    }

    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    void reset() {
        tf_result.setText(Model.getResetValue());       //reset pentru view, sterge pol1, pol2 si pune 0 la result
        tf_first_pol.setText("");
        tf_second_pol.setText("");
    }

    public void createHelpPanel() {
        t_help.setText("\n\tWelcome!\n\n This is a polynomial calculator.\n You can perform operations such as:\n" +
                " - sum\n - subtraction\n - multiplication\n - division\n - derivative\n - integrate\n" +
                "\n Please insert the monomials in a polynomial in the next format: cx^g. \n" +
                " -> c = coefficient\n -> g = grade" + "\n If the grade is 1, omit it and if grade is 0, omit 'x' too."
                + "\n An example: 2x^3-x^2+5x+1\n" +
                "\n Please use the first text field for derivative and integrate." +
                "\n\n\tThank you!\n");
        JOptionPane.showMessageDialog(this, t_help, "Help", JOptionPane.PLAIN_MESSAGE);
    }

}