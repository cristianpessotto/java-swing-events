package dev.pessotto.view.managers;

import java.util.*;
import java.util.function.Consumer;

/**
 * <h2>{@code EventBusManager}📢</h2>
 *
 * {@link EventBusManager} é uma classe que seque em paralelo ao padrão Observer, ela gerência o
 * registro de eventos com rótulos e dispara todos os callbacks que monitoram no evento.
 *
 * @author Cristian Pessotto
 */
public final class EventBusManager
{
    /**
     * {@link Event} é uma classe auxiliar que repassa os dados para o callback.
     *
     * @param T o tipo de dado que o evento irá conter.
     */
    public static final class Event<T>
    {
        public final T data;
        public Event(T data) { this.data = data; }
    }

    /**
     * Uma mapeamento com nome do evento e uma lista de callbacks que recebem um {@code Event} genérico.
     */
    public static final Map<String, List<Consumer<Event<?>>>> listeners = new HashMap<>();

    /**
     * Classe utilitária não precisa de instância (evite usar singleton).
     */
    private EventBusManager(){}

    /**
     * Registra um conjunto callbacks para determinando evento.
     *
     * @param name o nome do evento que será monitorado.
     * @param action a função que é executada após o disparo do eventos.
     */
    public static void subscribe(String name, Consumer<Event<?>> action)
    {
        listeners.computeIfAbsent(name, e -> new ArrayList<>()).add(action);
    }

    /**
     * Executa cada função conforme o nome do evento que é chamado.
     *
     * @param <T> o tipo de informação passada para o callback.
     * @param name o nome do evento.
     * @param data os dado passados para esse evento.
     */
    public static <T> void publish(String name, T data)
    {
        var consumers = listeners.get(name);
        if (consumers != null)
            for (var consumer : consumers)
                consumer.accept(new Event<T>(data));
    }
}
