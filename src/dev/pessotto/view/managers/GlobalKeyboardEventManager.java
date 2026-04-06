package dev.pessotto.view.managers;

import java.awt.Component;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Window;

/**
 * <h2>{@code GlobalKeyboardEventManager}⌨️</h2>
 *
 * {@link GlobalKeyboardEventManager} é um wrapper para a classe {@link KeyboardFocusManager} que
 * gerencia a forma como os elementos da janela ativa entram em foco, além de definir como os dados
 * de um evento de teclado é passado para o elemento em foco.
 *
 * @author Cristian Pessotto
 */
public final class GlobalKeyboardEventManager
{
    /**
     * Manager é a própria instância do {@link KeyboardFocusManager}.
     */
    private final static KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();

    /**
     * Classe utilitária não precisa de instância (evite usar singleton).
     */
    private GlobalKeyboardEventManager(){}

    /**
     * @return O componente que está em foco.
     */
    public static Component getFocusComponent()
    {
        return manager.getFocusOwner();
    }

    /**
     * @return A janela que está em foco.
     */
    public static Window getFocusWindow()
    {
        return manager.getFocusedWindow();
    }

    /**
     *
     * Adiciona eventos de teclado globais que são interceptados antes de enviar para o componente em
     * foco. A assinatura com retorno e visibilidade do callback dev ser:
     *
     * <pre>
     *  public boolean callbackName(KeyEvent e)
     * </pre>
     *
     * @param dispatcher uma interface funcional do tipo {@link KeyEventDispatcher}.
     *
     */
    public static void addKeyEvent(KeyEventDispatcher dispatcher)
    {
        manager.addKeyEventDispatcher(dispatcher);
    }
}
