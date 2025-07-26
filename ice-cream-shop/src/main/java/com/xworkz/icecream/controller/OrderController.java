package com.xworkz.icecream.controller;

import com.xworkz.icecream.dto.OrderDTO;
import com.xworkz.icecream.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class OrderController {
    @Autowired
    OrderService orderService;

    public OrderController(){
        System.out.println("created Controller...");
    }

    public String onOrder(OrderDTO orderDTO, Model model){

        orderService.getTotalPrice(orderDTO);
        model.addAttribute("orderDto",orderDTO);

        return "OrderResult.jsp";
    }

}
