package com.xworkz.icecream.runner;

import com.xworkz.icecream.dto.OrderDTO;
import com.xworkz.icecream.excel.ReadIceCreamFile;

import java.util.Collection;

public class ReadIceCreamRunner {
    public static void main(String[] args) {
        Collection<OrderDTO> orderDTOS=ReadIceCreamFile.readFileData("ice_cream_orders.xlsx");
        orderDTOS.stream().forEach(System.out::println);
    }
}
