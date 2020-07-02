package exam.blankquiz.domain.model;

import java.util.List;

public interface BlankQuizRepository {
    BlankQuiz find(BlankQuizId blankQuizId);

    void save(BlankQuiz blankQuiz);

    BlankQuizId nextId();

    List<BlankQuiz> getAll();
}
