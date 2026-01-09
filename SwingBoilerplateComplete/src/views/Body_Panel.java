package views;

import controllers.Hamburger_Controller;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Body_Panel extends JPanel{
    CardLayout layout;
    
    public Body_Panel(){
        super();
        layout = new CardLayout();
        setLayout(layout);
        
        //"hot dogs", "hamburgers", "desserts", "drinks"
        //Create a controller for each, then get the view from it that it will control
        //The view is a type of JPanel
        
        JPanel hotDogPanel = new JPanel();
        hotDogPanel.setBackground(Color.YELLOW);
        JLabel lblHotDog = new JLabel("Hot Dog Panel is showing");
        hotDogPanel.add(lblHotDog);
        
        Hamburger_Controller hamburgerController = new Hamburger_Controller();
        Hamburger_Panel hamburgerPanel = hamburgerController.getView();
                
        JPanel dessertPanel = new JPanel();
        dessertPanel.setBackground(Color.decode("#3D1C02"));
        JLabel lblDessert = new JLabel("Dessert Panel is showing");
        dessertPanel.add(lblDessert);
        
        JPanel drinksPanel = new JPanel();
        drinksPanel.setBackground(Color.BLUE);
        JLabel lblDrinks = new JLabel("Drinks Panel is showing");
        drinksPanel.add(lblDrinks);
        
        add(hotDogPanel, "hot dogs");
        add(hamburgerPanel, "hamburgers");
        add(dessertPanel, "desserts");
        add(drinksPanel, "drinks");
    }
    
    public void setPanel(String panelName){
        layout.show(this, panelName);
    }
}
