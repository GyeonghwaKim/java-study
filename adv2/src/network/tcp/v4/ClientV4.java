package network.tcp.v4;

import network.tcp.SocketCloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static Util.MyLogger.log;

public class ClientV4 {
//serverV4하기
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");
        Socket socket = null; //서버 포트
        DataInputStream input = null; //받을떄
        DataOutputStream output = null; //보낼때
        try {
            socket = new Socket("localhost", PORT);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            log("소캣 연결: " + socket);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("전송 문자: ");
                String toSend = scanner.nextLine();
                output.writeUTF(toSend);
                log("client -> server: " + toSend);

                if (toSend.equals("exit")) {
                    break;
                }

                String received = input.readUTF();
                log("client <- server: " + received);
            }

        } catch (IOException e) {
            log(e);
        } finally {
            SocketCloseUtil.closeAll(socket, input, output);
            log("연결 종료: " + socket);
        }

    }

}
