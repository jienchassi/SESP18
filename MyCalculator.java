package mycalculator;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author Christopher
 */
public class MyCalculator extends JFrame implements ActionListener  
{
    JPanel[] rows = new JPanel[7]; //row making array
    JButton[] button = new JButton[28]; //button making array
    String[] ButtonString = {"(", ")", "C",
                             "BE", "|x|", "x̅", "ROI", "SALE",
                             "ln", "7", "8", "9", "÷",
                             "log", "4", "5", "6", "x",
                             "x²", "1", "2", "3", "-",
                             "√", ".", "0", "=", "+"
    }; //button naming array
    boolean[] functions = new boolean[4]; //boolean array for equations' functions.
    double[] temporary = {0, 0};    //temporary double for later equations
    JTextArea screen = new JTextArea (1, 20);   //Makes the calculator screen
    Font font = new Font("Calibri", Font.BOLD, 14); //Font of calculator
    
    Dimension displayDimension = new Dimension(300, 40);
    Dimension buttonSize = new Dimension(60, 40);
    
    
    MyCalculator()  //Constructor
    {
        super("MyCalculator");
        setDesign();
        setSize(380, 250);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(7,5);
        setLayout(grid);
        
        for(int i = 0; i < 4; i++)
            functions[i] = false;
        
        FlowLayout flow1 = new FlowLayout(FlowLayout.CENTER);
        FlowLayout flow2 = new FlowLayout(FlowLayout.CENTER, 1, 1);
        
        for(int i = 0; i < 7; i++)
            rows[i] = new JPanel();
        
        for(int i = 1; i < 7; i++)
            rows[i].setLayout(flow2);
        
        for(int i = 0; i < 28; i++)
        {
            button[i] = new JButton();
            button[i].setText(ButtonString[i]);
            button[i].setFont(font);
            button[i].addActionListener(this);
        }
            
        screen.setFont(font);
        screen.setEditable(false);
        screen.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        screen.setPreferredSize(displayDimension);
        
        for(int i = 0; i < 28; i++)
        {
            button[i].setPreferredSize(buttonSize);
        }
        
        rows[0].add(screen);
        add(rows[0]);
        
        for(int i = 0; i < 2; i++)
            rows[1].add(button[i]);
        add(rows[1]);
        
        for(int i = 3; i < 7; i++)
            rows[2].add(button[i]);
        add(rows[2]);
        
        for(int i = 8; i < 12; i++)
            rows[3].add(button[i]);
        add(rows[3]);
        
        for(int i = 13; i < 17; i++)
            rows[4].add(button[i]);
        add(rows[4]);
        
        for(int i = 18; i < 22; i++)
            rows[5].add(button[i]);
        add(rows[5]);
        
        for(int i = 23; i < 27; i++)
            rows[6].add(button[i]);
        add(rows[6]);
        
        setVisible(true);
    }
    
    public final void setDesign()
    {
        try{
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.numbus.NimbusLookAndFeel");
        } catch(Exception e){}
    }
    
    public static void main(String[] args) 
    {
        MyCalculator calc = new MyCalculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
