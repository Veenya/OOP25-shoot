package it.unibo.shoot.view;

import it.unibo.shoot.model.Game;
import java.awt.Dimension;
//import java.awt.Frame;

import javax.swing.JFrame;

// TODO: javadoc

public class Window {
    public Window(int width, int height, String title, Game game) {
        // Creates new JFrame
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.add(game);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
