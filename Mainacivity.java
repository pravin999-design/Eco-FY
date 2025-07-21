package com.example.eco_fy; // or maybe com.example.ecofy
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
EditText inputKm, inputElectricity, inputFlights;
Button calculateBtn;
TextView resultText;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
inputKm = findViewById(R.id.inputKm);
inputElectricity = findViewById(R.id.inputElectricity);
inputFlights = findViewById(R.id.inputFlights);
calculateBtn = findViewById(R.id.calculateBtn);
resultText = findViewById(R.id.resultText);
calculateBtn.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
calculateCarbonFootprint();
}
});
}
private void calculateCarbonFootprint() {
try {
double km = Double.parseDouble(inputKm.getText().toString());
double electricity = Double.parseDouble(inputElectricity.getText().toString());
int flights = Integer.parseInt(inputFlights.getText().toString());
// Emission factors (approximate):
double carEmission = km * 0.21; // per km
double electricityEmission = electricity * 0.92; // per kWh
double flightEmission = flights * 250; // per flight (one-way short haul approx)
double dailyCarbon = carEmission + electricityEmission;
double yearlyFlightCarbon = flightEmission;
double totalYearlyCarbon = (dailyCarbon * 365) + yearlyFlightCarbon;
resultText.setText(String.format("Estimated Annual Carbon Footprint:\n%.2f kg
CO₂", totalYearlyCarbon));
} catch (Exception e) {
resultText.setText("Please enter valid numbers in all fields.");
}
}
}
