package exam.quizbank.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.util.List;

@Data
@AllArgsConstructor
public class MaintainQuizBankCommand {
    private String teacherId;
    private List<BlankQuiz> blankQuiz;

    @Value
    public static class BlankQuiz {
        private int quizId;
        private int score;
    }
}