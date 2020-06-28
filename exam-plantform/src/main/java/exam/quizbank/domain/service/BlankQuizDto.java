package exam.quizbank.domain.service;

import exam.quizbank.domain.model.QuizBank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BlankQuizDto {
    private Integer quizId;
    private int score;

    public static QuizBank.BlankQuiz toBlankQuiz(BlankQuizDto blankQuizDto) {
        // TODO map BlankQuizDto to BlankQuiz
        return null;
    }
}
