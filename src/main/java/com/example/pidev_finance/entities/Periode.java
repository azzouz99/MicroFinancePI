package com.example.pidev_finance.entities;

public enum Periode {
    ONE_YEAR(12) , SIX_MONTH(6);
    private final int value;
   Periode(int value){
       this.value=value;
   }

    public int getValue() {
        return value;
    }
}
