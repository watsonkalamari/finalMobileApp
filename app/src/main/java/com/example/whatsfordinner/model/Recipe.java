package com.example.whatsfordinner.model;

import java.util.List;

public class Recipe {

    private Integer rid;
    private String name;
    private String ingredient;
    private List<String> ingredientList;
    private String instruction;
    private List<String> instructionList;
    private boolean isSaved;

    public Recipe(){
        isSaved=false;
    }
    public Integer getUid(){
        return rid;
    }
    public void setUid(Integer rid){
        this.rid=rid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
        ingredientList.add(this.ingredient);
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }
}
