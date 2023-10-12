package com.pwusilva.todolist.user;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_users")
public class UserModel {
  
  @Id
  private UUID id;

  private String Name;
  private String Username;
  private String Password;
  


}
