package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int numberOfCoffees = 0;
    int price = 4;

    public void sumbitOrder(View view) {
        int totalPrice = calculatePrice();
        createOrderSummary(totalPrice);
    }

    public void increment(View view) {
        numberOfCoffees = numberOfCoffees + 1;
        display(numberOfCoffees);
    }

    public void decrement(View view) {
        numberOfCoffees = numberOfCoffees - 1;
        display(numberOfCoffees);
    }

    /**
     * This method calculates the total price of the order
     *
     * @totalPrice
     */
    private int calculatePrice() {
        int totalPrice = numberOfCoffees * price;
        return totalPrice;
    }

    /**
     * This method create a sumary of the order
     *
     * @priceMsg
     */
    private String createOrderSummary(int totalPrice) {
        String name = "Mary lee";
        String orderSummary = "Name: " + name + "\n Price = " + totalPrice + "\n Thank you!";
        displayMessage(orderSummary);
        return orderSummary;
    }


    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.oder_summary_textView);
        priceTextView.setText(message);
    }

}
