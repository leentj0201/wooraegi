package com.simflow.parycard.api.pray.controller;


import static com.simflow.parycard.endpoint.PrayEndPoint.PRAY_CREATE;
import static com.simflow.parycard.endpoint.PrayEndPoint.PRAY_LIST;

import com.simflow.parycard.domain.entity.UserContext;
import com.simflow.parycard.api.pray.dto.PrayDto;
import com.simflow.parycard.api.pray.service.PrayService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PrayController {

    private final PrayService prayService;

    /**
     * @return PrayDto.ResponsePray
     */
    @PostMapping(PRAY_LIST)
    public List<PrayDto.ResponsePray> retrievePrayListAll() {
        return prayService.retrievePrayListAll();
    }

    /**
     * @param
     *
     * @return PrayDto.ResponsePray
     */
    @PostMapping(PRAY_CREATE)
    public PrayDto.ResponsePray saveMember(@RequestBody PrayDto.RequestCreate requestCreate) {
        var userContext = UserContext.builder().memberId("280c7bee-0f6e-4b71-8254-cc2a75147634").build(); //todo 로그인 구현하여 제거
        return prayService.createPray(requestCreate, userContext);
    }

}
