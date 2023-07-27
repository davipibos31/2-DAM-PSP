package com.example.practicauno.utils;


@SuppressWarnings("unused")
public class MessageUtils extends Exception {
    public MessageUtils() {
        super();
    }

   public MessageUtils(String message) {super(message);}

   public MessageUtils(String message, Throwable cause) {super(message, cause);}

    public MessageUtils(Throwable cause) {
        super(cause);
    }

    protected MessageUtils(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {super(message, cause, enableSuppression, writableStackTrace);}
}
