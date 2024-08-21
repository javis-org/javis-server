package com.javis.aplication.service;

import com.javis.aplication.dto.request.AnswerRequestDto;
import com.javis.aplication.dto.request.QnARequestDto;
import com.javis.aplication.dto.request.QuestionRequestDto;
import com.javis.aplication.dto.response.QnAResponseDto;
import com.javis.aplication.entity.AnswerEntity;
import com.javis.aplication.entity.QuestionEntity;
import com.javis.aplication.entity.QuestionWithAnswer;
import com.javis.aplication.repository.AnswerRepository;
import com.javis.aplication.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QnAService {

    private final QuestionRepository questionRepository;

    private final AnswerRepository answerRepository;

    @Transactional
    public int create(QnARequestDto qnARequestDto, Long jobPostindId){
        QuestionEntity questionRequestDto = questionRepository.save(QuestionRequestDto.from(qnARequestDto).toQuestionEntity(jobPostindId));
        answerRepository.save(AnswerRequestDto.from(qnARequestDto).toAnswerEntity(questionRequestDto));
        return 1;
    }

    public List<QuestionWithAnswer> getQuestionWithAnswer(Long jobPostingId){
        return questionRepository.findAllWithAnswer(jobPostingId);
    }
}
