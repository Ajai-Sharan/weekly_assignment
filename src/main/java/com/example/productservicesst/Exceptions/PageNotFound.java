package com.example.productservicesst.Exceptions;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class PageNotFound extends RuntimeException{
    private Long id1;

    public  PageNotFound(Long id, String message){
        super(message);
        this.id1 = id;
    }


}
