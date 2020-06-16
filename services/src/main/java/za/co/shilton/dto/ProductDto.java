package za.co.shilton.dto;

import lombok.Builder;

@Builder
public class ProductDto {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
