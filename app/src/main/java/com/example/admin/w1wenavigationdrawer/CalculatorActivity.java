package com.example.admin.w1wenavigationdrawer;


import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class CalculatorActivity extends AppCompatActivity {

    TextView tvResult;
    boolean operationActive = false;
    boolean operationPending = false;
    String operatorSelected = "";

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    String previousValue = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        tvResult = (TextView) findViewById(R.id.tvResult);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void updateTextView(View view) {

        if (operationActive) {
            tvResult.setText("");
            operationActive = false;
            operationPending = true;
        }

        String inputValue = tvResult.getText().toString();
        inputValue = inputValue + ((Button) view).getText();

        if(!inputValue.contains(".")){
            if (inputValue.length() > 1){
                if(inputValue.charAt(0) == '0'){
                    inputValue = inputValue.substring(1, inputValue.length());
                }
            }

        }

        tvResult.setText(inputValue);
    }

    public void selectOperation(View view) {
        previousValue = tvResult.getText().toString();
        operationActive = true;
        operatorSelected = ((Button) view).getText().toString();
    }

    public void executeOperation(View view) {
        if (operationPending) {
            operationPending = false;

            String currentValue = tvResult.getText().toString();

            BigDecimal  numberA = new BigDecimal (previousValue);
            BigDecimal  numberB = new BigDecimal(currentValue);

            switch (operatorSelected) {
                case "+":
                    tvResult.setText(numberA.add(numberB).toString());
                    break;

                case "-":
                    tvResult.setText(numberA.subtract(numberB).toString());
                    break;

                case "x":
                    tvResult.setText(numberA.multiply(numberB).toString());
                    break;

                case "/":
                    tvResult.setText(numberA.divide(numberB, 2, RoundingMode.HALF_UP).toString());
                    break;
            }

            currentValue = tvResult.getText().toString();
            if (currentValue.contains(".00")){
                currentValue = currentValue.replace(".00", "");
                tvResult.setText(currentValue);
            }


        }
    }

    public void allCancel(View view) {
        operationActive = false;
        operationPending = false;
        operatorSelected = "";
        previousValue = "";
        tvResult.setText("0");
    }

    public void convertToPercentage(View view) {
        String currentValue = tvResult.getText().toString();
        BigDecimal ONE_HUNDRED = new BigDecimal(100);
        BigDecimal  numberA = new BigDecimal (currentValue);

        tvResult.setText(numberA.divide(ONE_HUNDRED).toString());
    }

    public void convertToNegative(View view) {
        String currentValue = tvResult.getText().toString();
        BigDecimal  numberA = new BigDecimal (currentValue);

        tvResult.setText(numberA.negate().toString());
    }

    public void addDotToResult(View view) {

        if (!tvResult.getText().toString().contains(".")) {
            String currentValue = tvResult.getText().toString();
            tvResult.setText(currentValue + ".");
        }
    }
}
