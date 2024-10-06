package main.java.ru.netology.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    private int threshold; // пороговое значение f
    Logger logger = Logger.getLogger();

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(ArrayList<Integer> randomList) {
        logger.log("Фильтрация началась");
        return randomList.stream()
                .filter(num -> {
                    if (num <= threshold) {
                        logger.log("число " + num + " добавлено в список");
                        return true;
                    } else {
                        logger.log("Число " + num + " не прошло фильтрацию");
                        return false;
                    }
                })
                .collect(Collectors.toList());
    }
}
