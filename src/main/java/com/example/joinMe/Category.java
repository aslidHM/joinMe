package com.example.joinMe;


public class Category {

    public Category(int categoryId, String categoryName){

        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

   private int categoryId;
   private String categoryName;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
