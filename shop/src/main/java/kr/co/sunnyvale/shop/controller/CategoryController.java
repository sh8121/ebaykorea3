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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ItemCategoryService itemCategoryService;
    @Autowired
    private ItemService itemService;

    @GetMapping("/{id}")
    public String categoryPage(@AuthUser CustomUserDetails user, @PathVariable(name = "id")long id, ModelMap modelMap){
        ItemCategory category = itemCategoryService.getItemCategory(id);
        List<Item> items = itemService.getAllItemsByItemCategory(id);
        modelMap.addAttribute("welcomeMessage", user.getName() + " 님 안녕하세요.");
        modelMap.addAttribute("category", category);
        modelMap.addAttribute("items", items);
        return "/category/index";
    }
}
