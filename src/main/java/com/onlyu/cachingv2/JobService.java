package com.onlyu.cachingv2;

import java.util.List;
import java.util.Optional;

public interface JobService {

    Optional<Job> fetch(String id);
    List<Job> fetchAll();

}
