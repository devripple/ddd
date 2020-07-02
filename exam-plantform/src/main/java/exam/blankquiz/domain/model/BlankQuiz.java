package exam.blankquiz.domain.model;

import exam.blankquiz.domain.shared.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(of = {"blankQuizId"})
public class BlankQuiz implements Entity<BlankQuiz> {
    private BlankQuizId blankQuizId;
    private String quizBankId;
    private String teacherId;
    private String content;
    private String referenceAnswer;
    private int score;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private LocalDateTime deleteTime;
    private boolean isDeleted;

    @Override
    public boolean sameIdentityAs(exam.blankquiz.domain.model.BlankQuiz other) {
        return blankQuizId.sameValueAs(other.getBlankQuizId());
    }
}
