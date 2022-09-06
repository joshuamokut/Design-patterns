package SomeJava.TemplatePattern;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(300, 300);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        String msg = "I am Lord Mokutle, My will be done";
        g.drawString(msg, 50, 50);
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame("Head first design patterns");
    }
}
