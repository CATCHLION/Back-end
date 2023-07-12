package com.example.mbti.Res;

import com.example.mbti.Dto.FindJobsDto;
import com.example.mbti.Validation.ExceptionCode;
import lombok.Getter;

import java.util.List;

@Getter
public class JobsRes extends ResponseJob{
    private List<FindJobsDto> jobList;

    public JobsRes(ExceptionCode exceptionCode, List<FindJobsDto> jobList) {
        super(exceptionCode);
        this.jobList = jobList;
    }
}
