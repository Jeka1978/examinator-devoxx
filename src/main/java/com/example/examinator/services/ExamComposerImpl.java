package com.example.examinator.services;

import com.example.examinator.model.Exam;
import com.example.examinator.model.Exercise;
import com.example.examinator.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * @author Evgeny Borisov
 */
@Service
public class ExamComposerImpl implements ExamComposer {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${exam.title}")
    private String title;


    private Map<String, String> id2Url = new HashMap<>();

    public ExamComposerImpl() {
        id2Url.put("math", "8080");
    }

    @Override
    public Exam generateExam(Map<String, Integer> examSpec) {
        List<Section> sections = examSpec.entrySet().stream()
                .map(entry -> {
                    String url = "http://localhost:" + id2Url.get(entry.getKey()) + "/exercises/" + entry.getValue();
                    Exercise[] exercises = restTemplate.getForObject(url, Exercise[].class);
                    return Section.builder().exercises(asList(exercises)).title(entry.getKey()).build();
                }).collect(toList());

        return Exam.builder().sections(sections).title(title).build();
    }
}







