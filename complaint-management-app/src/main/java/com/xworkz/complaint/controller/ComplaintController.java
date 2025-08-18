package com.xworkz.complaint.controller;

import com.xworkz.complaint.dto.ComplaintDTO;
import com.xworkz.complaint.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

        System.out.println("all list: "+dtoList);
        return "ListOfComplaints";
    }

    @GetMapping("backToIndex")
    public String backToIndex(){
        return "index";
    }

    @GetMapping("findByID")
    public String findByID(Integer id,Model model){
        System.out.println("running findByID in Controller");
        System.out.println("id to be found: "+id);
        ComplaintDTO dto=service.findByID(id);
        model.addAttribute("dto",dto);
        return "ListOfComplaints";
    }

    @GetMapping("edit")
    public String redirectToEdit(@RequestParam("id") String id,Model model){
        System.out.println("running redirectTo Edit in Controller...");
        ComplaintDTO dto=service.findByID(Integer.valueOf(id));
        model.addAttribute("dto",dto);
        return "UpdateComplaint";
    }

    @PostMapping("updateComplaint")
    public String updateComplaint(ComplaintDTO dto, Model model){
        System.out.println("running updateComplaint in Controller, dto: "+dto);
        String message=service.updateComplaint(dto);
        model.addAttribute("message",message);
        List<ComplaintDTO> dtoList=service.getAllComplaints();
        model.addAttribute("dtoList",dtoList);
        return "ListOfComplaints";
    }

    @GetMapping("delete")
    public String deleteComplaint(@RequestParam("id") Integer id, Model model){
        String message= service.deleteComplaint(id);
        model.addAttribute("message",message);
        List<ComplaintDTO> dtoList=service.getAllComplaints();
        model.addAttribute("dtoList",dtoList);
        return "ListOfComplaints";
    }
}
