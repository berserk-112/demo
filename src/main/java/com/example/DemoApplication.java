package com.example;

import com.example.elasticSearch.Conference;
import com.example.elasticSearch.ConferenceRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Autowired
    ElasticsearchOperations operations;
    @Autowired
    ConferenceRepository repository;

    @PreDestroy
    public void deleteIndex() {
        operations.indexOps(Conference.class).delete();
    }

    @PostConstruct
    public void insertDataSample() throws IOException {

        operations.indexOps(Conference.class).refresh();

        // Save data sample

        var documents = Arrays.asList(
                Conference.builder().date("2014-11-06").name("Spring eXchange 2014 - London")
                        .keywords(Arrays.asList("java", "spring")).location(new GeoPoint(51.500152D, -0.126236D)).build(), //
                Conference.builder().date("2014-12-07").name("Scala eXchange 2014 - London")
                        .keywords(Arrays.asList("scala", "play", "java")).location(new GeoPoint(51.500152D, -0.126236D)).build(), //
                Conference.builder().date("2014-11-20").name("Elasticsearch 2014 - Berlin")
                        .keywords(Arrays.asList("java", "elasticsearch", "kibana")).location(new GeoPoint(52.5234051D, 13.4113999))
                        .build(), //
                Conference.builder().date("2014-11-12").name("AWS London 2014").keywords(Arrays.asList("cloud", "aws"))
                        .location(new GeoPoint(51.500152D, -0.126236D)).build(), //
                Conference.builder().date("2014-10-04").name("JDD14 - Cracow").keywords(Arrays.asList("java", "spring"))
                        .location(new GeoPoint(50.0646501D, 19.9449799)).build());

        repository.saveAll(documents);
    }
}

