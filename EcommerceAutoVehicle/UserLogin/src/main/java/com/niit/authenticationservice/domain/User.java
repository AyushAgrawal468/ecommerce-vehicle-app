package com.niit.authenticationservice.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//annotated with Entity means that this the basic structure that is going to be stored in the database...wher each property is the column and the class is the table.
@Entity
public class User {
//the id here represents the primary key in the SQL database
  @Id
  private String username;
  private String password;
  private String type;

  public User(){}

  public User(String username, String password, String type) {
    this.username = username;
    this.password = password;
    this.type = type;
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "User{" +
            "username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", type='" + type + '\'' +
            '}';
  }
}
