package kr.co.sunnyvale.shop.service;

import kr.co.sunnyvale.shop.domain.ItemCategory;
import kr.co.sunnyvale.shop.repository.ItemCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemCategoryService {
    private final ItemCategoryRepository itemCategoryRepository;

    @Transactional(readOnly = true)
    public List<ItemCategory> getAllRootItemCategories(){
        return itemCategoryRepository.getAllRootItemCategories();
    }

    @Transactional(readOnly = true)
    public List<ItemCategory> getAllItemCategories(){
        return itemCategoryRepository.findAll();
    }
}
