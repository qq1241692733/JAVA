package udp;

import org.omg.PortableServer.POA;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


/**
 * Created with IntelliJ IDEA.
 * Description:
        UDP服务器端
 * User: hong yaO
 * Date: 2021-09-2021/9/9
 * Time: 20:33
 */

public class UDPServer {
    private static final int port = 9001;   // 端口号
    private static final int bleng = 1024;  // 数据最大值
    public static void main(String[] args) throws IOException {
        // 1.启动 UDP 服务器端(IP、端口号)   IP 默认
        DatagramSocket socket = new DatagramSocket(port);
        System.out.println("服务器已启动");
        while (true) {
            // 初始化一个数据包
            DatagramPacket clientPacket = new DatagramPacket(
                    new byte[bleng],
                    bleng
            );
            // 等待客户端的链接
            socket.receive(clientPacket);
            // 需要链接到一个数据包
            // 右客户端链接
            String msg = new String(clientPacket.getData());
            System.out.println("接收到客户端的信息:" + msg);
            // 响应
            String serMsg = msg.replace("吗？","。");
            DatagramPacket serPacket = new DatagramPacket(
                    serMsg.getBytes(),
                    serMsg.getBytes().length,
                    clientPacket.getAddress(), // ip
                    clientPacket.getPort()  // 端口号
            );
            socket.send(serPacket);
        }
    }
}
