package za.co.shilton.entity;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String sbsaIdentifierId;
    private String name;

    @OneToOne
    private EnablementPartner primaryPartner;

    @OneToOne
    private EnablementPartner secondaryPartner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}