package com.example.oways.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //display(quantity);
        //displayPrice(quantity*5);
    //    int price=calculatePrice();
    //String priceMessage="Total: $"+price+"\nThank you!";
        //displayMessage(orderSummary(quantity));

        //=+=++=INTENT EMAIL+=+=+=
        // public void composeEmail(String[] addresses, String subject) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, "owaisalamkhi@gmail.com");
            intent.putExtra(Intent.EXTRA_SUBJECT, "JustJava Order for "+name());
            intent.putExtra(Intent.EXTRA_TEXT, orderSummary(quantity));

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        //}

    }
public void increment(View view){
//int quantity=2;
    if(quantity<100){
        quantity=quantity+1;
    }
    else {
        quantity=100;

    }
    displayQuantity(quantity);


}
    public void decrement(View view){
       // int quantity=1;
        if(quantity>1){
            quantity=quantity-1;
        }
        else {
            quantity=1;

        }
        displayQuantity(quantity);


    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffee) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffee);
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummeryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummeryTextView.setText(message);
    }
    private int calculatePrice(){
       int price=5;
        if(whipped_checkBox()) {
            price=price+1;
        }
        if(chocolate_checkBox()){
        price=price+2;
        }
        return price*quantity;

    }
    private String orderSummary(int number){
        //String name="Owais Alam";
       // int price=quantity*5;
        return "Name: "+name()+"\nAdd whipped cream? "+whipped_checkBox()+"\nAdd chocolate? "+chocolate_checkBox()+"\nQuantity: "+quantity+"\nTotal: "+NumberFormat.getCurrencyInstance().format(calculatePrice())+"\nThank you!";
    }



    public boolean whipped_checkBox(){
        CheckBox whippedCheckBox=(CheckBox)findViewById(R.id.whipped_checkbox);
        if(whippedCheckBox.isChecked()){
            return true;
                    }
        else
        {
            return false;
        }
    }
    public boolean chocolate_checkBox(){
        CheckBox chocolateCheckBox=(CheckBox)findViewById(R.id.chocolate_checkbox);
        if(chocolateCheckBox.isChecked()){
            return true;
        }
        else
        {
            return false;
        }
    }
    public String name(){
        EditText editText =(EditText)findViewById(R.id.name);
        String name=editText.getText().toString();
        return name;
    }
}
