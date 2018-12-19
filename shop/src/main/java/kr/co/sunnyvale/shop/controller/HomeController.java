package kr.co.sunnyvale.shop.controller;

import kr.co.sunnyvale.shop.domain.Item;
import kr.co.sunnyvale.shop.domain.ItemCategory;
import kr.co.sunnyvale.shop.security.AuthUser;
import kr.co.sunnyvale.shop.security.CustomUserDetails;
import kr.co.sunnyvale.shop.service.ItemCategoryService;
import kr.co.sunnyvale.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ItemCategoryService itemCategoryService;
    @Autowired
    private ItemService itemService;

    @GetMapping()
    public String homePage(@AuthUser CustomUserDetails user, ModelMap modelMap){
        if(user == null){
            return "redirect:/members/login";
        }
        modelMap.addAttribute("welcomeMessage", user.getName() + " 님 안녕하세요.");
        List<ItemCategory> rootCategories = itemCategoryService.getAllRootItemCategories();
        List<Item> items = itemService.getAllItems();
        modelMap.addAttribute("rootCategories", rootCategories);
        modelMap.addAttribute("items", items);
        return "/home/index";
    }
}