package com.sell.sea.exception;


import com.sell.sea.enums.ResultEnums;

public class SellException extends RuntimeException {
    private Integer code;
   public SellException(ResultEnums resultEnums)
   {
       super(resultEnums.getMessage());
       this.code=resultEnums.getCode();
   }
   public SellException(Integer code, String message)
   {
       super(message);
       this.code=code;
   }

}
