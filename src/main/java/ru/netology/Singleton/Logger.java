package main.java.ru.netology.Singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger logger = null;
    private int count = 0;


    // приватный конструктор, чтобы предотвратить создание объектов вне класса
    private Logger() {
    }

    public static Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    void log(String msg) {
        count++;
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.printf("[%s %d] %s \n", dateTime.format(formatter), count, msg);
    }
}
