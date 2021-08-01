package net.apmoller.athena.microservices.CurrencyProject.services;

import net.apmoller.athena.microservices.CurrencyProject.dto.CurrencyCodeDto;
import net.apmoller.athena.microservices.CurrencyProject.dto.CurrencyConversionDto;
import net.apmoller.athena.microservices.CurrencyProject.models.CurrencyConversion;
import net.apmoller.athena.microservices.CurrencyProject.repository.CurrencyCodeRepository;
import net.apmoller.athena.microservices.CurrencyProject.repository.CurrencyConversionRepository;
import net.apmoller.athena.microservices.CurrencyProject.util.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CurrencyConversionService
{
    @Autowired
    private CurrencyConversionRepository currencyConversionRepository;
    private CurrencyConversion currencyConversion;

    //GET ALL CURRENCY CONVERSION DATAS
    public Flux<CurrencyConversionDto> getAllCurrencyDatas()
    {
        return currencyConversionRepository.findAll()
                .map(AppUtils::currencyConversionEntityToDto);
    }

    //INSERT CURRENCY CONVERSION DATA
    public Mono<CurrencyConversionDto> saveCurrencyData(Mono<CurrencyConversionDto> currencyConversionDtoMono)
    {
        Mono<CurrencyConversionDto> map1 = currencyConversionDtoMono.map(AppUtils::currencyConversionDtoToEntity)
                .flatMap(currencyConversionRepository::insert)
                .map(AppUtils::currencyConversionEntityToDto);
        return map1;
    }

    //GET CURRENCY CONVERSION DATA BY ID
    public Mono<CurrencyConversionDto> getCurrencyDataByCode(String id)
    {
        final Mono<CurrencyConversionDto> user1;
        user1 = currencyConversionRepository.findById(id).map(AppUtils::currencyConversionEntityToDto);
        return user1;
    }

    //DELETE CURRENCY CONVERSION DATA BY ID
    public Mono<Void> deleteCurrencyData(String id)
    {
        return currencyConversionRepository.deleteById(id);
    }

    //UPDATE CURRENCY CONVERSION DATA BY ID
    public Mono<CurrencyConversionDto> updateCurrencyData(Mono<CurrencyConversionDto> currencyConversionDtoMono, String id)
    {
        return currencyConversionRepository.findById(id)
                .flatMap(p->currencyConversionDtoMono.map(AppUtils :: currencyConversionDtoToEntity).doOnNext(e->e.setId(id)))
                .flatMap(currencyConversionRepository::save)
                .map(AppUtils::currencyConversionEntityToDto);
    }


}
