package com.xworkz.tracker.controller;

import com.xworkz.tracker.dto.ItemDTO;
import com.xworkz.tracker.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TrackerController {

    @Autowired
    private ItemService service;
    public TrackerController(){
        System.out.println("created TrackerController...");
    }

    @GetMapping("redirectToLostAndFound")
    public String redirectToLostAndFound(){
        System.out.println("redirecting to item lostAndFound");
        return "lostAndFound";
    }

    @PostMapping("onSubmit")
    public String onSubmit(ItemDTO dto, Model model){

        System.out.println(dto);
        if(dto!=null){

            boolean valid=service.save(dto);
            if(valid){

                System.out.println("Controller: "+dto);
                model.addAttribute("success","saved successfully");
                System.out.println("data saved into database");
                List<ItemDTO> dtoList=service.getAllItems();
                System.out.println("Dto list in Controller: "+dtoList);
                model.addAttribute("dtoList",dtoList);

                return "ListOfItems";
            }
            else{
                System.out.println("validation gone wrong");
                model.addAttribute("error","data invalid...check console");
            }
        }
        model.addAttribute("dto",dto);
        return "lostAndFound";
    }

    @GetMapping("getAllItems")
    public String getAllItems(Model model){
        List<ItemDTO> dtoList=service.getAllItems();
        System.out.println("Dto list in Controller: "+dtoList);
        model.addAttribute("dtoList",dtoList);

        return "ListOfItems";
    }


    @GetMapping("backToIndex")
    public String backToIndex(){
        return "index";
    }

    @GetMapping("findByID")
    public String findByID(Integer id,Model model){
        System.out.println("running findByID in Controller");
        if(id!=null){
            System.out.println("id not null");
            ItemDTO dto=service.findByID(id);
            System.out.println("dto: "+dto);
            model.addAttribute("dto",dto);
        }
        return "ListOfItems";
    }

    @GetMapping("redirectToUpdate")
    public String redirectToUpdate(@RequestParam("id") String id, Model model){
        System.out.println("running redirectToUpdate in Controller..., id="+id);
        ItemDTO dto=service.findByID(Integer.valueOf(id));
        System.out.println("dto: "+dto);
        model.addAttribute("dto",dto);
        return "UpdateItemInfo";
    }

    @PostMapping("update")
    public String updateItem(ItemDTO dto, Model model){
        System.out.println("running updateItem in Controller");
        String message=service.updateItem(dto);
        model.addAttribute("message",message);
        List<ItemDTO> dtoList=service.getAllItems();
        model.addAttribute("dtoList",dtoList);

        return "ListOfItems";
    }

    @GetMapping("deleteItem")
    public String deleteItem(@RequestParam("id") Integer id, Model model){
        System.out.println("running deleteItem in Controller, id="+id);
        String message=service.deleteItem(id);
        model.addAttribute("message",message);
        List<ItemDTO> dtoList=service.getAllItems();
        model.addAttribute("dtoList",dtoList);

        return "ListOfItems";
    }
}
