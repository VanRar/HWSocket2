import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int S_PORT = 8888;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(S_PORT);
            System.out.println("Сервер запущен");
            Socket clientSocket = serverSocket.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);

            out.println("Привет, напишите своё имя");
            String name = in.readLine();

            out.println("Ты ребенок? да/нет");
            String age = in.readLine();

            if ("да".equals(age)) {
                out.println("Добро пожаловать в десткую зону, " + name + "\n"); //перевод строки или out.println(); после условий, для пустой строки, что бы закрыть прогу корректно
            } else {
                out.println("Добро пожаловать во взрослую зону, " + name + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}