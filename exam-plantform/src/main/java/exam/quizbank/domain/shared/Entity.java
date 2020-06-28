package exam.quizbank.domain.shared;

public interface Entity<T> {
    boolean sameIdentityAs(T other);
}
