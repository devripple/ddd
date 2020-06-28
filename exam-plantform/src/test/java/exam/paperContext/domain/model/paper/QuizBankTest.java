package exam.paperContext.domain.model.paper;

import exam.quizbank.domain.model.QuizBank;
import exam.quizbank.domain.model.QuizBank.*;
import exam.quizbank.domain.model.QuizBankId;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class QuizBankTest {

    @Test
    public void should_create_quiz_bank_with_new() {
        final QuizBankId quizBankId = new QuizBankId("quizbank-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1");
        final String teacherId = "teacher-6b35fdd8-31de-4af4-9420-3331058260c5";
        final String firstQuizId = "quiz-f500ee0d-3c9f-494a-bc13-993250053194";
        final String secondQuizId = "quiz-29bbb66c-80af-45b3-b593-fc4a358e900e";
        final String thirdQuizId = "quiz-f2bf96e7-a573-4d77-86dd-02bdcce5ff44";
        final String fourthQuizId = "quiz-57dd3849-fa5d-4832-8228-a8e7c8abf944";
        final String fifthQuizId = "quiz-14f7b84b-0d61-479d-b6dc-71984be4d6c9";

        List<BlankQuiz> blankQuizzes = Arrays.asList(
                new BlankQuiz(firstQuizId, 10),
                new BlankQuiz(secondQuizId, 15),
                new BlankQuiz(thirdQuizId, 10),
                new BlankQuiz(fourthQuizId, 15),
                new BlankQuiz(fifthQuizId, 50)
        );

        QuizBank quizBank = QuizBank.maintain(quizBankId, teacherId, blankQuizzes);

        assertThat(quizBank, is(notNullValue()));

        assertThat(quizBank.getQuizBankId(), is(new QuizBankId("quizbank-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1")));
        assertThat(quizBank.getCreateTime(), instanceOf(LocalDateTime.class));
        assertThat(quizBank.get().size(), is(5));
    }
}
