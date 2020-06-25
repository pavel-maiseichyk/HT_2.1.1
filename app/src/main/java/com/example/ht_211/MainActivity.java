package com.example.ht_211;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import static android.text.InputType.TYPE_CLASS_NUMBER;
import static android.text.InputType.TYPE_CLASS_PHONE;
import static android.text.InputType.TYPE_CLASS_TEXT;

public class MainActivity extends AppCompatActivity {

    EditText money;
    EditText info;
    Button buttonOK;
    CheckBox checkboxBank;
    CheckBox checkBoxCash;
    CheckBox checkBoxPhone;
    String check;

    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @SuppressLint("ResourceType")
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                switch (buttonView.getId()) {
                    case R.id.CheckboxFromBank:
                        resetCheckBoxes();
                        checkboxBank.setChecked(true);
                        info.setInputType(TYPE_CLASS_NUMBER);
                        check = "С банковской карты";
                        break;
                    case R.id.CheckboxFromPhone:
                        resetCheckBoxes();
                        checkBoxPhone.setChecked(true);
                        info.setInputType(TYPE_CLASS_PHONE);
                        check = "С мобильного телефона";
                        break;
                    case R.id.CheckboxInCash:
                        resetCheckBoxes();
                        checkBoxCash.setChecked(true);
                        info.setInputType(TYPE_CLASS_TEXT);
                        check = "Наличными по адресу";
                        break;
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void resetCheckBoxes() {
        checkboxBank.setChecked(false);
        checkBoxCash.setChecked(false);
        checkBoxPhone.setChecked(false);
    }

    public void init() {
        money = findViewById(R.id.inputMoney);
        info = findViewById(R.id.inputInfo);
        buttonOK = findViewById(R.id.buttonOK);
        checkboxBank = findViewById(R.id.CheckboxFromBank);
        checkBoxCash = findViewById(R.id.CheckboxInCash);
        checkBoxPhone = findViewById(R.id.CheckboxFromPhone);

        checkBoxPhone.setOnCheckedChangeListener(checkedChangeListener);
        checkBoxCash.setOnCheckedChangeListener(checkedChangeListener);
        checkboxBank.setOnCheckedChangeListener(checkedChangeListener);
    }

    public void setButtonOK(View view) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Выбрана опция: ").append(check).append("\nИнформация: ").append(info.getText().toString()).append("\nСтоимость: ").append(money.getText().toString());
        Toast.makeText(MainActivity.this, stringBuilder, Toast.LENGTH_LONG).show();
        money.getText().clear();
        info.getText().clear();
        resetCheckBoxes();
    }
}