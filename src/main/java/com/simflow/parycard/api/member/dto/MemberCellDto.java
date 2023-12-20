package com.simflow.parycard.api.member.dto;

import com.simflow.parycard.api.member.dto.MemberDto.ResponseMember;
import com.simflow.parycard.domain.entity.Member;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MemberCellDto {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class RequestSearch {

        /**
         * 셀 이름
         */
        private String cellName;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ResponseSearch {

        /**
         * 셀 아이디
         */
        private String cellId;

        /**
         * 셀 이름
         */
        private String cellName;

        public ResponseSearch(String cellId, String cellName) {
            this.cellId = cellId;
            this.cellName = cellName;
        }
    }
}
