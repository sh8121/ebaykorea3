package kr.co.sunnyvale.shop.repository;

import kr.co.sunnyvale.shop.domain.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Long> {
    @Query("select ic from ItemCategory ic left join fetch ic.parent")
    List<ItemCategory> getAllItemCategories();

    @Query("select ic from ItemCategory ic left join fetch ic.parent where ic.parent is null ")
    List<ItemCategory> getAllRootItemCategories();

    @Query("select ic from ItemCategory ic left join fetch ic.parent left join fetch ic.childItemCategories where ic.id = :id")
    ItemCategory getItemCategoryById(long id);
}
