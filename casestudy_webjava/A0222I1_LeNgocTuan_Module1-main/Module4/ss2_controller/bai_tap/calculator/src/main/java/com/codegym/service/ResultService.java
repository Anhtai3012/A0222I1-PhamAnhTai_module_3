package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class ResultService implements IGetResult{
    @Override
    public String getResult(Double v1, Double v2, String calculator) {
        if(v1 == null || v2 == null){
            return "Input something";
        }
        switch (calculator){
            case "+":{
                return String.format("Result: %.2f + %.2f = %.3f",v1,v2,v1+v2);
            }
            case "-":{
               return String.format("Result: %.2f + %.2f = %.3f",v1,v2,v1-v2);
            }
            case "*":{
                return String.format("Result: %.2f + %.2f = %.3f",v1,v2,v1*v2);
            }
            default:{
                if(v2 == 0)  return "VALUE 2 MUST NOT 0. ERROR MATH LOGIC";
                return String.format("Result: %.2f + %.2f = %.3f",v1,v2,v1/v2);
            }
        }
    }
}
