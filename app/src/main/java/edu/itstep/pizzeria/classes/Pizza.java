package edu.itstep.pizzeria.classes;

import java.io.Serializable;

public class Pizza implements Serializable {
    private String size;
    private String title;
    private int price;
    private String extraIngredients;

    public Pizza() { }

    public Pizza(String size, String title) {
        this.size = size;
        this.title = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getExtraIngredients() {
        return extraIngredients;
    }

    public void setExtraIngredients(String extraIngredients) {
        this.extraIngredients = extraIngredients;
    }

    public void calculatePrice() {
        price = 0;

        switch (size) {
            case PizzaConstants.SMALL_PIZZA:
                price += PizzaConstants.SMALL_PIZZA_COST;
                break;
            case PizzaConstants.MEDIUM_PIZZA:
                price += PizzaConstants.MEDIUM_PIZZA_COST;
                break;
            case PizzaConstants.BIG_PIZZA:
                price += PizzaConstants.BIG_PIZZA_COST;
                break;
        }

        switch (title) {
            case PizzaConstants.MARGHERITA_PIZZA:
                price += PizzaConstants.MARGHERITA_PIZZA_COST;
                break;
            case PizzaConstants.PEPPERONI_PIZZA:
                price += PizzaConstants.PEPPERONI_PIZZA_COST;
                break;
            case PizzaConstants.BBQ_CHICKEN_PIZZA:
                price += PizzaConstants.BBQ_CHICKEN_PIZZA_COST;
                break;
            case PizzaConstants.HAWAIIAN_PIZZA:
                price += PizzaConstants.HAWAIIAN_PIZZA_COST;
                break;
            case PizzaConstants.MEAT_LOVERS_PIZZA:
                price += PizzaConstants.MEAT_LOVERS_PIZZA_COST;
                break;
        }

        int ingredientsAmount = 0;

        if (extraIngredients.length() != 0) {
            ingredientsAmount = extraIngredients.split(", ").length;
        }

        price += PizzaConstants.EXTRA_INGREDIENTS_COST * ingredientsAmount;
    }
}
