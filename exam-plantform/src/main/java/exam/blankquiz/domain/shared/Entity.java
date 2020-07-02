package exam.blankquiz.domain.shared;

public interface Entity<T> {
    boolean sameIdentityAs(T other);
}
