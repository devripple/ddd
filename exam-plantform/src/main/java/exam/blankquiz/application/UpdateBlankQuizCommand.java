package exam.blankquiz.application;

import exam.blankquiz.domain.model.BlankQuizId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateBlankQuizCommand {
    private BlankQuizId blankQuizId;
    private String quizBankId;
    private String teacherId;
    private String content;
    private String referenceAnswer;
    private int score;
}