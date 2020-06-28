package exam.quizbank.application;

import exam.quizbank.domain.model.QuizBank;
import exam.quizbank.domain.model.QuizBankId;
import exam.quizbank.domain.model.QuizBankRepository;
import exam.quizbank.domain.service.BlankQuizClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import exam.quizbank.domain.service.BlankQuizDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class QuizBankApplicationService {
    private QuizBankRepository quizBankRepository;
    private BlankQuizClient blankQuizClient;

    private List<BlankQuizDto> getBlankQuizzesByIds(List<String> blankQuizIds) {
        return blankQuizClient.getBlankQuizzesByIds(blankQuizIds);
    }

    @Autowired
    public QuizBankApplicationService(QuizBankRepository quizBankRepository) {
        this.quizBankRepository = quizBankRepository;
    }

    public QuizBankId maintain(MaintainQuizBankCommand command) {
        List<BlankQuizDto> blankQuizDto = blankQuizFrom(command);
        final String teacherId = command.getTeacherId();
        final QuizBankId paperId = quizBankRepository.nextPaperId();
        final List<QuizBank.BlankQuiz> blankQuizList = blankQuizDto.stream().map(s-> BlankQuizDto.toBlankQuiz(s)).collect(toList());
        final QuizBank quizBank = QuizBank.maintain(paperId, teacherId, blankQuizList);


        return quizBank.getQuizBankId();
    }

    public QuizBank get(QuizBankId quizBankId) {
        return quizBankRepository.find(quizBankId);
    }


    private List<BlankQuizDto> blankQuizFrom(MaintainQuizBankCommand command) {
        return command.getBlankQuiz().stream().map(quiz -> new BlankQuizDto(quiz.getQuizId(),
                quiz.getScore())).collect(toList());
    }
}
