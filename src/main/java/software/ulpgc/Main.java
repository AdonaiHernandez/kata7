package software.ulpgc;

import java.io.File;

public class Main {

    public static final String root = "C:\\Users\\Adonai\\Pictures\\Screenshots";

    public static void main(String[] args){


        SwingImageDisplay display = new SwingImageDisplay();
        Image image = new ImageLoaderFromFile(new File(root)).load();
        MainFrame mainFrame = new MainFrame(
                display,
                new NextImageCommand(display),
                new PreviousImageCommand(display)
        );

        display.show(image);
        mainFrame.setVisible(true);

    }

}
