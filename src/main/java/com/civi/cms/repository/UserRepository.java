package com.civi.cms.repository;

import com.civi.cms.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserLogin,String>
{
    //Optional<UserLogin> findByUsername(String );

//Optional<UserLogin> findByUsername(String username);
}

