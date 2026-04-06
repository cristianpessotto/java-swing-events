package dev.pessotto.view;

import java.awt.BorderLayout;

import dev.pessotto.view.components.Window;
import dev.pessotto.view.components.containers.PageContainer;
import dev.pessotto.view.components.containers.NavContainer;
import dev.pessotto.view.managers.GlobalKeyboardEventManager;
import dev.pessotto.view.managers.UIStyleManager;

public final class SwingApplication
{
    public static void start()
    {
        UIStyleManager.applyDefaultStyle();

        var window        = new Window();
        var pageContainer = new PageContainer();
        var navContainer  = new NavContainer();

        window.add(pageContainer, BorderLayout.CENTER);
        window.add(navContainer, BorderLayout.SOUTH);

        GlobalKeyboardEventManager.addKeyEvent(pageContainer::togglePage);
        GlobalKeyboardEventManager.addKeyEvent(window::toggleTheme);

        window.run();
    }
}
