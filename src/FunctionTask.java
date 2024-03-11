
//Napisz aplikację, w której z wykorzystaniem klasy Random i wyrażenia lambda wygenerujesz 10 losowych liczb (interfejs Supplier). Wyświetl listę (wszystkie liczby obok siebie, po spacji) na ekranie również wykorzystując wyrażenia lambda (interfejs Consumer).
//
//Następnie napisz metodę, która usunie z listy wszystkie liczby podzielne przez 2 (użyj iteratora i własnej metody wykorzystującej interfejs Predicate).
//
//Ponownie wyświetl wynik na ekranie.


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionTask {
    public static void main(String[] args) {

        Random random = new Random();
        Supplier<Integer> numberSupplier = () -> random.nextInt(1000);
        List<Integer> randomNumbers = new ArrayList<>();
        generate(randomNumbers, 10, numberSupplier);
        Consumer<Integer> consumer = x -> System.out.print(x+" ");
        consume(randomNumbers, consumer);
        filterList(randomNumbers, x -> x % 2 == 0);
        consume(randomNumbers, consumer);

        }

    private static <T> void generate(List<T> list, int toGenerate, Supplier<T> sup){
        for (int i = 0; i < toGenerate; i++) {
            list.add(sup.get());
            
        }
    }

    private  static <T> void consume (List<T> list, Consumer<T> consumer){
        for (T t : list) {
            consumer.accept(t);

        }
    }
    private static <T> void filterList(List <T> list, Predicate<T> predicate){
        Iterator<T> iterator= list.iterator();
        while (iterator.hasNext()){
            T next = iterator.next();
            if (predicate.test(next))
                iterator.remove();

        }
    }
}


