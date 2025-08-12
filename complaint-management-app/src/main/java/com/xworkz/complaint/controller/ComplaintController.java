package com.xworkz.complaint.controller;

import com.xworkz.complaint.dto.ComplaintDTO;
import com.xworkz.complaint.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ComplaintController {
    @Autowired
    private ComplaintService service;

    public ComplaintController(){
        System.out.println("created ComplaintController");
    }

    @GetMapping("redirectToComplaintForm")
    public String redirectToComplaint(){
        System.out.println("redirecting to Complaint");
        return "Complaint";
    }


    @PostMapping("complain")
    public String fileComplaint(ComplaintDTO dto, Model model){
        boolean saved=service.save(dto);
        if(saved){
            System.out.println("data saved");
            model.addAttribute("message","saved successfully");
            List<ComplaintDTO> dtoList=service.getAllComplaints();
            model.addAttribute("dtoList",dtoList);
            return "ListOfComplaints";
        }
        return "Complaint";
    }

    @GetMapping("getAllComplaints")
    public String getAllComplaints(Model model){
        System.out.println("running getAllComplaints in Controller");

        List<ComplaintDTO> dtoList=service.getAllComplaints();
        model.addAttribute("dtoList",dtoList);
        return "ListOfComplaints";
    }

    @GetMapping("backToIndex")
    public String backToIndex(){
        return "index";
    }

}
