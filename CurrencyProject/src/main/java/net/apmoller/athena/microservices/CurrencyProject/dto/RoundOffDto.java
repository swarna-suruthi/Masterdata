package net.apmoller.athena.microservices.CurrencyProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoundOffDto
{
    String rounding_off_rule;
    String round_off_rule;
    String created_by;
    String Last_updated_by;
    Date created_date;
    Date Last_updated_date ;
}

