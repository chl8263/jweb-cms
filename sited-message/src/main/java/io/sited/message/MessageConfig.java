package io.sited.message;

/**
 * @author chi
 */
public interface MessageConfig {
    <T> MessageConfig createTopic(Class<T> messageClass, TopicOptions options);

    <T> MessageConfig listen(Class<T> messageClass, Class<? extends MessageHandler<T>> handlerClass);

    <T> MessageConfig listen(Class<T> messageClass, MessageHandler<T> handler);
}
