package com.example.mbti.Req;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class JobInsert {
    private Long companyId;

    private String title;
    private String description;
    private LocalDate deadline;
}
