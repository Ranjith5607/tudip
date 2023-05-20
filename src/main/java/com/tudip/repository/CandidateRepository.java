package com.tudip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tudip.model.CandidatesModel;

@Repository
public interface CandidateRepository extends JpaRepository<CandidatesModel, Long> {

}
