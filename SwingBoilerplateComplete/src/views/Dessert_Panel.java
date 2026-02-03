package views;

import controllers.Dessert_Controller;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import models.Dessert;

public final class Dessert_Panel extends JPanel {

    private JTextField nameField;
    private JCheckBox[] toppingsCbxs;
    private JPanel formPanel;
    private JPanel newOrderPnl;
    private JPanel ordersPlaced;

    public Dessert_Panel(Dessert_Controller controller) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);

        add(createTitlePanel());
        add(createNewOrderPanel(controller));
        add(createFormPanel(controller));
        add(createOrdersPlacedPanel());
        add(Box.createVerticalGlue());
    }

    private JPanel createTitlePanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTitle = new JLabel("Order a Dessert", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 36));
        panel.add(lblTitle);
        panel.setBorder(new EmptyBorder(30, 15, 0, 10));
        return panel;
    }

    private JPanel createNewOrderPanel(Dessert_Controller controller) {
        newOrderPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnStart = new JButton("New Order");
        controller.newOrderListener(btnStart);
        newOrderPnl.add(btnStart);
        return newOrderPnl;
    }

    private JPanel createFormPanel(Dessert_Controller controller) {
        formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(new EmptyBorder(30, 15, 0, 10));
        formPanel.setVisible(false);

        formPanel.add(createNameRow());
        formPanel.add(new JLabel("Choose toppings:"));
        formPanel.add(createToppingsPanel(controller));
        formPanel.add(createDessertsWithImages(controller));
        formPanel.add(createButtonPanel(controller));
        return formPanel;
    }

    private JPanel createNameRow() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel("Name:"));
        nameField = new JTextField(20);
        panel.add(nameField);
        return panel;
    }

    private JPanel createToppingsPanel(Dessert_Controller controller) {
        JPanel panel = new JPanel(new GridLayout(3, 3, 10, 10));
        toppingsCbxs = new JCheckBox[Dessert.AVAILABLE_TOPPINGS.length];

        for (int i = 0; i < toppingsCbxs.length; i++) {
            toppingsCbxs[i] = new JCheckBox(Dessert.AVAILABLE_TOPPINGS[i]);
            controller.toppingListener(toppingsCbxs[i]);
            panel.add(toppingsCbxs[i]);
        }
        return panel;
    }

    // ------------------- Desserts with Images -------------------
    private JPanel createDessertsWithImages(Dessert_Controller controller) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Cake
        /*
         * Image source: https://www.flaticon.com/
         */
        ImageIcon cakeIcon = new ImageIcon("images/cake.png");
        JLabel cakeImage = new JLabel(cakeIcon);
        panel.add(cakeImage);
        JRadioButton cake = new JRadioButton("Cake");
        controller.dessertListener(cake);
        panel.add(cake);

        // Ice Cream
        /*
         * Image source: https://www.flaticon.com/
         */
        ImageIcon iceIcon = new ImageIcon("images/icecream.png");
        JLabel iceImage = new JLabel(iceIcon);
        panel.add(iceImage);
        JRadioButton iceCream = new JRadioButton("Ice Cream");
        controller.dessertListener(iceCream);
        panel.add(iceCream);

        // Pie
        /*
         * Image source: https://www.flaticon.com/
         */
        ImageIcon pieIcon = new ImageIcon("images/pie.png");
        JLabel pieImage = new JLabel(pieIcon);
        panel.add(pieImage);
        JRadioButton pie = new JRadioButton("Pie");
        controller.dessertListener(pie);
        panel.add(pie);

        return panel;
    }
    // ------------------------------------------------------------

    private JPanel createButtonPanel(Dessert_Controller controller) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnSubmit = new JButton("Submit");
        JButton btnCancel = new JButton("Cancel");
        controller.submitListenter(btnSubmit);
        controller.cancelListenter(btnCancel);
        panel.add(btnSubmit);
        panel.add(btnCancel);
        return panel;
    }

    private JScrollPane createOrdersPlacedPanel() {
        ordersPlaced = new JPanel();
        ordersPlaced.setLayout(new BoxLayout(ordersPlaced, BoxLayout.Y_AXIS));
        ordersPlaced.add(new JLabel("Orders Placed"));
        ordersPlaced.add(Box.createVerticalGlue());
        return new JScrollPane(ordersPlaced);
    }

    public String getOrderName() {
        return nameField.getText();
    }

    public void showOrderForm() {
        newOrderPnl.setVisible(false);
        formPanel.setVisible(true);
    }

    public void reset() {
        newOrderPnl.setVisible(true);
        formPanel.setVisible(false);
        nameField.setText("");
        for (JCheckBox box : toppingsCbxs) {
            box.setSelected(false);
        }
    }

    public void addOrder(String name, String desc, double cost, double tax, double total) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Name: " + name));
        panel.add(new JLabel("Description: " + desc));
        panel.add(new JLabel(String.format("Price: $%.2f", cost)));
        panel.add(new JLabel(String.format("Tax: $%.2f", tax)));
        panel.add(new JLabel(String.format("Total: $%.2f", total)));
        ordersPlaced.add(panel);
        ordersPlaced.revalidate();
        ordersPlaced.repaint();
    }
}
