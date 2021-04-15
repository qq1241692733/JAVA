package tcp;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Description:
    自定义 HTTP 服务器
    根据 uri 内容返回不同的信息
    如果 uri 里边包含404 返回一个
 * User: hong yaO
 * Date: 2021-04-2021/4/15
 * Time: 21:09
 */
public class MyHttp {
    private static final int port = 9004;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        Socket socket = serverSocket.accept();

        try(BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()))
        ) {
            String firstLine = bufferedReader.readLine();
            String[] fLineArr = firstLine.split(" ");
            String method = fLineArr[0];
            String uri = fLineArr[1];
            String httpVersion = fLineArr[2];
            System.out.println(String.format("首行信息 -> 方法类型：%s,URI：%s,HTTP版本号：%s",
                    method, uri, httpVersion));

            String content = "";
            if(uri.contains("404")) {
                content = "<h1>没有找到此页面</h1>";
            }
            bufferedWriter.write(String.format("%s 200 ok",httpVersion)+"\n");
            bufferedWriter.write("Content-Type: text/html;charset=utf-8\n");
            bufferedWriter.write("Content-Length: " + content.getBytes().length + "\n");
            // 输出空行
            bufferedWriter.write("\n");
            bufferedWriter.write(content);
            bufferedWriter.flush();
        }
    }
}