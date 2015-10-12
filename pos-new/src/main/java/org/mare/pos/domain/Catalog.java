package org.mare.pos.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Madhulal M G on 10/10/15.
 */

@Entity
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "notes")
    private String notes;

    @OneToMany
    @JoinTable(name = "catalog_category", joinColumns = @JoinColumn( name="catalog_id"),
            inverseJoinColumns = @JoinColumn( name="category_id"))
    private Set<Catagory> catagories;

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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
