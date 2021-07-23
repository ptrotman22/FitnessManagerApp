package com.example.demo.entity;
import javax.persistence.*;

//Employee Entity
@Entity //This will let Java know that this is an entity that we are going to map to a database table.
@Table(name = "account") //This is for the actual name of the database table we are mapping to the class.
public class Fitness {

    //Define fields
    @Id //This will map the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This will auto increment your primary key
    @Column(name = "id") //This is mapping the primary key to the id column in the table.
    private int id;

    @Column(name = "username") //This will map the firstName field to the column named job_title in the table.
    private String username;

    @Column(name = "password") //This will map the password field to the column named password in the table.
    private String password;

    @Column(name = "name") //This will map the firstName field to the column named first_name in the table.
    private String name;

    @Column(name = "address") //This will map the email field to the column named email in the table.
    private String address;

    @Column(name = "position") //This will map the Phone Number field to the column named Phone Number in the table.
    private String position;


    //default constructor
    public Fitness() {
    }

    //para constructor
    public Fitness(String username, String name, String password, String address, String position) {
        this.username = username;
        this.password =password;
        this.name = name;
        this.address = address;
        this.position = position;
    }

    //getter/setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    //ToString Method
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

}
