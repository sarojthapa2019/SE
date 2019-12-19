package edu.mum.cs.cs425.elibrary2.repository;

import edu.mum.cs.cs425.elibrary2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}
