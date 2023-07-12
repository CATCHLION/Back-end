package com.example.mbti.Controller;

import com.example.mbti.Domain.Company;
import com.example.mbti.Req.CompanyInsert;
import com.example.mbti.Req.JobInsert;
import com.example.mbti.Req.PostReq;
import com.example.mbti.Service.JobService;
import com.example.mbti.Service.MbtiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService){
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<Object> findJobs() {
        return new ResponseEntity<>(jobService.findJobs(), HttpStatus.OK);
    }

    @GetMapping("/jobs/{jobId}")
    public ResponseEntity<Object> findDetails(@PathVariable long jobId) {
        return new ResponseEntity<>(jobService.findDetails(jobId), HttpStatus.OK);
    }

    @PostMapping("/job")
    public void saveJob(@RequestBody JobInsert req){
        jobService.saveJob(req);
    }

    @PostMapping("/company")
    public void saveCompany(@RequestBody CompanyInsert req){
        jobService.saveCompany(req);
    }

    @PostMapping("/job/{jobId}/cover-letter")
    public ResponseEntity<Object> saveCoverLetter(@RequestBody PostReq req, @PathVariable long jobId){
        return new ResponseEntity<>(jobService.saveCoverLetter(req, jobId), HttpStatus.OK);
    }

}
