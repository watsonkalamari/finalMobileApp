package com.example.whatsfordinner.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MeasurementQty {
    @PrimaryKey
    private int mQtyId;
    private int ing_id;
    private String qty_amount;


    public int getmQtyId() {
        return mQtyId;
    }

    public void setmQtyId(int mQtyId) {
        this.mQtyId = mQtyId;
    }

    public String getQty_amount() {
        return qty_amount;
    }

    public void setQty_amount(String qty_amount) {
        this.qty_amount = qty_amount;
    }

    public int getIng_id() {
        return ing_id;
    }

    public void setIng_id(int ing_id) {
        this.ing_id = ing_id;
    }
}
