package mall.domain;

import lombok.Data;

@Data
public class ProductColor {
    private int product_color_id; // PK
    private Product product;
    private Color color;
}
