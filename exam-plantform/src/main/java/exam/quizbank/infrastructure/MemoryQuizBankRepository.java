package exam.quizbank.infrastructure;

import exam.quizbank.domain.model.QuizBank;
import exam.quizbank.domain.model.QuizBankId;
import exam.quizbank.domain.model.QuizBankRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class MemoryQuizBankRepository implements QuizBankRepository {
    private Set<QuizBank> quizBanks = new HashSet<>();

    @Override
    public QuizBank find(QuizBankId paperId) {
        return quizBanks.stream().filter(paper-> {
            return paper.getQuizBankId().equals(paperId);
        }).findFirst().orElseThrow(NullPointerException::new);
    }

    @Override
    public void save(QuizBank quizBank) {
        quizBanks.add(quizBank);
    }

    @Override
    public QuizBankId nextPaperId() {
        return new QuizBankId("quizbank-" + UUID.randomUUID().toString());
    }

    @Override
    public List<QuizBank> getAll() {
        return quizBanks.stream().collect(Collectors.toList());
    }
}
