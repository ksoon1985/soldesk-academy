package kr.co.sol.shop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {

    private int no = 0;
    private String stock = null;
    private String price = null;
    private String name = null;
    private String detail = null;
    private String date = null;
    private String image = null;

}
