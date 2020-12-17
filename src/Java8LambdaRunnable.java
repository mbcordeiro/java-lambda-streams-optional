public class Java8LambdaRunnable {
    public static void main(String[] args) {
        // JAVA 8: FUNÇÕES LAMBDAS

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        }).run();

        new Thread(() -> System.out.println("Hello")).run();

        //SAM Single Abstract Method
        //Qualquer interface que tenha apenas um método abstrato
    }
}
