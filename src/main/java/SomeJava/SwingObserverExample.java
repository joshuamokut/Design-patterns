package SomeJava;

import javax.swing.*;

public class SwingObserverExample {
    private JFrame jFrame;

    public static void main(String[] args) {
        SwingObserverExample example = new SwingObserverExample();
        example.go();
    }

    public void go() {
        jFrame = new JFrame();

        JButton jButton = new JButton("Should I do it?");
        jButton.addActionListener(event -> System.out.println("Don't do it you might regret it"));
        jButton.addActionListener(event -> System.out.println("Do it, I know you want to , go on"));

        jFrame.add(jButton);
        jFrame.show();
    }

}
