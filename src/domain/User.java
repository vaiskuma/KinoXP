package domain;

public class User {

    private String username;
    private String password;

    public User(String username, String password){

        this.username = username;
        this.password = password;
    }

    public void setUsername(String name){
        this.username = name;
    }

    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

}

