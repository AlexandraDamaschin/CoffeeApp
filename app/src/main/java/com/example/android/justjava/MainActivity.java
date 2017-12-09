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

    int numberOfCoffees=0;
    int price=4;
    public void sumbitOrder (View view)
    {
        display(numberOfCoffees);
        displayPrice(numberOfCoffees*price);
    }

    int numberOfCoffeesIncrement= numberOfCoffees;
    public void increment (View view){
         numberOfCoffeesIncrement ++;
        display(numberOfCoffeesIncrement);
    }

    int numberOfCoffeesDecrement= numberOfCoffees;
    public void decrement (View view){
        numberOfCoffeesDecrement --;
        display(numberOfCoffeesDecrement);
    }
    private void display(int number){
        TextView quantityTextView= (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+ number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}
