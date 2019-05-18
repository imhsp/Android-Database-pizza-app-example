package com.damandeep.mompopspizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private int userID;

    private Button pizzaPlus, pizzaMinus;
    private TextView pizzaQty, pizzaPricetxt;
    private Spinner pizzaSpinner;

    private Button calzonesPlus, calzonesMinus;
    private TextView calzonesQty, calzonesPricetxt;
    private Spinner CalzonesSpinner;

    private Button WingsPlus, WingsMinus;
    private TextView WingsQty, WingsPricetxt;

    private Button PastaPlus, PastaMinus;
    private TextView PastaQty, PastaPricetxt;

    private Button FriesPlus, FriesMinus;
    private TextView FriesQty, FriesPricetxt;
    private Spinner FriesSpinner;

    private Button SodaPlus, SodaMinus;
    private TextView SodaQty, SodaPricetxt;
    private Spinner SodaSpinner;

    private TextView GTotalPricetxt;
    private Button checkOut;

    private ArrayList<String> pizzaToppingsList, CalzonesToppingsList, PastaToppingsList, WingsToppingsList;

    private int GTotal, pizzaPrice, CalzonesPrice, PastaPrice, FriesPrice, WingsPrice, SodaPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();

        userID = intent.getIntExtra("userID", 0);

        initPizza();
        initCalzones();
        initPasta();
        initWings();
        initFries();
        initSoda();

        GTotalPricetxt = findViewById(R.id.grandTotaltextView);

        checkOut = findViewById(R.id.Checkoutbutton);
        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmOrder();
            }
        });
    }



    private void initPizza() {
        pizzaToppingsList = new ArrayList<String>();

        pizzaPlus = findViewById(R.id.button);
        pizzaMinus = findViewById(R.id.button2);
        pizzaQty = findViewById(R.id.qtyeditText);
        pizzaPricetxt = findViewById(R.id.pizzapricetextView);

        pizzaPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!pizzaQty.getText().toString().matches(""))
                    pizzaQty.setText(String.valueOf(Integer.parseInt(pizzaQty.getText().toString()) + 1));
                else
                    pizzaQty.setText("1");

                onPizzaChange();
            }
        });

        pizzaMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!pizzaQty.getText().toString().matches("") && !pizzaQty.getText().toString().equals("0"))
                    pizzaQty.setText(String.valueOf(Integer.parseInt(pizzaQty.getText().toString()) - 1));
                else
                    pizzaQty.setText("0");

                onPizzaChange();
            }
        });

        pizzaSpinner = findViewById(R.id.sizespinner);

        pizzaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onPizzaChange();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initCalzones() {

        CalzonesToppingsList = new ArrayList<String>();

        calzonesPlus = findViewById(R.id.Calzonesbutton);
        calzonesMinus = findViewById(R.id.Calzonesbutton2);
        calzonesQty = findViewById(R.id.CalzonesqtyeditText);
        calzonesPricetxt = findViewById(R.id.CalzonespricetextView);

        calzonesPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!calzonesQty.getText().toString().matches(""))
                    calzonesQty.setText(String.valueOf(Integer.parseInt(calzonesQty.getText().toString()) + 1));
                else
                    calzonesQty.setText("1");

                onCalzonesChange();
            }
        });

        calzonesMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!calzonesQty.getText().toString().matches("") && !calzonesQty.getText().toString().equals("0"))
                    calzonesQty.setText(String.valueOf(Integer.parseInt(calzonesQty.getText().toString()) - 1));
                else
                    calzonesQty.setText("0");

                onCalzonesChange();
            }
        });

        CalzonesSpinner = findViewById(R.id.Calzonessizespinner);

        CalzonesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onCalzonesChange();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initPasta() {

        PastaToppingsList = new ArrayList<String>();

        PastaPlus = findViewById(R.id.Pastabutton);
        PastaMinus = findViewById(R.id.Pastabutton2);
        PastaQty = findViewById(R.id.PastaqtyeditText);
        PastaPricetxt = findViewById(R.id.PastapricetextView);

        PastaPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!PastaQty.getText().toString().matches(""))
                    PastaQty.setText(String.valueOf(Integer.parseInt(PastaQty.getText().toString()) + 1));
                else
                    PastaQty.setText("1");

                onPastaChange();
            }
        });

        PastaMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!PastaQty.getText().toString().matches("") && !PastaQty.getText().toString().equals("0"))
                    PastaQty.setText(String.valueOf(Integer.parseInt(PastaQty.getText().toString()) - 1));
                else
                    PastaQty.setText("0");

                onPastaChange();
            }
        });


    }

    private void initWings() {

        WingsToppingsList = new ArrayList<String>();

        WingsPlus = findViewById(R.id.Wingsbutton);
        WingsMinus = findViewById(R.id.Wingsbutton2);
        WingsQty = findViewById(R.id.WingsqtyeditText);
        WingsPricetxt = findViewById(R.id.WingspricetextView);

        WingsPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!WingsQty.getText().toString().matches(""))
                    WingsQty.setText(String.valueOf(Integer.parseInt(WingsQty.getText().toString()) + 1));
                else
                    WingsQty.setText("1");

                onWingsChange();
            }
        });

        WingsMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!WingsQty.getText().toString().matches("") && !WingsQty.getText().toString().equals("0"))
                    WingsQty.setText(String.valueOf(Integer.parseInt(WingsQty.getText().toString()) - 1));
                else
                    WingsQty.setText("0");

                onWingsChange();
            }
        });

    }

    private void initFries() {


        FriesPlus = findViewById(R.id.Friesbutton);
        FriesMinus = findViewById(R.id.Friesbutton2);
        FriesQty = findViewById(R.id.FriesqtyeditText);
        FriesPricetxt = findViewById(R.id.FriespricetextView);

        FriesPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!FriesQty.getText().toString().matches(""))
                    FriesQty.setText(String.valueOf(Integer.parseInt(FriesQty.getText().toString()) + 1));
                else
                    FriesQty.setText("1");

                onFriesChange();
            }
        });

        FriesMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!FriesQty.getText().toString().matches("") && !FriesQty.getText().toString().equals("0"))
                    FriesQty.setText(String.valueOf(Integer.parseInt(FriesQty.getText().toString()) - 1));
                else
                    FriesQty.setText("0");

                onFriesChange();
            }
        });

        FriesSpinner = findViewById(R.id.Friessizespinner);

        FriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onFriesChange();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initSoda() {

        SodaPlus = findViewById(R.id.Sodabutton);
        SodaMinus = findViewById(R.id.Sodabutton2);
        SodaQty = findViewById(R.id.SodaqtyeditText);
        SodaPricetxt = findViewById(R.id.SodapricetextView);

        SodaPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!SodaQty.getText().toString().matches(""))
                    SodaQty.setText(String.valueOf(Integer.parseInt(SodaQty.getText().toString()) + 1));
                else
                    SodaQty.setText("1");

                onSodaChange();
            }
        });

        SodaMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!SodaQty.getText().toString().matches("") && !SodaQty.getText().toString().equals("0"))
                    SodaQty.setText(String.valueOf(Integer.parseInt(SodaQty.getText().toString()) - 1));
                else
                    SodaQty.setText("0");

                onSodaChange();
            }
        });

        SodaSpinner = findViewById(R.id.Sodasizespinner);

    }


    public void onPizzaCheckboxClicked(View view) {

        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        if (checked)
            if (pizzaToppingsList.size() < 3) {
                pizzaToppingsList.add((String) ((CheckBox) view).getText());
            } else {
                Toast.makeText(getApplicationContext(), "3 Toppings only", Toast.LENGTH_LONG).show();
                ((CheckBox) view).setChecked(false);
            }
        else
            pizzaToppingsList.remove((String) ((CheckBox) view).getText());


    }

    public void onCalzonesCheckboxClicked(View view) {

        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        if (checked)
            if (CalzonesToppingsList.size() < 3) {
                CalzonesToppingsList.add((String) ((CheckBox) view).getText());
            } else {
                Toast.makeText(getApplicationContext(), "3 Toppings only", Toast.LENGTH_LONG).show();
                ((CheckBox) view).setChecked(false);
            }
        else
            CalzonesToppingsList.remove((String) ((CheckBox) view).getText());

    }

    public void onPastaCheckboxClicked(View view) {

        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        if (checked)
            if (PastaToppingsList.size() < 3) {
                PastaToppingsList.add((String) ((CheckBox) view).getText());
            } else {
                Toast.makeText(getApplicationContext(), "3 Toppings only", Toast.LENGTH_LONG).show();
                ((CheckBox) view).setChecked(false);
            }
        else
            PastaToppingsList.remove((String) ((CheckBox) view).getText());


    }

    public void onWingsCheckboxClicked(View view) {

        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        if (checked)
            if (WingsToppingsList.size() < 3) {
                WingsToppingsList.add((String) ((CheckBox) view).getText());
            } else {
                Toast.makeText(getApplicationContext(), "3 Toppings only", Toast.LENGTH_LONG).show();
                ((CheckBox) view).setChecked(false);
            }
        else
            WingsToppingsList.remove((String) ((CheckBox) view).getText());


    }

    public void onPizzaChange() {

        if (!pizzaQty.getText().equals("")) {

            pizzaPrice = 0;

            if (pizzaSpinner.getSelectedItemPosition() == 0)
                pizzaPrice = 10;
            else if (pizzaSpinner.getSelectedItemPosition() == 1)
                pizzaPrice = 12;
            else if (pizzaSpinner.getSelectedItemPosition() == 2)
                pizzaPrice = 14;
            else if (pizzaSpinner.getSelectedItemPosition() == 3)
                pizzaPrice = 16;

            pizzaPrice *= Integer.parseInt(pizzaQty.getText().toString());

            pizzaPricetxt.setText(String.valueOf(pizzaPrice));

            calGTotal();


        }


    }

    public void onCalzonesChange() {

        if (!calzonesQty.getText().equals("")) {

            CalzonesPrice = 0;

            if (CalzonesSpinner.getSelectedItemPosition() == 0)
                CalzonesPrice = 10;
            else if (CalzonesSpinner.getSelectedItemPosition() == 1)
                CalzonesPrice = 12;
            else if (CalzonesSpinner.getSelectedItemPosition() == 2)
                CalzonesPrice = 14;

            CalzonesPrice *= Integer.parseInt(calzonesQty.getText().toString());

            calzonesPricetxt.setText(String.valueOf(CalzonesPrice));

            calGTotal();

        }


    }

    public void onPastaChange() {

        if (!PastaQty.getText().equals("")) {

            int UPastaPrice = 6;
            PastaPrice = 0;

            PastaPrice = UPastaPrice * Integer.parseInt(PastaQty.getText().toString());

            PastaPricetxt.setText(String.valueOf(PastaPrice));

            calGTotal();

        }


    }

    public void onWingsChange() {

        if (!WingsQty.getText().equals("")) {

            int UWingsPrice = 8;
            WingsPrice = 0;

            WingsPrice = UWingsPrice * Integer.parseInt(WingsQty.getText().toString());

            WingsPricetxt.setText(String.valueOf(WingsPrice));

            calGTotal();

        }


    }

    public void onFriesChange() {

        if (!FriesQty.getText().equals("")) {

            FriesPrice = 0;

            if (FriesSpinner.getSelectedItemPosition() == 0)
                FriesPrice = 2;
            else if (FriesSpinner.getSelectedItemPosition() == 1)
                FriesPrice = 4;
            else if (FriesSpinner.getSelectedItemPosition() == 2)
                FriesPrice = 6;

            FriesPrice *= Integer.parseInt(FriesQty.getText().toString());

            FriesPricetxt.setText(String.valueOf(FriesPrice));

            calGTotal();

        }


    }

    public void onSodaChange() {

        if (!SodaQty.getText().equals("")) {

            int USodaPrice = 5;
            SodaPrice = 0;

            SodaPrice = USodaPrice * Integer.parseInt(SodaQty.getText().toString());

            SodaPricetxt.setText(String.valueOf(SodaPrice));

            calGTotal();

        }


    }

    public void calGTotal() {

        GTotal = pizzaPrice + CalzonesPrice + PastaPrice + WingsPrice + FriesPrice + SodaPrice;

        GTotalPricetxt.setText(String.valueOf(GTotal));

    }


    private void confirmOrder() {


        int pizzaQty = this.pizzaQty.getText().toString().matches("") ? 0 : Integer.parseInt(this.pizzaQty.getText().toString());
        int calzonesQty = this.calzonesQty.getText().toString().matches("") ? 0 : Integer.parseInt(this.calzonesQty.getText().toString());
        int pastaQty = this.PastaQty.getText().toString().matches("") ? 0 : Integer.parseInt(this.PastaQty.getText().toString());
        int wingsQty = this.WingsQty.getText().toString().matches("") ? 0 : Integer.parseInt(this.WingsQty.getText().toString());
        int friesQty = this.FriesQty.getText().toString().matches("") ? 0 : Integer.parseInt(this.FriesQty.getText().toString());
        int sodaQty = this.SodaQty.getText().toString().matches("") ? 0 : Integer.parseInt(this.SodaQty.getText().toString());

        if (pizzaQty > 0 || calzonesQty > 0 || pastaQty > 0 || wingsQty > 0 || friesQty > 0 || sodaQty > 0) {

            OrderDatabaseHelper ODH = new OrderDatabaseHelper(this);


            if (pizzaToppingsList.size() < 3) {

                for (int i = 0; i <= 4 - pizzaToppingsList.size(); i++) {

                    pizzaToppingsList.add("");


                }

            }

            if (CalzonesToppingsList.size() < 3) {
                for (int i = 0; i <= 4 - CalzonesToppingsList.size(); i++) {

                    CalzonesToppingsList.add("");

                }
            }

            if (PastaToppingsList.size() < 3) {
                for (int i = 0; i <= 4 - PastaToppingsList.size(); i++) {

                    PastaToppingsList.add("");

                }
            }

            if (WingsToppingsList.size() < 3) {
                for (int i = 0; i <= 4 - WingsToppingsList.size(); i++) {

                    WingsToppingsList.add("");

                }
            }


            boolean result = ODH.addOrder(userID, pizzaQty <= 0 ? 0 : 1, pizzaToppingsList.get(0), pizzaToppingsList.get(1), pizzaToppingsList.get(2), pizzaSpinner.getSelectedItem().toString(), String.valueOf(pizzaQty), String.valueOf(pizzaPrice),
                    calzonesQty <= 0 ? 0 : 1, CalzonesToppingsList.get(0), CalzonesToppingsList.get(1), CalzonesToppingsList.get(2), CalzonesSpinner.getSelectedItem().toString(), String.valueOf(calzonesQty), String.valueOf(CalzonesPrice),
                    pastaQty <= 0 ? 0 : 1, PastaToppingsList.get(0), PastaToppingsList.get(1), PastaToppingsList.get(2), String.valueOf(pastaQty), String.valueOf(PastaPrice),
                    wingsQty <= 0 ? 0 : 1, WingsToppingsList.get(0), WingsToppingsList.get(1), WingsToppingsList.get(2), String.valueOf(wingsQty), String.valueOf(WingsPrice),
                    friesQty <= 0 ? 0 : 1, FriesSpinner.getSelectedItem().toString(), String.valueOf(friesQty), String.valueOf(FriesPrice),
                    sodaQty <= 0 ? 0 : 1, SodaSpinner.getSelectedItem().toString(), String.valueOf(sodaQty), String.valueOf(SodaPrice), String.valueOf(GTotal));

            if (result) {
                launchOrderDetails(userID);
            } else {
                Toast.makeText(getApplicationContext(), "Error inserting data", Toast.LENGTH_LONG).show();
            }


        } else {
            Toast.makeText(getApplicationContext(), "Select Qty. to Order", Toast.LENGTH_LONG).show();
        }


    }

    private void launchOrderDetails(int userID) {
        Intent intent = new Intent(this, OrderDetailActivity.class);
        intent.putExtra("userID", userID);
        startActivity(intent);
        finish();
    }
}
