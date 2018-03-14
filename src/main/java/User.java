import lombok.*;

@AllArgsConstructor
@ToString(of = "id")
@EqualsAndHashCode
@Getter
@Setter
public class User {
    private final Long id;
    private String email;
}
