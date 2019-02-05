package com.baeldung.crud.repositories;

import com.baeldung.crud.entities.LoanApplication;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanApplicationRepository extends CrudRepository<LoanApplication, Long> {
}
