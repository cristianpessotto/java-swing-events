package dev.pessotto.view.components.containers;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.text.JTextComponent;

import dev.pessotto.view.components.pages.Pages;
import dev.pessotto.view.components.pages.KeyboardEventsPage;
import dev.pessotto.view.components.pages.MouseEventsPage;
import dev.pessotto.view.managers.EventBusManager;
import dev.pessotto.view.managers.GlobalKeyboardEventManager;

public final class PageContainer extends JPanel implements Pages
{
    public PageContainer()
    {
        var layout             = new CardLayout();
        var mouseEventsPage    = new MouseEventsPage();
        var keyboardEventsPage = new KeyboardEventsPage();

        setPreferredSize(new Dimension(800, 500));
        setLayout(layout);

        add(mouseEventsPage, MOUSE_EVENTS_PAGE);
        add(keyboardEventsPage, KEYBOARD_EVENTS_PAGE);

        EventBusManager.subscribe("PageContainer.previous", e -> layout.previous(this));
        EventBusManager.subscribe("PageContainer.next", e -> layout.next(this));
    }

    public boolean togglePage(KeyEvent e)
    {
        if (e.getID() != KeyEvent.KEY_RELEASED)
            return false;

        if (GlobalKeyboardEventManager.getFocusComponent() instanceof JTextComponent)
            return false;

        if (!e.isControlDown())
            return false;

        var code = e.getKeyCode();
        var layout = (CardLayout) getLayout();

        if (code == KeyEvent.VK_LEFT)
        {
            layout.previous(this);
            return true;
        }
        else if (code == KeyEvent.VK_RIGHT)
        {
            layout.previous(this);
            return true;
        }
        return false;
    }

}
