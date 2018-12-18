package kr.co.sunnyvale.shop.controller;

import kr.co.sunnyvale.shop.domain.ItemCategory;
import kr.co.sunnyvale.shop.security.AuthUser;
import kr.co.sunnyvale.shop.security.CustomUserDetails;
import kr.co.sunnyvale.shop.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ItemCategoryService itemCategoryService;

    public String home(@AuthUser CustomUserDetails user, ModelMap modelMap){
        modelMap.addAttribute("welcomeMessage", user.getName() + " 님 안녕하세요.");
        List<ItemCategory> rootCategories = itemCategoryService.getAllRootItemCategories();
        modelMap.addAttribute("rootCategories", rootCategories);
        return "/home/index";
    }
}
