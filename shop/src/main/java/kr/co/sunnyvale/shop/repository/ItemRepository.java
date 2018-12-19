package kr.co.sunnyvale.shop.repository;

import kr.co.sunnyvale.shop.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("select i from Item i")
    List<Item> getAllItems();

    @Query("select i from Item i join fetch i.itemCategory where i.itemCategory.id = :itemCategoryId")
    List<Item> getAllItemsByItemCategory(long itemCategoryId);
}
