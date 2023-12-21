package com.simflow.parycard.api.member.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MemberPrayDto {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class RequestSearch {

        /**
         * 기도 제목
         */
        private String prayTitle;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ResponseSearch {

        /**
         * 기도 제목
         */
        private String prayTitle;

        /**
         * 기도 내용
         */
        private String prayContent;

        public ResponseSearch(String prayTitle, String prayContent) {
            this.prayTitle = prayTitle;
            this.prayContent = prayContent;
        }
    }
}
