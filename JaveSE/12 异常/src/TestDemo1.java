/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/19
 * Time: 16:38
 */

class UserException extends Exception {
    public UserException(String message) {
        super(message);
    }
}

class PasswordException extends Exception {
    public PasswordException(String message) {
        super(message);
    }
}

public class TestDemo1 {
    private static String userName = "admin";
    private static String passWard = "123456";
    public static void login1(String userName, String passWard) {
        if (!TestDemo1.userName.equals(userName)) {
            //处理用户名错误
        }
        if (!TestDemo1.passWard.equals(passWard)) {
            //处理密码错误
        }
        System.out.println("登录成功");
    }

    /**
     * 自定义异常
     * 在 login2 中声明异常，调用的时候处理异常
     * 或者 在login2中处理异常，直接调用
     */
    public static void login2(String userName, String passWard) throws UserException {
        if (!TestDemo1.userName.equals(userName)) {
            throw new UserException("用户名错误");
        }

        if (!TestDemo1.passWard.equals(passWard)) {
            try {
                throw new PasswordException("密码错误");
            } catch (PasswordException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main1(String[] args) {
        try {
            login2("admin", "123456");
        } catch (UserException e ) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

}
