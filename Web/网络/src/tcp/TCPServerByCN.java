package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-04-2021/4/15
 * Time: 20:43
 */
public class TCPServerByCN {
    private static final int port = 6668;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("已启动服务端");

        Socket socket = serverSocket.accept();
        System.out.println(String.format("已连接到客户端， IP %s, Port: %d",
                socket.getInetAddress().getHostAddress(),
                socket.getPort()));

        try(BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()))
        ) {
            String en = bufferedReader.readLine();
            String cn = processData(en);

            String serMsg = "我收到了";
            bufferedWriter.write(serMsg + "\n"); // \n 不能省略
            bufferedWriter.flush();
            bufferedReader.close();
        }
    }

    //英译汉
    private static String processData(String en) {
        String cn = " ";
        switch (en) {
            case "hello":
                cn = "你好";
                break;
        }
        return cn;
    }
}
