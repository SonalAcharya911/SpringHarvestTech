package com.xworkz.icecream.service;

import com.xworkz.icecream.dto.OrderDTO;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class OrderService {
    private static final Map<String,Double> flavourPriceMap=new HashMap<>();
    private static final List<String> couponList=new ArrayList<>(Arrays.asList("SWT23","ZMT56","DG5JEB"));

    static{
        flavourPriceMap.put("StrawBerry",35.00);
        flavourPriceMap.put("Vanilla",20.00);
        flavourPriceMap.put("Chocolate",45.00);
        flavourPriceMap.put("PineApple",40.00);
        flavourPriceMap.put("BlackCurrant",50.00);
    }

    public double getTotalPrice(OrderDTO orderDTO){
        if(orderDTO!=null){
            System.out.println("running save in OrderService...");
            double total= flavourPriceMap.get(orderDTO.getFlavour())*orderDTO.getQuantity();
            if(flavourPriceMap.containsValue(orderDTO.getFlavour()))
            return total;
        }
        return 0;
    }
}
