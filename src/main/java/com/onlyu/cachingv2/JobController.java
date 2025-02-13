package com.onlyu.cachingv2;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/jobs")
@AllArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping({"", "/"})
    public List<Job> fetch(@RequestParam(name = "id", required = false) String id)
    {
        if (id != null && !id.isEmpty())
            return Collections.singletonList(jobService.fetch(id).orElse(Job.EMPTY_INSTANCE));
        return jobService.fetchAll();
    }

}
