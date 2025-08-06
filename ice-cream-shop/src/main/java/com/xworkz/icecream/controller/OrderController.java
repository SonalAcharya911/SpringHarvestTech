package com.xworkz.icecream.controller;

import com.xworkz.icecream.dto.OrderDTO;
import com.xworkz.icecream.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/")
public class OrderController {
    @Autowired
    OrderService orderService;

    public OrderController(){
        System.out.println("created Controller...");
    }

    @RequestMapping("order")
    public String onOrder(@Validated OrderDTO orderDTO, Model model, BindingResult bindingResult) throws IOException {

        System.out.println("orderDTO: "+orderDTO);
        byte[] bytes = orderDTO.getMultipartFile().getBytes();

        Path path = Paths.get("C:\\Users\\sonal\\Desktop\\multipartFiles\\"+orderDTO.getName()+System.currentTimeMillis());
        Files.write(path,bytes);

        System.out.println(bindingResult.hasErrors());

        if(bindingResult.hasErrors()){
            System.out.println("has errors");
            model.addAttribute("error","error occured");
            model.addAttribute("orderDto",orderDTO);
            bindingResult.getAllErrors().forEach(System.out::println);
            return "Order";
        }
        else{
            double total=orderService.getTotalPrice(orderDTO);
            model.addAttribute("orderDto",orderDTO);
            model.addAttribute("total",total);
            return "OrderResult";
        }
    }

    @PostMapping("reg")
    public String registerForm(OrderDTO orderDTO, Model model) throws IOException {
        byte[] bytes = orderDTO.getMultipartFile().getBytes();

        Path path = Paths.get("C:\\commons\\"+orderDTO.getName()+System.currentTimeMillis());
        Files.write(path,bytes);

        return "OrderSucces";

    }
}
