import java.util.Arrays;
import java.util.List;

public class Java8LambdaStream {
    public static void main(String[] args) {
        //JAVA 8: FUNÇÕES LAMBDAS[

        //API STREAM

        //stream - fluxo de dados

        List<Integer> list = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);
        list.stream()
                .skip(2)
                .limit(3)
                .distinct()
                .map(e -> e * 2)
                .forEach((e) -> System.out.println(e));
    }
}
