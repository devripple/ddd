package exam.quizbank.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import exam.quizbank.domain.shared.Entity;
import exam.quizbank.domain.shared.ValueObject;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@EqualsAndHashCode(of = {"quizBankId"})
public class QuizBank implements Entity<QuizBank> {
    private QuizBankId quizBankId;
    private List<BlankQuiz> blankQuizzes;
    private String teacherId;
    private LocalDateTime createTime;

    private QuizBank(QuizBankId quizBankId, String teacherId, List<BlankQuiz> blankQuizzes) {
        this.quizBankId = quizBankId;
        this.blankQuizzes = blankQuizzes;
        this.teacherId = teacherId;
        createTime = LocalDateTime.now();
    }

    public static QuizBank maintain(QuizBankId quizBankId, String teacherId, List<BlankQuiz> blankQuizzes) {
        return new QuizBank(quizBankId, teacherId, blankQuizzes);
    }


    public Collection<BlankQuiz> get() {
        return Collections.unmodifiableList(blankQuizzes);
    }

    public QuizBankId getQuizBankId() {
        return quizBankId;
    }

    public String teacherId() {
        return teacherId;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    @Override
    public boolean sameIdentityAs(QuizBank other) {
        return quizBankId.sameValueAs(other.getQuizBankId());
    }

    @Getter
    @AllArgsConstructor
    public static class BlankQuiz implements ValueObject<BlankQuiz> {
        private String quizId;
        private int score;

        @Override
        public boolean sameValueAs(BlankQuiz other) {
            return false;
        }
    }
}
