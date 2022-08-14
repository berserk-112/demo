package com.example.elasticSearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author Artur Konczak
 * @author Oliver Gierke
 */
//@Component
public interface ConferenceRepository extends ElasticsearchRepository<Conference, String> {}