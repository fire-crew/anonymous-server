package com.makefire.anonymous.rest.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@JsonNaming
public class Response<T>{
    private int code;
    private int count;
    private ZonedDateTime timestamp;
    private String message;
    private T data;

    public Response(int code, T data, String message){
        this.code = code;
        this.data = data;
        this.message = message;
        this.timestamp = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        this.count = makeCount();
    }

    private int makeCount(){
        if(data instanceof List) {
          return ((List<?>)data).size();
        }
        return 1;
    }
}



