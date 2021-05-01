package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-04-2021/4/13
 * Time: 21:07
 */
public class UDPClient {
    //IP
    private static final  String ip = "127.0.0.1";
    // 端口号
    private static final int port = 6666;
    // 传递数据最大值
    private static final int bleng = 1024;
    public static void main(String[] args) throws IOException {
        //1 启动客户端
        DatagramSocket client = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("->");
            String msg = scanner.nextLine();
            //2. 给服务器端发送消息
            DatagramPacket datagramPacket = new DatagramPacket(
                    msg.getBytes(),
                    msg.getBytes().length,
                    InetAddress.getByName(ip),
                    port
            );
            client.send(datagramPacket);
            DatagramPacket serPacket = new DatagramPacket(
                    new byte[bleng],
                    bleng
            );
            client.receive(serPacket);
            String serMsg = new String(serPacket.getData());
            System.out.println("服务器返回" + serMsg);
        }
    }
}
