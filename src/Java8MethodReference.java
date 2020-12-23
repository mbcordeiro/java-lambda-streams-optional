import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Java8MethodReference {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        list.stream()
                .forEach(System.out::println);

        //métodos estáticos
        list.stream()
                .map((n) -> multiplyByTwo(n))
                .forEach(System.out::println);

        list.stream()
                .map(Java8MethodReference::multiplyByTwo)
                .forEach(System.out::println);

        //construtores
        list.stream()
                .map((n) -> new BigDecimal(n))
                .forEach(System.out::println);

        list.stream()
                .map(BigDecimal::new)
                .forEach(System.out::println);

        //várias instâncias
        list.stream()
                .map((n) -> n.doubleValue())
                .forEach(System.out::println);

        list.stream()
                .map(Integer::doubleValue)
                .forEach(System.out::println);

        //única instncia
        BigDecimal decimal = new BigDecimal(2);
        list.stream()
                .map(BigDecimal::new)
                .map((d) -> decimal.multiply(d))
                .forEach(System.out::println);

        list.stream()
                .map(BigDecimal::new)
                .map(decimal::multiply)
                .forEach(System.out::println);
    }

    private static Integer multiplyByTwo(Integer i) {
        return i * 2;
    }
}
