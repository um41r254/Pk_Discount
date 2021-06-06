package com.mid_banchers.pk_discount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {
    Button arrow1,  arrow2, arrow3;
    CardView hot1, hot2, tre1, tre2, brn1, brn2, men_c, men_sh, women_c, women_sh, kid_c, kid_sh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "I am working", Toast.LENGTH_SHORT).show();
        String cityNames[] ={"Islamabad","Faisalabad","Lahore"};
        MaterialAlertDialogBuilder citySelector = new MaterialAlertDialogBuilder(this);
        citySelector.setTitle("Select Your City");
        citySelector.setItems(cityNames, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which==0){
                    Toast.makeText(MainActivity.this, "Islamabad "+ which, Toast.LENGTH_SHORT).show();

                }
                if (which==1){
                    Toast.makeText(MainActivity.this, "Faisalabad "+ which, Toast.LENGTH_SHORT).show();

                }
                if (which==2){
                    Toast.makeText(MainActivity.this, "Lahore "+ which, Toast.LENGTH_SHORT).show();

                }
            }
        });





        arrow1 = findViewById(R.id.button1);
        arrow2 = findViewById(R.id.button2);
        arrow3 = findViewById(R.id.button3);
        arrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "hogya", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent( MainActivity.this,hot_deals.class);
                startActivity(intent);
            }
        });
        arrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Trending", Toast.LENGTH_SHORT).show();

            }
        });
        arrow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Brands", Toast.LENGTH_SHORT).show();
            }
        });
        hot1 = findViewById(R.id.hotdeals1);
        hot2 = findViewById(R.id.hotdeals2);
        hot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hot deal 1", Toast.LENGTH_SHORT).show();
            }
        });
        hot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hot Deal 2", Toast.LENGTH_SHORT).show();
            }
        });
        tre1 = findViewById(R.id.trending1);
        tre2 = findViewById(R.id.trending2);
        tre1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Trendind 1", Toast.LENGTH_SHORT).show();
            }
        });
        tre2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Trending 2", Toast.LENGTH_SHORT).show();
            }
        });
        brn1 = findViewById(R.id.brand1);
        brn2 =findViewById(R.id.brand2);
        brn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v ){
                Toast.makeText(MainActivity.this, "Brand 1", Toast.LENGTH_SHORT).show();
        }
            
        });
        brn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Brand 2", Toast.LENGTH_SHORT).show();

            }
        });
        men_c = findViewById(R.id.men_c);
        women_c = findViewById(R.id.women_c);
        kid_c = findViewById(R.id.kid_c);
        men_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Mens Clothes", Toast.LENGTH_SHORT).show();
            }
        });
        women_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Women Clothes", Toast.LENGTH_SHORT).show();
            }
        });
        kid_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Kids Cloths", Toast.LENGTH_SHORT).show();
            }
        });
        men_sh = findViewById(R.id.men_sh);
        women_sh = findViewById(R.id.women_sh);
        kid_sh = findViewById(R.id.kid_sh);
        
        men_sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Mens Shoes", Toast.LENGTH_SHORT).show();
            }
        });
        women_sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Women Shoes", Toast.LENGTH_SHORT).show();
            }
        });
        kid_sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Kids Shoes", Toast.LENGTH_SHORT).show();
            }
        });
    }
}