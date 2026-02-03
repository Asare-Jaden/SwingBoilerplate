package controllers;

import javax.swing.JButton;
import javax.swing.JComboBox;
import models.Drink;
import views.Drink_Panel;
import java.util.ArrayList;

public class Drink_Controller {

    ArrayList<Drink> drinkOrders;
    private final Drink_Panel view;
    private Drink currentOrder;
    private boolean isResetting = false;

    public Drink_Controller() {
        drinkOrders = new ArrayList<>();
        view = new Drink_Panel(this);
    }

    public Drink_Panel getView() {
        return view;
    }

    public void newOrderListener(JButton btn) {
        btn.addActionListener(e -> {
            currentOrder = new Drink();
            view.showOrderForm();
        });
    }

    public void drinkSelectListener(JComboBox<String> box) {
        box.addActionListener(e -> {
            if (!isResetting && currentOrder != null) {
                currentOrder.setDrinkType((String) box.getSelectedItem());
            }
        });
    }

    public void sizeSelectListener(JComboBox<String> box) {
        box.addActionListener(e -> {
            if (!isResetting && currentOrder != null) {
                currentOrder.setSize((String) box.getSelectedItem());
            }
        });
    }

    public void submitListener(JButton btn) {
        btn.addActionListener(e -> {
            drinkOrders.add(currentOrder);

            double cost = currentOrder.getPrice();
            double tax = currentOrder.getTax(cost);
            double total = currentOrder.getPriceWithTax();

            isResetting = true;
            view.addOrder(currentOrder.toString(), cost, tax, total);
            view.reset();
            currentOrder = null;
            isResetting = false;
        });
    }

    public void cancelListener(JButton btn) {
        btn.addActionListener(e -> {
            currentOrder = null;
            isResetting = true;
            view.reset();
            isResetting = false;
        });
    }
}
