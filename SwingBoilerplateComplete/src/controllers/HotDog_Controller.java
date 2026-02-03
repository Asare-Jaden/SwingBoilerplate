package controllers;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import models.HotDog;
import views.HotDog_Panel;

//A class that will track a list of hotDog orders
public class HotDog_Controller {

    ArrayList<HotDog> hotDogOrders;
    private final HotDog_Panel view;
    private HotDog currentOrder;
    private boolean isResetting = false;

    public HotDog_Controller() {
        hotDogOrders = new ArrayList<>();
        view = new HotDog_Panel(this);
    }

    public HotDog_Panel getView() {
        return view;
    }

    public void newOrderListener(JButton btnStart) {
        btnStart.addActionListener(e -> {
            currentOrder = new HotDog();
            view.showOrderForm();
        });
    }

    public void toppingListener(JCheckBox cbx) {
        cbx.addActionListener(e -> {
            if (!isResetting) {
                JCheckBox cb = (JCheckBox) e.getSource();
                String topping = cb.getText();
                if (cb.isSelected()) {
                    currentOrder.addTopping(topping);
                } else {
                    currentOrder.removeTopping(topping);
                }
            }
        });
    }

    public void submitListenter(JButton btn) {
        btn.addActionListener(e -> {
            String orderName = view.getOrderName();
            hotDogOrders.add(currentOrder);
            double cost = currentOrder.getPrice();
            double tax = currentOrder.getTax(cost);
            double total = currentOrder.getPriceWithTax();
            isResetting = true;
            view.addOrder(orderName, currentOrder.toString(), cost, tax, total);
            currentOrder = null;
            view.reset();
            isResetting = false;
        });
    }

    public void cancelListenter(JButton btn) {
        btn.addActionListener(e -> {
            currentOrder = null;
            isResetting =  true;
            view.reset();
            isResetting = false;
        });
    }
}   