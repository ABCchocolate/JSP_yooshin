package mall.domain;

import lombok.Data;

@Data
public class Color {
	private int color_id;
	private String color_name;
	
	//외래키 저장
	 private int product_id;
}
