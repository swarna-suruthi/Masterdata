package net.apmoller.athena.microservices.CurrencyProject.services;

import net.apmoller.athena.microservices.CurrencyProject.dto.CurrencyConversionDto;
import net.apmoller.athena.microservices.CurrencyProject.dto.RoundOffDto;
import net.apmoller.athena.microservices.CurrencyProject.repository.RoundOffRepository;
import net.apmoller.athena.microservices.CurrencyProject.util.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RoundOffService
{
    @Autowired
    private RoundOffRepository roundOffRepository;

    public Flux<RoundOffDto> getAllRoundOffDatas()
    {
        return roundOffRepository.findAll()
                .map(AppUtils::roundOffEntityToDto);
    }

    public Mono<RoundOffDto> saveRoundOffData(Mono<RoundOffDto> roundOffDtoMono)
    {
        Mono<RoundOffDto> map3 = roundOffDtoMono.map(AppUtils::roundOffDtoToEntity)
                .flatMap(roundOffRepository::insert)
                .map(AppUtils::roundOffEntityToDto);
        return map3;
    }

    public Mono<RoundOffDto> getRoundOffDataByCode(String id)
    {
        final Mono<RoundOffDto> user3;
        user3 = roundOffRepository.findById(id).map(AppUtils::roundOffEntityToDto);
        return user3;
    }

    public Mono<Void> deleteRoundOffData(String id)
    {
        return roundOffRepository.deleteById(id);
    }

    public Mono<RoundOffDto> updateRoundOffData(Mono<RoundOffDto> roundOffDtoMono, String id)
    {
        return roundOffRepository.findById(id)
                .flatMap(p->roundOffDtoMono.map(AppUtils :: roundOffDtoToEntity).doOnNext(e->e.setId(id)))
                .flatMap(roundOffRepository::save)
                .map(AppUtils::roundOffEntityToDto);
    }
}
