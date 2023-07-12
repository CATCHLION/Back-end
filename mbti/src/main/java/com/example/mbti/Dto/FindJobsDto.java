package com.example.mbti.Dto;

import com.example.mbti.Domain.Company;
import com.example.mbti.Domain.Job;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Optional;

@Getter
public class FindJobsDto {

    private Long jobId;

    private LocalDate deadline;

    private String title;

    private Long companyId;
    private String name;

    private String location;

    @Builder
    public FindJobsDto(Job job, Company company) {
        this.jobId = job.getId();

        this.deadline = job.getDeadline();

        this.title = job.getTitle();

        this.companyId = company.getId();

        this.location = company.getLocation();

        this.name = company.getName();
    }
}
