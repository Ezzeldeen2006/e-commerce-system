import java.time.LocalDate;

public interface IsExpirable {
    LocalDate getExpirationDate();

    default boolean isExpired() {
        return LocalDate.now().isAfter(getExpirationDate());
    }
}
