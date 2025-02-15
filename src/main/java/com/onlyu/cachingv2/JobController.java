package com.onlyu.cachingv2;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/jobs")
@AllArgsConstructor
public class JobController {

    private final JobService jobService;

    @Cacheable("jobs")
    @GetMapping({"", "/"})
    public List<Job> fetch(@RequestParam(name = "id", required = false) String id)
    {
        log.info("Fetching jobs");
        if (id != null && !id.isEmpty())
            return Collections.singletonList(jobService.fetch(id).orElse(Job.EMPTY_INSTANCE));
        log.info("Fetching all jobs...");
        List<Job> jobs = jobService.fetchAll();
        log.info("Fetched {} jobs.", jobs.size());
        return jobs;
    }

}
