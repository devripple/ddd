package exam.quizbank.userInterface;

import exam.quizbank.domain.model.QuizBankId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuizBankDTO {
    private String uri;

    public static QuizBankDTO from(QuizBankId paperId) {
        return new QuizBankDTO("exam/quizbank/" + paperId);
    };
}
