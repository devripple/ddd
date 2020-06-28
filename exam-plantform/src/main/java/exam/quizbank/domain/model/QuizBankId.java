package exam.quizbank.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import exam.quizbank.domain.shared.ValueObject;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class QuizBankId implements ValueObject<QuizBankId> {
    private String id;

    public String nextId() {
        //TODO Generate ID
        return null;
    }

    @Override
    public boolean sameValueAs(QuizBankId other) {
        return equals(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizBankId paperId = (QuizBankId) o;
        return Objects.equals(id, paperId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
