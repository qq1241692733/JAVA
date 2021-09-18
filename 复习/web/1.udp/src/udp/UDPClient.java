package udp;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/9
 * Time: 20:33
 */
public class UDPClient {
    // 服务器的 ip
    //private static final String ip = "127.0.0.1";
    private static final String ip = "110.42.217.78";
    private static final int port = 9001;
    private static final int bleng = 1024;
    public static void main(String[] args) throws IOException {
        // 1.启动客户端
        DatagramSocket client = new DatagramSocket(); // 无参，随机端口号
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("我：");
            String msg = scanner.nextLine();
            // 2.给客户端发消息
            DatagramPacket datagramPacket = new DatagramPacket(
                    msg.getBytes(),
                    msg.getBytes().length,
                    InetAddress.getByName(ip),
                    port
            );
            client.send(datagramPacket);
            // 3.接受服务器的返回信息
            DatagramPacket serPacket = new DatagramPacket(
                    new byte[bleng],
                    bleng
            );
            client.receive(serPacket);
            // 接受到客户端的返回信息
            String serMsg = new String(serPacket.getData());
            System.out.println("对方：" + serMsg);  // 服务器返回
        }
    }
}
