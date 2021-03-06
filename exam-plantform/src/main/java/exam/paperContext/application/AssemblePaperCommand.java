package exam.paperContext.application;

import exam.blankquiz.domain.model.BlankQuiz;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class AssemblePaperCommand {
    private String teacherId;
    private List<BlankQuiz> quizzes;
}