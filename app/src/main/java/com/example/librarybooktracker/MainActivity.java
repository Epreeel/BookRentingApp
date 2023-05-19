package com.example.librarybooktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    private FirebaseFirestore firestore;
    Book book = new Book();
    private EditText bookCode, days;
    private Button borrow;
    private TextView text_title, text_author, text_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firestore = FirebaseFirestore.getInstance();
        ref();
        //TODO
        borrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String bCode = bookCode.getText().toString().trim();
                int numOfDays = Integer.parseInt(days.getText().toString().trim());
                borrow(bCode, numOfDays);
            }
        });
        //create a getPrice method
        //create a borrow book method

    }

    public void ref() {
        bookCode = findViewById(R.id.editTextCode);
        days = findViewById(R.id.editTextDays);
        borrow = findViewById(R.id.buttonBorrow);
        text_title = findViewById(R.id.textViewTitle);
        text_author = findViewById(R.id.textViewAuthor);
        text_price = findViewById(R.id.textViewPrice);
    }

    public void borrow(String bookCode, int days) {
        try{
            firestore.collection("Book").document(bookCode).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            book.setTitle(document.getString("BookTitle"));
                            book.setAuthor(document.getString("BookAuthor"));
                            book.setType(document.getString("BookType"));
                            book.setBorrowed(document.getBoolean("isBorrowed"));

                            if(!book.isBorrowed()){
                                double price;
                                if(book.getType().equals("Premium")){
                                    price =  CalculatePrice(50.00, days);
                                }else{
                                    price = CalculatePrice(20.00, days);
                                }
                                // Update the UI with book information and price
                                text_title.setText(String.format("Title: %s", book.getTitle()));
                                text_author.setText(String.format("Author: %s", book.getAuthor()));
                                text_price.setText("Total price to pay: $" + price);

                            }else{
                                Toast.makeText(MainActivity.this, "Book is not currently not available", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            // Book not found in Firestore
                            Toast.makeText(MainActivity.this, "Book not found", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Error occurred while retrieving book information
                        Log.e("MainActivity", "Error getting book information", task.getException());
                        Toast.makeText(MainActivity.this, "Error getting book information", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        catch (Exception e){
            System.out.print(e);
        }

    }
    public double CalculatePrice(double rate, int days){
        double total = rate * days;
        if (days > 7) {
            double additionalPrice = (days - 7) * 25.00;
            total += additionalPrice;
        }
        return total;
    }
}