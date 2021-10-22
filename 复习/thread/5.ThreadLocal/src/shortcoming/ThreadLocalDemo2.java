package shortcoming;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/14
 * Time: 17:54
 */
public class ThreadLocalDemo2 {
    /**
     *   2.threadLocal 实现线程级别的数据传递
     */
    public static void main(String[] args) {
        // 模拟用户登录操作
        User user = new User();
        user.setUsername("java");
        // 设置到ThreadLocal
        ThreadLocalUtil.threadLocal.set(user);
        // 调用订单系统
        Order order = new Order();
        order.getOrder();
        // 调用日志系统
        Logger logger = new Logger();
        logger.addLog();
    }


    static class ThreadLocalUtil {
        // 如果写成静态属性的话那么只能在这一个类里能访问到，
        static ThreadLocal<User> threadLocal =
                new ThreadLocal<>();
    }

    static class User {
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    /**
     *  日志系统
     */
    static class Logger {
        public void addLog() {
            User user = ThreadLocalUtil.threadLocal.get();
            System.out.println("添加了：" + user.getUsername());
        }
    }

    /**
     * 订单系统
     */
    static class Order {
        public void getOrder() {
            User user = ThreadLocalUtil.threadLocal.get();
            System.out.println("订单列表：" + user.getUsername());
        }
    }
}
