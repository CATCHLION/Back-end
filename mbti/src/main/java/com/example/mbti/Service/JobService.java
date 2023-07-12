package com.example.mbti.Service;

import com.example.mbti.Domain.Company;
import com.example.mbti.Domain.CoverLetter;
import com.example.mbti.Domain.Job;
import com.example.mbti.Domain.Mbti;
import com.example.mbti.Dto.FindDetailDto;
import com.example.mbti.Dto.FindJobsDto;
import com.example.mbti.Repository.CompanyRepository;
import com.example.mbti.Repository.CoverLetterRepository;
import com.example.mbti.Repository.JobRepository;
import com.example.mbti.Req.CompanyInsert;
import com.example.mbti.Req.JobInsert;
import com.example.mbti.Req.PostReq;
import com.example.mbti.Res.CoverLetterRes;
import com.example.mbti.Res.DetailRes;
import com.example.mbti.Res.JobsRes;
import com.example.mbti.Validation.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class JobService {
    private final JobRepository jobRepository;

    private final CompanyRepository companyRepository;

    private final CoverLetterRepository coverLetterRepository;

    public Object findJobs() {
        List<Job> jobList = jobRepository.findAll();

        List<FindJobsDto> findJobsDtos = new ArrayList<>();

        for (Job job : jobList) {
            Optional<Company> company = companyRepository.findById(job.getCompany().getId());
            //Company company = jobRepository.findByCompany_CompanyId(job.getId());
            findJobsDtos.add(FindJobsDto.builder()
                    .job(job)
                    .company(company.get())
                    .build());
        }

        return new JobsRes(ExceptionCode.JOBS_RETURN, findJobsDtos);
    }

    public Object findDetails(Long jobId) {
        Optional<Job> job = jobRepository.findById(jobId);

        Optional<Company> company = companyRepository.findById(job.get().getCompany().getId());

        FindDetailDto findDetailDto = new FindDetailDto(job.get(), company.get());

        return new DetailRes(ExceptionCode.DETAIL_RETUN, findDetailDto);
    }

    public void saveJob(JobInsert req){
        Optional<Company> company = companyRepository.findById(req.getCompanyId());

        Job job = Job.builder()
                .jobInsert(req)
                .company(company.get())
                .build();

        jobRepository.save(job);
    }

    public void saveCompany(CompanyInsert req){

        Company company = Company.builder()
                .companyInsert(req)
                .build();

        companyRepository.save(company);
    }

    public Object saveCoverLetter(PostReq req, Long jobId){
        Optional<Job> job = jobRepository.findById(jobId);

        CoverLetter coverLetter = CoverLetter.builder()
                .postReq(req)
                .job(job.get())
                .build();

        coverLetterRepository.save(coverLetter);

        return new CoverLetterRes(ExceptionCode.COVER_LETTER_RETUN, coverLetter.getId(), coverLetter.getContent());
    }
}
