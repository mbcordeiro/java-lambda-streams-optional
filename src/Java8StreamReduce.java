import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class Java8StreamReduce {
    public static void main(String[] args) {
        String s = "Java 8 stream reduce!";
        String[] split = s.split(" ");
        List<String> listString = Arrays.asList(split);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        //reduce sum
        Optional<Integer> sum = list.stream()
                .reduce((n1, n2) -> n1 + n2);
        System.out.println(sum.get());

        //reduce multi
        Optional<Integer> multiplication = list.stream()
                .reduce((n1, n2) -> n1 * n2);
        System.out.println(multiplication.get());

        //reduce concat
        Optional<String> concat = listString.stream()
                .reduce((s1, s2) -> s1.concat(s2));
        System.out.println(concat.get());

        //reduce subtraction - não faça
        Optional<Integer> subtraction = list.stream()
                .reduce((n1, n2) -> n1 - n2);
        System.out.println(subtraction.get());

        //reduce sum identity
        Integer sum2 = list.stream()
                .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(sum2);

        //reduce multi identity
        Integer multiplication2 = list.stream()
                .reduce(1, (n1, n2) -> n1 * n2);
        System.out.println(multiplication2);

        //reduce concat identity
        String concat2 = listString.stream()
                .reduce("", (s1, s2) -> s1.concat(s2));
        System.out.println(concat2);

        List<Integer> listEmpty = Arrays.asList();
        //reduce sum identity
        Integer sum3 = listEmpty.stream()
                .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(sum2);

        //reduce lower value
        OptionalDouble reduce = DoubleStream.of(1.5, 2.9, 6.7)
                .reduce((d1, d2) -> Math.min(d1, d2));
        System.out.println(reduce);

        //reduce lower value identity
        double reduce2 = DoubleStream.of(1.5, 2.9, 6.7)
                .reduce(Double.POSITIVE_INFINITY, (d1, d2) -> Math.min(d1, d2));
        System.out.println(reduce2);

        //reduce sum
        Integer sum4 = list.stream()
                .reduce(0, (n1, n2) -> n1 + n2, (n1, n2) -> n1 + n2);
        System.out.println(sum4);

        //reduce multi + combine
        String multiplication3 = list.stream()
                .reduce(
                        "",
                        (n1, n2) -> n1.toString().concat(n2.toString()),
                        (n1, n2) -> n1.concat(n2)
                );
        System.out.println(multiplication3);
    }
}
