package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
// global variables
    int numberOfCoffees = 0;
    int price = 4;

    /**
     * This method will be called on submitOrder button
     */
    public void sumbitOrder(View view) {
//        check whippedCream box
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream);
        boolean hasWhippedCream = whippedCream.isChecked();
//        check chocolate box
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate);
        boolean hasChocolate = chocolate.isChecked();
        //take name input from EditText view and transform it to string
        EditText name = (EditText) findViewById(R.id.customer_name);
        String customerName= name.getText().toString();
//        for testing if checkbox is working
//        Log.v("MainActivity", "Has whipped cream " +hasWhippedCream);
        int totalPrice = calculatePrice();
        createOrderSummary(totalPrice, hasWhippedCream, hasChocolate, customerName);
    }

    /**
     * This method increment numberOfCoffees
     */
    public void increment(View view) {
        numberOfCoffees = numberOfCoffees + 1;
        display(numberOfCoffees);
    }

    /**
     * This method decrement numberOfCoffees
     */
    public void decrement(View view) {
        numberOfCoffees = numberOfCoffees - 1;
        display(numberOfCoffees);
    }

    /**
     * This method calculates the total price of the order
     * @totalPrice
     */
    private int calculatePrice() {
        int totalPrice = numberOfCoffees * price;
        return totalPrice;
    }

    /**
     * This method create a summary of the order
     * @totalPrice total price of the order
     * @addWhippedCream user want or not whipped cream
     * @addChocolate user want or not chocolate
     */
    private String createOrderSummary(int totalPrice, boolean addWhippedCream, boolean addChocolate, String customerName) {
        String orderSummary =
                " Name: " + customerName +
                "\n Price = " + totalPrice +
                "\n Add whipped cream: " + addWhippedCream +
                "\n Add whipped cream: " + addChocolate +
                "\n Thank you for your order!";
        displayMessage(orderSummary);
        return orderSummary;
    }

    /**
     * This method displays the given number on the screen.
     */
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
