package com.example.productservicesst.Exceptions;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class PageNotFound extends RuntimeException{
    private Long id;

    public  PageNotFound(Long id, String message){
        super(message);
        this.id = id;
    }


}
