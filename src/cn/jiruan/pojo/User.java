package cn.jiruan.pojo;

public class User {
    private Integer userPrimaryKey;
    private String userName;
    private String password;

    public User(Integer userPrimaryKey, String userName, String password) {
        this.userPrimaryKey = userPrimaryKey;
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User() {
    }

    public Integer getUserPrimaryKey() {
        return userPrimaryKey;
    }

    public void setUserPrimaryKey(Integer userPrimaryKey) {
        this.userPrimaryKey = userPrimaryKey;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
