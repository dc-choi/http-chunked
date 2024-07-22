package com.server.chucked.api.member.domain.dto;

import lombok.Builder;

import java.util.List;

public record MemberInternalDto() {
    @Builder
    public record Find(String email) {}
    @Builder
    public record FindAll(List<Find> findList) {}
    @Builder
    public record Create(String email) {}
    @Builder
    public record Update(String email) {}
}
