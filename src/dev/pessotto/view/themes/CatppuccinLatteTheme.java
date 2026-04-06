package dev.pessotto.view.themes;

import com.formdev.flatlaf.FlatLightLaf;

public final class CatppuccinLatteTheme extends FlatLightLaf
{
    public static boolean setup()
    {
        return setup(new CatppuccinMochaTheme());
    }

    @Override
    public String getName()
    {
        return "CatppuccinLatteTheme";
    }
}
