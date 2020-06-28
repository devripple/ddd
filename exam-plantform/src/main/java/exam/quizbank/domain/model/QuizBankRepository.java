package exam.quizbank.domain.model;

import java.util.List;

public interface QuizBankRepository {
    QuizBank find(QuizBankId quizBankId);

    void save(QuizBank quizBank);

    QuizBankId nextPaperId();

    List<QuizBank> getAll();
}
