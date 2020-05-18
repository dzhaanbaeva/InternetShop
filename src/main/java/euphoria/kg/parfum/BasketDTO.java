package euphoria.kg.parfum;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class BasketDTO {
    @Min(1)
    private String qty;
    private String product_id;
}
