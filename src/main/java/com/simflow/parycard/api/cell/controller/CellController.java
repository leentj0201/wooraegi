package com.simflow.parycard.api.cell.controller;


import static com.simflow.parycard.endpoint.CellEndPoint.CELL_CREATE;
import static com.simflow.parycard.endpoint.CellEndPoint.CELL_LIST_ALL;

import com.simflow.parycard.api.cell.dto.CellDto.RequestCreate;
import com.simflow.parycard.api.cell.dto.CellDto.ResponseCell;
import com.simflow.parycard.api.cell.service.CellService;
import com.simflow.parycard.domain.entity.UserContext;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CellController {

    private final CellService cellService;

    /**
     * @return CellDto.ResponsePray
     */
    @PostMapping(CELL_LIST_ALL)
    public List<ResponseCell> retrieveCellListAll() {
        return cellService.retrieveCellListAll();
    }

    /**
     * @param
     *
     * @return CellDto.ResponsePray
     */
    @PostMapping(CELL_CREATE)
    public ResponseCell createCell(@RequestBody RequestCreate requestCreate) {
        var userContext = UserContext.builder().memberId("280c7bee-0f6e-4b71-8254-cc2a75147634").build(); //todo 로그인 구현하여 제거
        return cellService.createCell(requestCreate, userContext);
    }

}
