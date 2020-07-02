package exam.blankquiz.infrastructure;

import exam.blankquiz.domain.model.BlankQuiz;
import exam.blankquiz.domain.model.BlankQuizRepository;
import exam.blankquiz.domain.model.BlankQuizId;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class MemoryBlankQuizRepository implements BlankQuizRepository {
    private Set<BlankQuiz> blankQuizs = new HashSet<>();

    @Override
    public BlankQuiz find(BlankQuizId blankQuizId) {
        return blankQuizs.stream().filter(paper-> {
            return paper.getBlankQuizId().equals(blankQuizId);
        }).findFirst().orElseThrow(NullPointerException::new);
    }

    @Override
    public void save(BlankQuiz blankQuiz) {
        blankQuizs.add(blankQuiz);
    }

    @Override
    public BlankQuizId nextId() {
        return new BlankQuizId("blankquiz-" + UUID.randomUUID().toString());
    }

    @Override
    public List<BlankQuiz> getAll() {
        return blankQuizs.stream().collect(Collectors.toList());
    }
}
