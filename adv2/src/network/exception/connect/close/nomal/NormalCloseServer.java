package network.exception.connect.close.nomal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class NormalCloseServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept(); //블로킹즁??
        log("소캣 연결: " + socket);

        Thread.sleep(3000);
        socket.close(); //ㅋㅋ 이걸안함 ㅠㅠ
        log("소켓 종료");
    }
}
