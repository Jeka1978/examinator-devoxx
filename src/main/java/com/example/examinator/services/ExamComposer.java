package com.example.examinator.services;

import com.example.examinator.model.Exam;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */

public interface ExamComposer {
    Exam generateExam(Map<String, Integer> examSpec);
}
