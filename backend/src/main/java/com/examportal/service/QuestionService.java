package com.examportal.service;

import java.util.List; // Ensure this is the correct package for the Question class

import com.examportal.model.Question;

public interface QuestionService {
    Question createQuestion(Question question);
    Question updateQuestion(Long id, Question question);
    void deleteQuestion(Long id);
    Question getQuestionById(Long id);
    List<Question> getAllQuestions();
}
