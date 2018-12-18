package kr.co.sunnyvale.shop.service;

import kr.co.sunnyvale.shop.domain.Item;
import kr.co.sunnyvale.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }
}
