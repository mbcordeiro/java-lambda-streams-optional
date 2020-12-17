import java.util.Optional;
import java.util.stream.Stream;

public class Java8Optional {
    public static void main(String[] args) {
        String s = "1";
        convertNumber(s).ifPresent(n -> System.out.println(n));

        Integer number = convertNumber(s).orElse(5);
        System.out.println(number);

        Integer number2 = convertNumber(s).orElseGet(() -> 5);
        System.out.println(number2);

        Integer number3 = convertNumber(s).orElseThrow(() -> new NullPointerException("Empty"));
        System.out.println(number3);

        Stream.of(1, 2, 3).findFirst().ifPresent(System.out::println);
    }

    private static Optional<Integer> convertNumber(String s) {
        try {
            Integer integer = Integer.valueOf(s);
            return Optional.of(integer);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
