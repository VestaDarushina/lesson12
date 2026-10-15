import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task1 {
    public static void main(String[] args) {

        List<Stranger> strangers = new ArrayList<>(List.of(
                new Stranger("Анна", 29),
                new Stranger("Иван", 25),
                new Stranger("Мария", 25),
                new Stranger("Павел", 26),
                new Stranger("Святослав", 27),
                new Stranger("Екатерина", 28)
        ));
        PairGenerator pairGenerator = new PairGenerator();

        System.out.println("На этой неделе в Random Coffee участвуют: " + strangers);

        List<List<Stranger>> splitByPairs = pairGenerator.splitByPairs(strangers);

        System.out.println("Генератор случайных чисел составил пары: " + splitByPairs);
    }
}
class PairGenerator {

    private static final Random rnd = new Random();

    /**
     * Разбивает список незнакомцев по парам.
     */
    public List<List<Stranger>> splitByPairs(List<Stranger> strangers) {

        List<List<Stranger>> pairs = new ArrayList<>();
        while (!strangers.isEmpty()) {
            List<Stranger> pair = getRandomPair(strangers);
            pairs.add(pair);
        }

        return pairs;
    }

    /**
     * Возвращает одну пару и удаляет её из списка strangers
     */
    private List<Stranger> getRandomPair(List<Stranger> strangers) {

        int p1Index = rnd.nextInt(strangers.size());
        int p2Index = rnd.nextInt(strangers.size());
        while (p2Index == p1Index) {
            p2Index = rnd.nextInt(strangers.size());
        }

        Stranger strangerOne = strangers.get(p1Index);
        Stranger strangerTwo = strangers.get(p2Index);

        List<Stranger> pair = List.of(strangerOne, strangerTwo);
        strangers.removeAll(pair);

        return pair;
    }
}
class Stranger {
    public final String name;
    public final int age;

    public Stranger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}