package com.nguyenkietblog.nkblog.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceResult {
    private Status status = Status.SUCCESS;
    private Object data;

    public enum Status {
        SUCCESS, FAILED;
    }


}
