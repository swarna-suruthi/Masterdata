package net.apmoller.athena.microservices.CurrencyProject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.*;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class RoundOff
{
    @Id
    String rounding_off_rule;
    String round_off_rule;
    String created_by;
    String Last_updated_by;
    Date created_date;
    Date Last_updated_date ;

    public void setId(String id) {
    }
}