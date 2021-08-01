package net.apmoller.athena.microservices.CurrencyProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrencyConversionDto
{
    private String Conversion_Key;
    private int Conversion_factor;
    private boolean status;
    private String created_by;
    Date created_date;
    Date effective_date;
    Date expiry_date;
    String Last_updated_by;
    Date last_updated_time;


}
