package views;

import controllers.Dessert_Controller;
import controllers.Drink_Controller;
import controllers.Hamburger_Controller;
import controllers.HotDog_Controller;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Body_Panel extends JPanel {
    CardLayout layout;

    public Body_Panel() {
        super();
        layout = new CardLayout();
        setLayout(layout);

        // HotDog Panel
        HotDog_Controller hotDogController = new HotDog_Controller();
        HotDog_Panel hotDogPanel = hotDogController.getView();

        // Hamburger Panel
        Hamburger_Controller hamburgerController = new Hamburger_Controller();
        Hamburger_Panel hamburgerPanel = hamburgerController.getView();

        // Dessert Panel
        Dessert_Controller dessertController = new Dessert_Controller();
        Dessert_Panel dessertPanel = dessertController.getView();

        // Drinks Panel (placeholder)
        Drink_Controller drinkController = new Drink_Controller();
        Drink_Panel drinkPanel = drinkController.getView();




        add(hotDogPanel, "hot dogs");
        add(hamburgerPanel, "hamburgers");
        add(dessertPanel, "desserts");
        add(drinkPanel, "drinks");
    }

    public void setPanel(String panelName) {
        layout.show(this, panelName);
    }
}
