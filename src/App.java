public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Data data = new Data(new Mariadb());
        data.connect();
    }
}
