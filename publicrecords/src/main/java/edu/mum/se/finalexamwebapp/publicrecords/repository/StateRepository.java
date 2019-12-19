package edu.mum.se.finalexamwebapp.publicrecords.repository;

import edu.mum.se.finalexamwebapp.publicrecords.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
}
