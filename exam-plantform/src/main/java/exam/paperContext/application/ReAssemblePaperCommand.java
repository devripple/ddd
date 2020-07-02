package exam.paperContext.application;

import exam.blankquiz.domain.model.BlankQuiz;
import exam.paperContext.domain.model.paper.PaperId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ReAssemblePaperCommand {
    private PaperId paperId;
    private String teacherId;
    private List<BlankQuiz> quizzes;
}