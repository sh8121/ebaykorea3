package kr.co.sunnyvale.mvcexam.controller;

import kr.co.sunnyvale.mvcexam.dto.BloodDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BloodTestController {

    @GetMapping("/bloodtest")
    public String bloodTestForm(){
        return "bloodTestForm";
    }

    @PostMapping("/bloodtest")
    public String bloodTest(@ModelAttribute BloodDTO bloodDTO,
                            ModelMap modelMap){


        String msg = null;
        if("A".equals(bloodDTO.getBloodType())){
            msg = "소심하다.";
        }else if("B".equals(bloodDTO.getBloodType())){
            msg = "할말 다한다.";
        }else if("O".equals(bloodDTO.getBloodType())){
            msg = "이순신장군혈액형";
        }else{
            msg = "알 수 없다.";
        }
        bloodDTO.setMsg(msg);

        modelMap.addAttribute("bloodDto", bloodDTO);

        return "bloodTest";
    }
}
