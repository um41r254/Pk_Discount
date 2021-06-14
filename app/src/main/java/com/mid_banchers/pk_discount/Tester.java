package com.mid_banchers.pk_discount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class Tester extends AppCompatActivity {
SwitchMaterial bun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tester);


        bun = findViewById(R.id.bun);
       bun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked) {
                   Toast.makeText(Tester.this, "PopUp", Toast.LENGTH_SHORT).show();
                   String jj[] ={"fsd","Isl","lhr"};
                   MaterialAlertDialogBuilder city = new MaterialAlertDialogBuilder(Tester.this);
                   city.setTitle("Slecet your city");
                   city.setItems(jj, new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           if (which==0);{
                               Toast.makeText(Tester.this, "Fsd" + which, Toast.LENGTH_SHORT).show();
                           }
                           if (which==1);{
                               Toast.makeText(Tester.this, "Isl" + which, Toast.LENGTH_SHORT).show();
                           }
                           if (which==2);{
                               Toast.makeText(Tester.this, "Lhr" + which, Toast.LENGTH_SHORT).show();
                           }
                       }
                   });
                   city.show();



               }
           }
       });
    }
}