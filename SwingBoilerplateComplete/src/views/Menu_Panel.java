
package views;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Menu_Panel extends JPanel{    
    JButton[] buttons;
    
    public Menu_Panel(String[] menu){
        super();        
        setBackground(Color.BLUE);
        setLayout(new GridLayout(menu.length, 1, 10, 10));
        buttons = new JButton[menu.length];
        
        int i = 0;
        for(String item: menu){
            JButton btn = new JButton(item);
            add(btn);
            buttons[i] = btn;
            i++;
        }
    }
    
    public JButton[] getButtons(){
        return buttons;
    }
}
