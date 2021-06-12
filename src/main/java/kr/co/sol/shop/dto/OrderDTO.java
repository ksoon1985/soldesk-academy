package kr.co.sol.shop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDTO {

    private String no = null;
    private String product_no = null;
    private int quantity = 0;
    private String date = null;
    private String state = null;
    private String id = null;

}
