package de.ait.code.product.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequestDto {

    String language;
    String word;
    String example;
    String translate_language;
    String translation;
    String card_group;

}
