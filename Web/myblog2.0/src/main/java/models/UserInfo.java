package models;

import javax.xml.crypto.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-04-2021/4/9
 * Time: 11:36
 */
public class UserInfo {
    private int id;
    private Data createtime;
    private Data updatatime;
    private String username;
    private String password;
    private int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Data getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Data createtime) {
        this.createtime = createtime;
    }

    public Data getUpdatatime() {
        return updatatime;
    }

    public void setUpdatatime(Data updatatime) {
        this.updatatime = updatatime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
