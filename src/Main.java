import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        new UserInterface();

           Controller controller = new Controller();
           controller.run();
           controller.exit();
    }
}