package exam.blankquiz.application;

import exam.blankquiz.domain.model.BlankQuizId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteBlankQuizCommand {
    private String quizBankId;
    private BlankQuizId blankQuizId;
}