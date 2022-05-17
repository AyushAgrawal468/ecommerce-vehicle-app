package com.niit.authenticationservice.repository;

import com.niit.authenticationservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//indicates that this interface provides the mechanism for CRUD operations.
@Repository
public interface UserRepository extends JpaRepository<User,String> {

  public User findByUsernameAndPassword(String username , String password);

}
