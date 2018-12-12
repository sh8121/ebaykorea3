package kr.co.sunnyvale.shop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ordered_item")
@Getter
@Setter
public class OrderedItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int orderPrice;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_info_id")
    private OrderInfo orderInfo;

    @ManyToOne
    @JoinColumn(name = "item")
    private Item product;
}