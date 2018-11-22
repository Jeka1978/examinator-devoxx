package com.example.examinator.controllers;

import com.example.examinator.model.Exam;
import com.example.examinator.services.ExamComposer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */
@RestController
@RequiredArgsConstructor
public class ExaminatorController {
    private final ExamComposer examComposer;

    @PostMapping("/exam")
    public Exam getExam(@RequestBody Map<String, Integer> examSpec) {
        return examComposer.generateExam(examSpec);
    }

}
