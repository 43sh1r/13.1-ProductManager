import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Getter
public class Product {
    private int id;
    private int cost;
    private String name;
}
