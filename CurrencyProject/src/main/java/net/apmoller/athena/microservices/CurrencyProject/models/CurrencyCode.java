package net.apmoller.athena.microservices.CurrencyProject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "currencycode")

public class CurrencyCode
{
    @Id
    String currency_code;
    String currency_description;
    int currency_count;
    int conversion_key;
    int rounding_off_point;
    String created_by;
    String Last_updated_by;
    Date created_date;
    Date Last_updated_date ;

    public void setId(String id) {
    }
}
