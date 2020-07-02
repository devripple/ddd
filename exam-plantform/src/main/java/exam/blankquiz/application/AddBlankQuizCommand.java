package exam.blankquiz.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.util.List;

@Data
@AllArgsConstructor
public class AddBlankQuizCommand {
    private String quizBankId;
    private String teacherId;
    private String content;
    private String referenceAnswer;
    private int score;
}