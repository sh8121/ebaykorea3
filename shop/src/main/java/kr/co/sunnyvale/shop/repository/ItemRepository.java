package kr.co.sunnyvale.shop.repository;

import kr.co.sunnyvale.shop.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
