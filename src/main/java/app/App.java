package app;

public class App {

    public static final String URL = "https://raw.githubusercontent.com/bassaer/dummy-data/main/user.json";

    public static void main(String[] args) {
       Client client = new Client();
       System.out.println("result : " + client.get(URL));
    }
}
