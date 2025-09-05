package com.xworkz.center.controller;

import com.xworkz.center.dto.CenterDto;
import com.xworkz.center.entity.CenterEntity;
import com.xworkz.center.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static jdk.nashorn.internal.objects.NativeArray.forEach;

@Controller
@RequestMapping("/")

public class CenterController {
    @Autowired
    CenterService centerService;

    public CenterController() {
        System.out.println("Running in the CenterController");
    }

    @GetMapping("redirect")
    public String mobileCenterPage() {
        System.out.println("Running in the mobileCenterPage method ");
        return "ApplyForService";
    }

    @PostMapping("apply")
    public String applyHere(CenterDto centerDto, Model model) {
        System.out.println(centerDto);
        System.out.println("Running in the applyHere method in postMapping");
        Boolean check = centerService.saveDetails(centerDto);
        if (check) {
            model.addAttribute("message", "Saved Succesfull");
            return "ApplySuccesfull";

        } else {
            System.out.println("Not Applied");
            return "ApplyForService";
        }

    }

    @GetMapping("getAll")
    public String getllAllData(Model model) {
        System.out.println("Running in getAll Method");
        List<CenterDto> centerDtoList = centerService.getAllData();
        for (CenterDto da : centerDtoList) {
            System.out.println(da);
        }
        model.addAttribute("data", centerDtoList);
        return "datas";
    }

    @PostMapping("updateData")
    public String UpdateData(CenterDto centerDto, Model model) {
        System.out.println("UpdateData method in controller");
        if (centerService.UpdateById(centerDto)) {
            List<CenterDto> data = centerService.getAllData();
            model.addAttribute("Message", "EntireData After Update");
            model.addAttribute("d", data);
        }
        return "datas";

    }

    @GetMapping("edit")
    public String editPage(@RequestParam("id") int ID, Model model) {
        System.out.println("Edit Page");
        CenterDto byId = centerService.getById(ID);
        model.addAttribute("Data", byId);
        return "editform";


    }

    @PostMapping("update")
    public String updatedSave(CenterDto centerDto, Model model) {
        Boolean b = centerService.UpdateById(centerDto);


        List<CenterDto> centerDtoList = centerService.getAllData();

        model.addAttribute("data", centerDtoList);
        return "datas";

    }

    @GetMapping("delete")
    public String deletePage( @RequestParam("id") int id,Model model) {
        System.out.println("Running in the deletePage ");
        Boolean dataAfterDelete=centerService.deleteById(id);
        System.out.println("Check it os comming in delete page");
        System.out.println(dataAfterDelete);
        List<CenterDto> centerDtoList = centerService.getAllData();

        model.addAttribute("data", centerDtoList);
                return "datas";
    }
}
