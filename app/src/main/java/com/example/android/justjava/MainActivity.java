package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


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
        String customerName = name.getText().toString();
//        for testing if checkbox is working
//        Log.v("MainActivity", "Has whipped cream " +hasWhippedCream);
        int totalPrice = calculatePrice(hasWhippedCream, hasChocolate);
        String finalOrder =createOrderSummary(totalPrice, hasWhippedCream, hasChocolate, customerName);
    // intent to send order summary by email to customer
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only emails app can handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee order for"+ name);
        intent.putExtra(Intent.EXTRA_TEXT,finalOrder);
        if(intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }
    }

    /**
     * This method increment numberOfCoffees
     */
    public void increment(View view) {
        if (numberOfCoffees == 100) {
            Toast.makeText(this, "You cannot have more than 1oo coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        numberOfCoffees = numberOfCoffees + 1;
        display(numberOfCoffees);
    }

    /**
     * This method decrement numberOfCoffees
     */
    public void decrement(View view) {
        if (numberOfCoffees <= 1) {
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        numberOfCoffees = numberOfCoffees - 1;
        display(numberOfCoffees);
    }

    /**
     * This method calculates the total price of the order
     *
     * @return totalPrice
     * @addWhippedCream if  user add whipped cream to the coffee
     * @addChocolate if user add chocolate to the coffee
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = price;
        //if  user add whipped cream to the coffee
        if (addWhippedCream) {
            basePrice += 1;
        }
        //if user add chocolate to the coffee
        if (addChocolate) {
            basePrice += 2;
        }
        return numberOfCoffees * basePrice;
    }

    /**
     * This method create a summary of the order
     *
     * @return orderSummary
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
//    private void displayMessage(String message) {
//        TextView priceTextView = (TextView) findViewById(R.id.oder_summary_textView);
//        priceTextView.setText(message);
//    }

}
