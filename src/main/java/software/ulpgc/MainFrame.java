package software.ulpgc;

import javax.swing.*;
import java.awt.*;
public class MainFrame extends JFrame {

    private ImageDisplay imageDisplay;

    private Command nextComand;
    private Command prevCommand;

    public MainFrame(SwingImageDisplay display, Command nextComand, Command prevCommand){
        setTitle("Image viewer");
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        this.nextComand = nextComand;
        this.prevCommand = prevCommand;

        this.imageDisplay = display;

        add((Component) this.imageDisplay);
        createButtons();

    }

    private void createButtons(){
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel1.setLayout(new GridBagLayout());
        panel2.setLayout(new GridBagLayout());

        JButton prevButton = new JButton("<=");
        prevButton.addActionListener((d) -> prevCommand.execute());

        JButton nextButton = new JButton("=>");
        nextButton.addActionListener((d) -> nextComand.execute());


        panel1.add(prevButton);
        panel2.add(nextButton);

        add(panel1,BorderLayout.WEST);
        add(panel2,BorderLayout.EAST);
    }

}
