package dev.pessotto.view.themes;

import com.formdev.flatlaf.FlatDarkLaf;

public final class CatppuccinMochaTheme extends FlatDarkLaf
{
    public static boolean setup()
    {
        return setup(new CatppuccinMochaTheme());
    }

    @Override
    public String getName()
    {
        return "CatppuccinMochaTheme";
    }
}
