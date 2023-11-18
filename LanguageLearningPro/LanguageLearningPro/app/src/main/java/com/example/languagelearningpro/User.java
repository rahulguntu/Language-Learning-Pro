package com.example.languagelearningpro;

public class User {


    private String userName;

    private String email;
    private String password;

    private int id;

    // creating getter and setter methods
    public String getUserName() { return userName; }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }


    public String getEmail() { return email; }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword() { return password; }

    public void setPassword(String password)
    {
        this.password = password;
    }



    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public User(String id, String userName,
                     String email,
                     String password)
    {
        this.id = Integer.parseInt(id);
        this.userName = userName;
        this.email = email;
        this.password = password;

    }
}
