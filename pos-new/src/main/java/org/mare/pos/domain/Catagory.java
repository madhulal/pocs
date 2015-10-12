package org.mare.pos.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Madhulal M G on 10/10/15.
 */

@Entity
public class Catagory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "notes")
    private String notes;

    @OneToMany
    @JoinTable(name = "category_category", joinColumns = @JoinColumn( name="category_id"),
            inverseJoinColumns = @JoinColumn( name="child_category_id"))
    private Set<Catagory> catagories;

    @OneToMany
    @JoinTable(name = "category_product", joinColumns = @JoinColumn( name="category_id"),
            inverseJoinColumns = @JoinColumn( name="product_id"))
    private Set<Product> products;

    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id", nullable = false)
    private Organization organization;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set<Catagory> getCatagories() {
        return catagories;
    }

    public void setCatagories(Set<Catagory> catagories) {
        this.catagories = catagories;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
