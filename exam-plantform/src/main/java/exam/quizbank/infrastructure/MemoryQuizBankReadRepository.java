package exam.quizbank.infrastructure;

import exam.quizbank.domain.model.QuizBank;
import org.springframework.stereotype.Component;

@Component
public class MemoryQuizBankReadRepository {
    public QuizBank getByQuizBankId(String quizBankId) {
        return null;
    }
}
