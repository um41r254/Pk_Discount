package com.mid_banchers.pk_discount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.dialog.MaterialDialogs;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class tester extends AppCompatActivity {
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
                   Toast.makeText(tester.this, "PopUp", Toast.LENGTH_SHORT).show();
                   String jj[] ={"fsd","Isl","lhr"};
                   MaterialAlertDialogBuilder city = new MaterialAlertDialogBuilder(tester.this);
                   city.setTitle("Slecet your city");
                   city.setItems(jj, new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           if (which==0);{
                               Toast.makeText(tester.this, "Fsd" + which, Toast.LENGTH_SHORT).show();
                           }
                           if (which==1);{
                               Toast.makeText(tester.this, "Isl" + which, Toast.LENGTH_SHORT).show();
                           }
                           if (which==2);{
                               Toast.makeText(tester.this, "Lhr" + which, Toast.LENGTH_SHORT).show();
                           }
                       }
                   });
                   city.show();



               }
           }
       });
    }
}