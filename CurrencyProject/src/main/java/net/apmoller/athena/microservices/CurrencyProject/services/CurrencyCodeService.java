package net.apmoller.athena.microservices.CurrencyProject.services;

import net.apmoller.athena.microservices.CurrencyProject.dto.CurrencyCodeDto;

import net.apmoller.athena.microservices.CurrencyProject.repository.CurrencyCodeRepository;
import net.apmoller.athena.microservices.CurrencyProject.util.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CurrencyCodeService
{
    @Autowired
    private CurrencyCodeRepository currencyCodeRepository;

    //GET ALL CURRENCY CODE DATAS
    public Flux<CurrencyCodeDto> getAllCurrencyCodeDatas()
    {
        return currencyCodeRepository.findAll()
                .map(AppUtils::currencyCodeEntityToDto);
    }

    //INSERT CURRENCY CODE DATA
    public Mono<CurrencyCodeDto> saveCurrencyCodeData(Mono<CurrencyCodeDto> currencyCodeDtoMono)
    {
        Mono<CurrencyCodeDto> map2 = currencyCodeDtoMono.map(AppUtils::currencyCodeDtoToEntity)
                .flatMap(currencyCodeRepository::insert)
                .map(AppUtils::currencyCodeEntityToDto);
        return map2;
    }

    //GET CURRENCY CODE DATA BY ID
    public Mono<CurrencyCodeDto> getCurrencyCodeDataByCode(String id)
    {
        final Mono<CurrencyCodeDto> user2;
        user2 = currencyCodeRepository.findById(id).map(AppUtils::currencyCodeEntityToDto);
        return user2;
    }

    //DELETE CURRENCY CODE DATA BY ID
    public Mono<Void> deleteCurrencyCodeData(String id)
    {
        return currencyCodeRepository.deleteById(id);
    }

    //UPDATE CURRENCY CODE DATA BY ID
    public Mono<CurrencyCodeDto> updateCurrencyCodeData(Mono<CurrencyCodeDto> currencyCodeDtoMono, String id)
    {
        return currencyCodeRepository.findById(id)
                .flatMap(p->currencyCodeDtoMono.map(AppUtils :: currencyCodeDtoToEntity).doOnNext(e->e.setId(id)))
                .flatMap(currencyCodeRepository::save)
                .map(AppUtils::currencyCodeEntityToDto);
    }
}
