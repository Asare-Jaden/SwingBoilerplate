package controllers;

import javax.swing.*;
import models.Dessert;
import views.Dessert_Panel;

public class Dessert_Controller {

    private Dessert_Panel view;
    private String selectedDessert;

    public Dessert_Controller() {
        view = new Dessert_Panel(this);
    }

    public Dessert_Panel getView() {
        return view;
    }

    public void dessertListener(JRadioButton rb) {
        rb.addActionListener(e -> selectedDessert = rb.getText());
    }

    public void toppingListener(JCheckBox cbx) {
        cbx.addActionListener(e -> {
            // You can add logic here if needed later
        });
    }

    public void submitListenter(JButton btn) {
        btn.addActionListener(e -> {
            if (selectedDessert == null) {
                JOptionPane.showMessageDialog(view, "Select a dessert first");
                return;
            }
            Dessert dessert = new Dessert(view.getOrderName(), selectedDessert);

            JOptionPane.showMessageDialog(view,
                    "Dessert: " + dessert.getDescription() +
                    "\nPrice: $" + dessert.getCost());
            view.addOrder(dessert.getName(), dessert.getDescription(),
                    dessert.getCost(), 0, dessert.getCost());
            view.reset();
        });
    }

    public void cancelListenter(JButton btn) {
        btn.addActionListener(e -> {
            selectedDessert = null;
            view.reset();
        });
    }

    public String getSelectedDessert() {
        return selectedDessert;
    }

    public void newOrderListener(JButton btnStart) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'newOrderListener'");
    }
}
