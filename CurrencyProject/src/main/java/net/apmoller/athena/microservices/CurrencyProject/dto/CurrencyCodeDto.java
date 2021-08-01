package net.apmoller.athena.microservices.CurrencyProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrencyCodeDto
{
    String currency_code;
    String currency_description;
    int currency_count;
    int conversion_key;
    int rounding_off_point;
    String created_by;
    String Last_updated_by;
    Date created_date;
    Date Last_updated_date ;
}