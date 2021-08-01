package net.apmoller.athena.microservices.CurrencyProject.models;

import java.util.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "currencyconversion")
public class CurrencyConversion
{
    @Id

    private String Conversion_Key;
    private int Conversion_factor;
    private boolean status;
    private String created_by;
    Date created_date;
    Date effective_date;
    Date expiry_date;
    String Last_updated_by;
    Date last_updated_time;


    public void setId(String id) {
    }
}

