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
    String[] ButtonString = {"(", "+/-", "C",
                             "BE", "|x|", "x̅", "ROI", "SALE",
                             "log", "7", "8", "9", "÷",
                             "ln", "4", "5", "6", "x",
                             "x²", "1", "2", "3", "-",
                             "√", ".", "0", "=", "+"
    }; //button naming array
    boolean[] functions = new boolean[4]; //boolean array for equations' functions.
    double[] temporary = {0, 0};    //temporary double for later equations
    JTextArea screen = new JTextArea (1, 20);   //Makes the calculator screen
    Font font = new Font("Calibri", Font.BOLD, 14); //Font of calculator
    
    Dimension displayDimension = new Dimension(300, 40); //Creates the dimension size for the display
    Dimension buttonSize = new Dimension(60, 40); //Creates the dimension size for the buttons
    
    
    MyCalculator()  //Constructor
    {
        super("MyCalculator");
        setDesign(); //Uses an integrated design for the GUI
        setSize(380, 250); //Sets the size of the entire calculator to be 380x250
        setResizable(false); //Makes the calculator unresizable.
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Allows exiting of the Calculator
        GridLayout grid = new GridLayout(7,5); //Creates a grid for the buttons to be on (7 rows, 5 buttons per row)
        setLayout(grid); 
        
        for(int i = 0; i < 4; i++) //An array of functions used.
            functions[i] = false;
        
        FlowLayout flow1 = new FlowLayout(FlowLayout.CENTER);
        FlowLayout flow2 = new FlowLayout(FlowLayout.CENTER, 1, 1);
        
        for(int i = 0; i < 7; i++) 
            rows[i] = new JPanel();
        
        for(int i = 1; i < 7; i++) //Aligns the buttons to the center
            rows[i].setLayout(flow2);
        
        for(int i = 0; i < 28; i++) //Sets button font, texts bassed on ButtonString array, and adds actions
        {
            button[i] = new JButton();
            button[i].setText(ButtonString[i]);
            button[i].setFont(font);
            button[i].addActionListener(this);
        }
            
        screen.setFont(font); //Sets the font of the display
        screen.setEditable(false); //Disables editing the display
        screen.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); //Orients the display
        screen.setPreferredSize(displayDimension); //Sets the dimension size
        
        for(int i = 0; i < 28; i++) //Sets button size
        {
            button[i].setPreferredSize(buttonSize);
        }
        
        rows[0].add(screen);  //sets the first row to be the display 
        add(rows[0]);
        
        for(int i = 0; i < 3; i++) //sets rows 2-7 to be the buttons that were specified in the array.
            rows[1].add(button[i]);
        add(rows[1]);
        
        for(int i = 3; i < 8; i++)
            rows[2].add(button[i]);
        add(rows[2]);
        
        for(int i = 8; i < 13; i++)
            rows[3].add(button[i]);
        add(rows[3]);
        
        for(int i = 13; i < 18; i++)
            rows[4].add(button[i]);
        add(rows[4]);
        
        for(int i = 18; i < 23; i++)
            rows[5].add(button[i]);
        add(rows[5]);
        
        for(int i = 23; i < 28; i++)
            rows[6].add(button[i]);
        add(rows[6]);
        
        setVisible(true); //makes the executable visible
    }
    
    public void actionPerformed(ActionEvent e)//Sets buttons to do their actions
    {
        if(e.getSource() == button[9]) //Sets 7 button to display 7
            screen.append("7");
        if(e.getSource() == button[10])//Sets 8 button to display 8
            screen.append("8");
        if(e.getSource() == button[11])//Sets 9 button to display 9
            screen.append("9");
        if(e.getSource() == button[14])//Sets 4 button to display 4
            screen.append("4");
        if(e.getSource() == button[15])//Sets 5 button to display 5
            screen.append("5");
        if(e.getSource() == button[16])//Sets 6 button to display 6
            screen.append("6");
        if(e.getSource() == button[19])//Sets 1 button to display 1
            screen.append("1");
        if(e.getSource() == button[20])//Sets 2 button to display 2
            screen.append("2");
        if(e.getSource() == button[21])//Sets 3 button to display 3
            screen.append("3");
        if(e.getSource() == button[24])//Sets . button to display .
            screen.append(".");
        if(e.getSource() == button[25])//Sets 0 button to display 0
            screen.append("0");
        if(e.getSource() == button[2]) //Sets the Clear button to clear
            clear();
        if(e.getSource() == button[18])// Sets the x^2 button to square the number
            Squared();
        if(e.getSource() == button[23])//Sets the √ button to square root the number
            getSquareRoot();
        if(e.getSource() == button[8])//Sets the log button to create a logarithm of the number 
            Logarithm();
        if(e.getSource() == button[13])//Sets the ln button to create a natural logarithm of the number
            NaturalLogarithm();
        if(e.getSource() == button[4])//Sets the |x| button to create an absolute value of the number
            AbsoluteValue();
        if(e.getSource() == button[26])//Displays the result of an equation given
            getResult();
        if(e.getSource() == button[1])//Swaps the number from negative to positive or positive to negative
            posAndNeg();
        if(e.getSource() == button[27])//Sets the + button to add 2 values
            {
            temporary[0] = Double.parseDouble(screen.getText());
            functions[0] = true;
            screen.setText("");
            }
        if(e.getSource() == button[22])//Sets the - button to subtract 2 values
            {
            temporary[0] = Double.parseDouble(screen.getText());
            functions[1] = true;
            screen.setText("");
            }
        if(e.getSource() == button[17])//Sets the x button to multiply 2 values
            {
            temporary[0] = Double.parseDouble(screen.getText());
            functions[2] = true;
            screen.setText("");
            }
        if(e.getSource() == button[12])//Sets the ÷ button to divide 2 values
            {
            temporary[0] = Double.parseDouble(screen.getText());
            functions[3] = true;
            screen.setText("");
            }
        
    }
    
    public final void setDesign()//Designs the calculator
    {
        try{
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.numbus.NimbusLookAndFeel");
        } catch(Exception e){}
    }
    
    public void clear() //clear function
    {
        screen.setText("");
        for(int i = 0; i < 4; i++)
            functions[i] = false;
        for(int i = 0; i < 2; i++)
            temporary[i] = 0;
    }
    
    public void getResult()//Gets the result of two functions
    {
        double result = 0;
        temporary[1] = Double.parseDouble(screen.getText());
        String temp0 = Double.toString(temporary[0]);
        String temp1 = Double.toString(temporary[1]);
        if(temp0.contains("-"))
        {
            String[] temp00 = temp0.split("-", 2);
            temporary[0] = (Double.parseDouble(temp00[1])*-1);
        }
        if(temp1.contains("-"))
        {
            String[] temp11 = temp1.split("-", 2);
            temporary[1] = (Double.parseDouble(temp11[1])*-1);
        }
        if(functions[2] == true) 
            result = temporary[0] * temporary[1]; //functions[2] is multiplication
        else if(functions[3] == true) 
            result = temporary[0] / temporary[1]; //functions[3] is division
        else if(functions[0] == true) 
            result = temporary[0] + temporary[1]; //functions[0] is addition
        else if(functions[1] == true)
            result = temporary[0] - temporary[1]; //functions[1] is subtraction
        screen.setText(Double.toString(result)); //display now has result
        for(int i = 0; i < 4; i++)
            functions[i] = false; //set all the functions back to false
    }
    
    public void posAndNeg() //Changes positive to negative by multiplying by -1 and does the opposite as well
    {
        double value = Double.parseDouble(screen.getText());
        if(value != 0)
        {
            value = value * (-1);
            screen.setText(Double.toString(value));
        }
    }
    
    public void getSquareRoot() //Square root function
    {
        double value = Math.sqrt(Double.parseDouble(screen.getText()));
        screen.setText(Double.toString(value));
    }
    
    public void Squared() //Squared function
    {
        double value = Math.pow(Double.parseDouble(screen.getText()), 2.0);
        screen.setText(Double.toString(value));
    }
    
    public void Logarithm()//Logarithm function
    {
        double value = Math.log10(Double.parseDouble(screen.getText()));
        screen.setText(Double.toString(value));
    }
    
    public void NaturalLogarithm()//Natural logarithm function
    {
        double value = Math.log1p(Double.parseDouble(screen.getText()));
        screen.setText(Double.toString(value));
    }
    
    public void AbsoluteValue()//Absolute value function
    {
        double value = Math.abs(Double.parseDouble(screen.getText()));
        screen.setText(Double.toString(value));
    }
    
    public static void main(String[] args) 
    {
        MyCalculator calc = new MyCalculator(); //runs Calculator class
    }//end main
}//end MyCalculator()
