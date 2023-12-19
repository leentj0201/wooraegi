package com.simflow.parycard.api.cell.dto;

import com.simflow.parycard.domain.entity.Cell;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CellDto {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class RequestCellList {

        /**
         * 그룹 이름
         */
        private String cellName;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class ResponseCell {

        /**
         * 셀 아이디
         */
        private String cellId;

        /**
         * 셀 제목
         */
        private String cellName;

        /**
         * 셀 설명
         */
        private String cellDescription;

        /**
         * 공개 여부
         */
        private Boolean isPublic;

        /**
         * 사용 여부
         */
        private Boolean isUsed;

        public static ResponseCell of(Cell cell) {
            return ResponseCell.builder()
                .cellId(cell.getCellId())
                .cellName(cell.getCellName())
                .cellDescription(cell.getCellDescription())
                .isPublic(cell.getIsPublic())
                .isUsed(cell.getIsUsed())
                .build();
        }
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class RequestCreate {

        /**
         * 그룹 이름
         */
        private String cellName;

        /**
         * 셀 설명
         */
        private String cellDescription;

        /**
         * 공개 여부
         */
        private Boolean isPublic;

        /**
         * 사용 여부
         */
        private Boolean isUsed;

        public static Cell toEntity(RequestCreate requestCreate) {
            return Cell.builder()
                .cellName(requestCreate.getCellName())
                .cellDescription(requestCreate.getCellDescription())
                .isPublic(requestCreate.getIsPublic())
                .isUsed(requestCreate.getIsUsed())
                .build();
        }
    }
}
