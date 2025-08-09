package com.xworkz.exam.controller;

import com.xworkz.exam.dto.StudentDTO;
import com.xworkz.exam.service.EmailSender;
import com.xworkz.exam.service.EmailSenderImpl;
import lombok.RequiredArgsConstructor;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private EmailSender emailSender;

    public StudentController(){
        System.out.println("created StudentController");

    }

    @RequestMapping("/register")
    public String onRegister(StudentDTO studentDTO, Model model) throws IOException {
        System.out.println(studentDTO);

        MultipartFile multipartfile=studentDTO.getMultipartFile();
        System.out.println(multipartfile);

        byte[] bytes = multipartfile.getBytes();
        System.out.println(bytes);

        Path path = Paths.get("C:\\Users\\sonal\\Desktop\\multipartFiles\\"+"_"+studentDTO.getName()+System.currentTimeMillis());
        Files.write(path,bytes);

        String fileName = path.getFileName().toString();
//        studentDTO.setProfile(fileName);
        System.out.println("fileName============="+fileName);

        emailSender.mailSend("vidya.karma@gmail.com","1234",studentDTO);
        System.out.println("email sent");
        model.addAttribute("file",fileName);
        model.addAttribute("dto",studentDTO);
        return "/success.jsp";
    }

    @GetMapping("/download")
    public void download(@RequestParam("profile") String name,HttpServletResponse response) throws IOException {
        response.setContentType("image/jpg");
        File file=new File("C:\\Users\\sonal\\Desktop\\multipartFiles\\"+"_"+name);
        System.out.println(file);
        InputStream in=new BufferedInputStream(new FileInputStream(file));
        ServletOutputStream out=response.getOutputStream();
        IOUtils.copy(in,out);
        response.flushBuffer();
    }

    @RequestMapping("/sendMail")
    public String sendMail(StudentDTO dto){
        emailSender.mailSend("krishnavenin8192@gmail.com","1234",dto);
        System.out.println("email sent");
        return "/success.jsp";
    }

}
