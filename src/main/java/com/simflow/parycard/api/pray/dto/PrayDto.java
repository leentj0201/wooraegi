package com.simflow.parycard.api.pray.dto;

import com.simflow.parycard.domain.entity.Pray;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class PrayDto {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class RequestPrayList {

        /**
         * 멤버 아이디
         */
        private String memberId;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class ResponsePray {

        /**
         * 기도 아이디
         */
        private String prayId;

        /**
         * 멤버 아이디
         */
        private String memberId;

        /**
         * 기도 제목
         */
        private String prayTitle;

        /**
         * 기도 내용
         */
        private String prayContent;

        /**
         * 오픈 여부
         */
        private Boolean isOpened;

        public static ResponsePray of(Pray pray) {
            return ResponsePray.builder()
                .prayId(pray.getPrayId())
                .memberId(pray.getMemberId())
                .prayTitle(pray.getPrayTitle())
                .prayContent(pray.getPrayContent())
                .isOpened(pray.getIsOpened())
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
         * 기도 제목
         */
        private String prayTitle;

        /**
         * 기도 내용
         */
        private String prayContent;

        /**
         * 오픈 여부
         */
        private Boolean isOpened;

        public static Pray toEntity(RequestCreate requestCreate) {
            return Pray.builder()
                .prayTitle(requestCreate.getPrayTitle())
                .prayContent(requestCreate.getPrayContent())
                .isOpened(requestCreate.getIsOpened())
                .build();
        }
    }
}
