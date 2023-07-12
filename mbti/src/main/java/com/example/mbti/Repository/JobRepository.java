package com.example.mbti.Repository;

import com.example.mbti.Domain.Company;
import com.example.mbti.Domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

}
