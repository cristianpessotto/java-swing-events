package dev.pessotto.view.managers;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;

import dev.pessotto.view.themes.CatppuccinLatteTheme;
import dev.pessotto.view.themes.CatppuccinMochaTheme;

/**
 * <h2>{@code UIStyleManager}🌈</h2>
 *
 * {@link UIStyleManager} é uma classe utilitária que aplica estilos no cliente com base no tema
 * selecionado. Os temas são armazenados no pacote {@code dev.pessotto.view.themes}
 *
 * @author Cristian Pessotto
 *
 * @see {@link CatppuccinLatteTheme}
 * @see {@link CatppuccinMochaTheme}
 */
public final class UIStyleManager
{
    /**
     * Bloco estático que regista uma única vez a pasta com os arquivos de configuração de temas
     * Catppuccin no formato .properties. Além de carregar na memória do computador a fonte Tektur.
     */
    static
    {
        FlatLaf.registerCustomDefaultsSource("resources.themes");
        try
        {
            var resource    = UIStyleManager.class.getResourceAsStream("/resources/fonts/TekturRegular.ttf");
            var font        = Font.createFont(Font.TRUETYPE_FONT, resource);
            var environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            environment.registerFont(font);
        }
        catch (IOException | FontFormatException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Atributo auxiliar que ajuda na troca entre tema claro e escuro. O valor padrão é {@code true}
     * indicando que a interface é inicializada no tema claro.
     */
    private static boolean isLight = true;

    /**
     * Carrega uma instância do tema Latte {@link CatppuccinLatteTheme}.
     */
    private static final LookAndFeel LIGHT = new CatppuccinLatteTheme();

    /**
     * Carrega uma instância do tema Mocha {@link CatppuccinMochaTheme}.
     */
    private static final LookAndFeel DARK = new CatppuccinMochaTheme();

    /**
     * Classe utilitária não precisa de instância (evite usar singleton).
     */
    private UIStyleManager(){}

    /**
     * Aplica o estilo padrão da classe {@link CatppuccinLatteTheme}.
     */
    public static void applyDefaultStyle()
    {
        applyStyle(LIGHT, false);
    }

    /**
     * Aplica um estilo {@code LookAndFeel} a atualiza a UI usando a dependência do
     * {@link FlatLaf#updateUI()}.
     *
     * @param lookAndFeel indica o tema que será aplicado.
     * @param showPane se deve ou não exibir uma mensagem informando que o tema foi aplicado.
     */
    public static void applyStyle(LookAndFeel lookAndFeel, boolean showPane)
    {
        SwingUtilities.invokeLater(() -> {
            try
            {
                UIManager.setLookAndFeel(lookAndFeel);
                FlatLaf.updateUI();
                if (showPane)
                    JOptionPane.showMessageDialog
                    (
                        null,
                        "<html><b>%s</b> aplicado com sucesso!</html>".formatted(lookAndFeel.getName()),
                        "Tema aplicado",
                        JOptionPane.PLAIN_MESSAGE
                    );
            }
            catch (Exception e)
            {
                applyStyle(LIGHT, false);
                JOptionPane.showMessageDialog
                (
                    null,
                    "Tetamos aplicar o tema (" + lookAndFeel + "), mas não conseguimos. Motivo: \n" + e,
                    "Erro ao aplicar o tema >:(",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }

    /**
     * Método que fica alternando entre os temas Mocha e Latte.
     *
     * @param showPane indica se o tema foi aplicado.
     */
    public static void toggleStyle(boolean showPane)
    {
        FlatAnimatedLafChange.showSnapshot();
        applyStyle(isLight ? DARK : LIGHT, showPane);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
        isLight = !isLight;
    }
}
