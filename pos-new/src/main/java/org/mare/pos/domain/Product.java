package org.mare.pos.domain;

import javax.persistence.*;

/**
 * Created by Madhulal M G on 10/10/15.
 */

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "id")
    private ProductType type;

    @Column(name = "unit")
    private String unit;

    @Column(name = "lastPurchasePrice")
    private String purchasePrice;

    @Column(name = "lastSalePrice")
    private String salePrice;

    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id", nullable = false)
    private Organization organization;


}
