package dev.pessotto.view.components;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import dev.pessotto.view.managers.GlobalKeyboardEventManager;
import dev.pessotto.view.managers.UIStyleManager;

public final class Window extends JFrame
{
    public Window()
    {
        setTitle("JavaSwingEvents");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("resources/images/logo.png").getImage());

        getContentPane().addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e) { requestFocus(); }
        });

        addWindowListener(new WindowAdapter()
        {
            public void windowActivated(WindowEvent e) { requestFocusInWindow(); }
        });
    }

    public void run()
    {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public boolean toggleTheme(KeyEvent e)
    {
        if (e.getID() != KeyEvent.KEY_RELEASED)
            return false;

        if (e.getKeyCode() != KeyEvent.VK_SPACE || !e.isControlDown())
            return false;

        if (!equals(GlobalKeyboardEventManager.getFocusWindow()))
            return false;

        UIStyleManager.toggleStyle(true);

        return true;
    }
}
