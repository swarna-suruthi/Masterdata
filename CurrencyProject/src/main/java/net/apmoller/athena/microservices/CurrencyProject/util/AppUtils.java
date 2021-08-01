package net.apmoller.athena.microservices.CurrencyProject.util;

import net.apmoller.athena.microservices.CurrencyProject.dto.CurrencyCodeDto;
import net.apmoller.athena.microservices.CurrencyProject.dto.CurrencyConversionDto;
import net.apmoller.athena.microservices.CurrencyProject.dto.RoundOffDto;
import net.apmoller.athena.microservices.CurrencyProject.models.CurrencyCode;
import net.apmoller.athena.microservices.CurrencyProject.models.CurrencyConversion;
import net.apmoller.athena.microservices.CurrencyProject.models.RoundOff;
import org.springframework.beans.BeanUtils;

public class AppUtils
{
    public static CurrencyCodeDto currencyCodeEntityToDto(CurrencyCode currencyCode)
    {
        CurrencyCodeDto currencyCodeDto=new CurrencyCodeDto();
        BeanUtils.copyProperties(currencyCode,currencyCodeDto); // Source,Destination ,Copying product components to productDto
        return currencyCodeDto;
    }
    public static CurrencyCode currencyCodeDtoToEntity(CurrencyCodeDto currencyCodeDto)
    {
        CurrencyCode currencyCode = new CurrencyCode();
        BeanUtils.copyProperties(currencyCodeDto,currencyCode);
        return currencyCode;
    }

    public static CurrencyConversionDto currencyConversionEntityToDto(CurrencyConversion currencyConversion)
    {
        CurrencyConversionDto currencyConversionDto=new CurrencyConversionDto();
        BeanUtils.copyProperties(currencyConversion,currencyConversionDto); // Source,Destination ,Copying product components to productDto
        return currencyConversionDto;
    }
    public static CurrencyConversion currencyConversionDtoToEntity(CurrencyConversionDto currencyConversionDto)
    {
        CurrencyConversion currencyConversion = new CurrencyConversion();
        BeanUtils.copyProperties(currencyConversionDto,currencyConversion);
        return currencyConversion;
    }

    public static RoundOffDto roundOffEntityToDto(RoundOff roundOff)
    {
        RoundOffDto roundOffDto =new RoundOffDto();
        BeanUtils.copyProperties(roundOff,roundOffDto); // Source,Destination ,Copying product components to productDto
        return roundOffDto;
    }
    public static RoundOff roundOffDtoToEntity(RoundOffDto roundOffDto)
    {
        RoundOff roundOff= new RoundOff();
        BeanUtils.copyProperties(roundOffDto,roundOff);
        return roundOff;
    }
}

