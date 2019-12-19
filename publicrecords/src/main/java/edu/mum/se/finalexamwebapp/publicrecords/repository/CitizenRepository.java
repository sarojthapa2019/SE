package edu.mum.se.finalexamwebapp.publicrecords.repository;

import edu.mum.se.finalexamwebapp.publicrecords.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen,Long> {
}
