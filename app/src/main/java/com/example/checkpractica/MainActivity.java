package com.example.checkpractica;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.checkpractica.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    private EditText editName, editAge;
    private TextView totalDep;
    private RadioGroup rg_sexo;
    private LinearLayout check1;
    private LinearLayout check2;

    private int deportes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_layout);

        check1 = (LinearLayout) findViewById(R.id.linear1);
        ArrayList<View> checks1 = check1.getTouchables();
        for (View chck:checks1){
            ((CheckBox) chck).setOnCheckedChangeListener(this);
        }
        check2 = (LinearLayout) findViewById(R.id.linear2);
        ArrayList<View> checks2 = check2.getTouchables();
        for (View chck:checks2){
            ((CheckBox) chck).setOnCheckedChangeListener(this);
        }

        editName = (EditText) findViewById(R.id.editName);
        editAge = (EditText) findViewById(R.id.editAge);
        totalDep = (TextView) findViewById(R.id.twTotal);
        rg_sexo = (RadioGroup) findViewById(R.id.rgSexo);
        rg_sexo.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup rG, int i) {
        RadioButton radioPulsado = (RadioButton)findViewById(i);
        if (radioPulsado.isChecked()){
            Toast mensaje = Toast.makeText(getApplicationContext(), String.valueOf(radioPulsado.getText()), Toast.LENGTH_SHORT);
            mensaje.show();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton cB, boolean isChecked) {
        CheckBox check_pulsado = (CheckBox) cB;
        if(check_pulsado.isChecked()){
            Toast mensaje = Toast.makeText(getApplicationContext(), String.valueOf(check_pulsado.getText()), Toast.LENGTH_SHORT);
            mensaje.show();
            deportes++;
        }else{
            deportes--;
        }
        totalDep.setText(String.valueOf(" "+deportes));
    }

}