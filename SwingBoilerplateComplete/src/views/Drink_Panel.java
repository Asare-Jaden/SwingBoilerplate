package views;

import controllers.Drink_Controller;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import models.Drink;

public final class Drink_Panel extends JPanel {

    private JComboBox<String> drinkBox;
    private JComboBox<String> sizeBox;
    private JPanel formPanel;
    private JPanel newOrderPnl;
    private JPanel ordersPlaced;

    public Drink_Panel(Drink_Controller controller) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);

        add(createTitlePanel());
        add(createNewOrderPanel(controller));
        add(createFormPanel(controller));
        add(createOrdersPlacedPanel());
    }

    private JPanel createTitlePanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Order a Drink");
        label.setFont(new Font("Arial", Font.BOLD, 36));
        panel.add(label);
        return panel;
    }

    private JPanel createNewOrderPanel(Drink_Controller controller) {
        newOrderPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btn = new JButton("New Order");
        controller.newOrderListener(btn);
        newOrderPnl.add(btn);
        return newOrderPnl;
    }

    private JPanel createFormPanel(Drink_Controller controller) {
        formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        formPanel.setVisible(false);

        drinkBox = new JComboBox<>(Drink.AVAILABLE_DRINKS);
        sizeBox = new JComboBox<>(Drink.SIZES);

        controller.drinkSelectListener(drinkBox);
        controller.sizeSelectListener(sizeBox);

        formPanel.add(new JLabel("Drink:"));
        formPanel.add(drinkBox);
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(new JLabel("Size:"));
        formPanel.add(sizeBox);

        JButton submit = new JButton("Submit");
        JButton cancel = new JButton("Cancel");

        controller.submitListener(submit);
        controller.cancelListener(cancel);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnPanel.add(submit);
        btnPanel.add(cancel);

        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(btnPanel);

        return formPanel;
    }

    private JScrollPane createOrdersPlacedPanel() {
        ordersPlaced = new JPanel();
        ordersPlaced.setLayout(new BoxLayout(ordersPlaced, BoxLayout.Y_AXIS));
        ordersPlaced.add(new JLabel("Orders Placed"));
        return new JScrollPane(ordersPlaced);
    }

    public void showOrderForm() {
        newOrderPnl.setVisible(false);
        formPanel.setVisible(true);
    }

    public void reset() {
        newOrderPnl.setVisible(true);
        formPanel.setVisible(false);
        drinkBox.setSelectedIndex(0);
        sizeBox.setSelectedIndex(0);
    }

    public void addOrder(String desc, double cost, double tax, double total) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Drink: " + desc));
        panel.add(new JLabel(String.format("Price: $%.2f", cost)));
        panel.add(new JLabel(String.format("Tax: $%.2f", tax)));
        panel.add(new JLabel(String.format("Total: $%.2f", total)));
        ordersPlaced.add(panel);
        ordersPlaced.revalidate();
        ordersPlaced.repaint();
    }
}
