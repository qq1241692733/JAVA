import com.sun.org.apache.xerces.internal.impl.xs.util.XSObjectListImpl;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-04-2021/4/13
 * Time: 20:53
 */
public class UDPServer {
    // 端口号
    private static final int port = 6666;
    // 传递数据最大值
    private static final int bleng = 1024;
    public static void main(String[] args) throws IOException {
        //1.启动一个UDP 服务器(IP,端口号)
        DatagramSocket socket = new DatagramSocket(port);
        System.out.println("服务器已经启动");
        while (true) {
            // 初始化数据包
            DatagramPacket clientPacket = new DatagramPacket(
                    new byte[bleng],
                    bleng
            );
            // 等待客户端连接
            socket.receive(clientPacket);
            // 执行到此步骤,表示已经有客户端连接
            String msg = new String(clientPacket.getData());
            System.out.println("接收到客户端的信息"+ msg);
            //个客户端一个响应

            String serMsg = "我收到了";
            //发送消息
            DatagramPacket serPacket = new DatagramPacket(
                    serMsg.getBytes(),
                    serMsg.getBytes().length,  //是字节长度
                    clientPacket.getAddress(),
                    clientPacket.getPort()
            );
            socket.send(serPacket);
        }
    }
}
