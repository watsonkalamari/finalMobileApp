package com.example.whatsfordinner.entity;

import androidx.room.ColumnInfo;

public class Address {
    private String street;
    private String state;
    private String city;
    @ColumnInfo(name = "post_code")
    private int postCode;
}
