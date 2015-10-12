package org.mare.pos.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Madhulal M G on 10/10/15.
 */

@Entity
@Table(name = "stock_price")
public class StockPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id", nullable = false)
    private Store store;

    @Column(name = "batch", nullable = false)
    private String batch;

    @Column(name = "quantity", nullable = false)
    private long quantity;

    @Column(name="expiry_date")
    private Date expiry;

    @Column(name="price", nullable = false)
    private double price;

    @Column(name="discount")
    private double discount;

}
