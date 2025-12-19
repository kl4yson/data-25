import java.util.*;

public class BasicDataOperationUsingMap_Spider {

    public static void main(String[] args) {
        // 1. Створення Map
        Map<Spider, String> spiderMap = new TreeMap<>();

        // 2. Заповнення Map початковими даними
        spiderMap.put(new Spider("Павук", 25.5), "Ростислав");
        spiderMap.put(new Spider("Оса", 18.2), "Злата");
        spiderMap.put(new Spider("Мережка", 32.7), "Макар");
        spiderMap.put(new Spider("Ловець", 22.1), "Ярослава");
        spiderMap.put(new Spider("Оса", 28.4), "Орест");
        spiderMap.put(new Spider("Круг", 15.8), "Макар");
        spiderMap.put(new Spider("Інтернет", 35.2), "Богдан");
        spiderMap.put(new Spider("Зловісний", 19.6), "Демид");
        spiderMap.put(new Spider("Візерунок", 30.1), "Злата");
        spiderMap.put(new Spider("Арахнід", 12.3), "Лариса");

        // 3. Виведення початкового Map
        System.out.println("=== Початковий Map ===");
        printMap(spiderMap);

        // 4. Пошук за ключем
        Spider searchKey = new Spider("Оса", 18.2);
        long start = System.nanoTime();
        String owner = spiderMap.get(searchKey);
        long end = System.nanoTime();
        System.out.println("\nПошук за ключем: " + searchKey);
        System.out.println("Результат: " + owner);
        System.out.println("Час: " + (end - start) + " нс");

        // 5. Пошук за значенням
        String searchValue = "Макар";
        start = System.nanoTime();
        for (Map.Entry<Spider, String> entry : spiderMap.entrySet()) {
            if (entry.getValue().equals(searchValue)) {
                System.out.println("Знайдено за значенням: " + entry.getKey());
            }
        }
        end = System.nanoTime();
        System.out.println("Час пошуку за значенням: " + (end - start) + " нс");

        // 6. Додавання нового елемента
        Spider newSpider = new Spider("Сітка", 26.8);
        start = System.nanoTime();
        spiderMap.put(newSpider, "Богдан");
        end = System.nanoTime();
        System.out.println("\nДодано: " + newSpider + " -> Богдан");
        System.out.println("Час додавання: " + (end - start) + " нс");

        // 7. Видалення за ключем
        start = System.nanoTime();
        spiderMap.remove(searchKey);
        end = System.nanoTime();
        System.out.println("\nВидалено за ключем: " + searchKey);
        System.out.println("Час видалення за ключем: " + (end - start) + " нс");

        // 8. Видалення за значенням
        start = System.nanoTime();
        spiderMap.entrySet().removeIf(e -> e.getValue().equals(searchValue));
        end = System.nanoTime();
        System.out.println("Видалено всі записи зі значенням: " + searchValue);
        System.out.println("Час видалення за значенням: " + (end - start) + " нс");

        // 9. Кінцевий Map
        System.out.println("\n=== Кінцевий Map ===");
        printMap(spiderMap);
    }

    private static void printMap(Map<Spider, String> map) {
        for (Map.Entry<Spider, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

class Spider implements Comparable<Spider> {
    private String nickname;
    private double webSize;

    public Spider(String nickname, double webSize) {
        this.nickname = nickname;
        this.webSize = webSize;
    }

    @Override
    public int compareTo(Spider other) {
        int nameCompare = other.nickname.compareTo(this.nickname); // за зменшенням
        if (nameCompare != 0) {
            return nameCompare;
        }
        return Double.compare(this.webSize, other.webSize); // за зростанням
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Spider)) return false;
        Spider spider = (Spider) o;
        return Double.compare(spider.webSize, webSize) == 0 && nickname.equals(spider.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, webSize);
    }

    @Override
    public String toString() {
        return "Spider{nickname='" + nickname + "', webSize=" + webSize + "}";
    }
}
