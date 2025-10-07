package network.exception.connect.close.nomal;

import java.io.*;
import java.net.Socket;

import static util.MyLogger.log;

public class NormalCloseClient {
    public static void main(String[] args) throws IOException,InterruptedException{
        Socket socket = new Socket("localhost", 12345);
        log("소캣 연결: " + socket);
        InputStream input = socket.getInputStream();

        readByInputStream(input, socket);
        //readByBufferedReader(input, socket);
        //readByDataInputStream(input, socket);

        log("연결 종료: " + socket.isClosed());
    }

    private static void readByInputStream(InputStream input, Socket socket) throws IOException {
        int read = input.read();
        log("read = " + read);
        if(read == -1){
            input.close();
            socket.close();
        }
    }

    private static void readByDataInputStream(InputStream input, Socket socket) throws IOException   {
        DataInputStream dis = new DataInputStream(input);
        try {
            dis.readUTF();
        } catch (IOException e) {
            log(e);
        } finally {
            dis.close();
            socket.close();
        }

    }

    private static void readByBufferedReader(InputStream input, Socket socket) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(input)); //InputStream 바이트기반 최상위 클래스 InputStreamReader 바이트를 문자열로 BufferedReader 입출력 효율
        String readStr = br.readLine();
        log("read = " + readStr);
        if(readStr == null){
            br.close();
            socket.close();
        }
    }


}
