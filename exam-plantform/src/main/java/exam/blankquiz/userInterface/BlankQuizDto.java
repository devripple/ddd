package exam.blankquiz.userInterface;

import exam.blankquiz.domain.model.BlankQuizId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BlankQuizDto {
    private String uri;

    public static BlankQuizDto from(BlankQuizId blankQuizId) {
        return new BlankQuizDto("exam/blankquiz/" + blankQuizId);
    };
}
