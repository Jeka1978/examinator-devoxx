package com.example.examinator;

import com.example.examinator.model.CheckedExam;
import com.example.examinator.model.SolvedExam;

/**
 * @author Evgeny Borisov
 */
public class ExamConverter {
    public CheckedExam convert(SolvedExam solvedExam) {
        return CheckedExam.builder().exam(solvedExam.getExam()).mark(80).build();
    }
}
