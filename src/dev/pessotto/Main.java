package dev.pessotto;

import javax.swing.SwingUtilities;

import dev.pessotto.view.SwingApplication;

public final class Main
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(SwingApplication::start);
    }
}
