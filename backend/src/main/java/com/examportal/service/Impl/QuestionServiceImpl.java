package com.examportal.service.Impl;

import com.examportal.model.Question;
import com.examportal.repository.QuestionRepository;
import com.examportal.service.QuestionService;
import com.examportal.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Long id, Question question) {
        Question existing = questionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Question not found with id: " + id));

        existing.setText(question.getText());
        existing.setCategory(question.getCategory());
        existing.setDifficulty(question.getDifficulty());
        existing.setCorrectAnswer(question.getCorrectAnswer());
        existing.setOptions(question.getOptions());

        return questionRepository.save(existing);
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Question not found with id: " + id));
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}
