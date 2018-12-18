package kr.co.sunnyvale.shop.repository;

import kr.co.sunnyvale.shop.domain.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Long> {
    @Query("select ic from ItemCategory ic join fetch ic.parent where ic.parent = null")
    public List<ItemCategory> getAllRootItemCategories();
}
