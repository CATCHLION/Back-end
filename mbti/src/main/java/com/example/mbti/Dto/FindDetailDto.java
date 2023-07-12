package com.example.mbti.Dto;

import com.example.mbti.Domain.Company;
import com.example.mbti.Domain.Job;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class FindDetailDto {

    private Long jobId;

    private LocalDate deadline;

    private String title;

    private String description;

    private Long companyId;
    private String name;

    private String location;

    @Builder
    public FindDetailDto(Job job, Company company) {
        this.jobId = job.getId();

        this.deadline = job.getDeadline();

        this.description = job.getDescription();

        this.title = job.getTitle();

        this.companyId = company.getId();

        this.location = company.getLocation();

        this.name = company.getName();
    }
}
