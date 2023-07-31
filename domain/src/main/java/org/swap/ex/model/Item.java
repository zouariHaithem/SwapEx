package org.swap.ex.model;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class Item {

    @EqualsAndHashCode.Exclude
    Integer id;
    String title;
    String description;
    String image;
    User owner;

}
