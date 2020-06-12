package za.co.shilton.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EnablementPartner {

    @Id
    private int id;

    private Boolean status;
    private String name;
}
