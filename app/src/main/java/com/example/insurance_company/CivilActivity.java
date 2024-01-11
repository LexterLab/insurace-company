package com.example.insurance_company;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;

import com.example.insurance_company.insurance.Insurance;
import com.example.insurance_company.insurance.InsuranceAdapter;
import com.example.insurance_company.insurance.InsuranceEdit;
import com.example.insurance_company.insurance.InsuranceSource;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class CivilActivity extends AppCompatActivity implements InsuranceEdit {
    private RecyclerView recycler;
    private int position;
    private EditText name;
    private EditText price;
    private EditText status;
    private EditText reparation;
    private List<Insurance> insuranceList;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil);
        recycler = findViewById(R.id.recycler1);
        insuranceList = InsuranceSource.getCivilInsurance();
        InsuranceAdapter adapter = new InsuranceAdapter(this, insuranceList);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(editItem, 4000);
        name = findViewById(R.id.nameEdit1);
        price = findViewById(R.id.priceEdit1);
        status = findViewById(R.id.statusEdit1);
        reparation = findViewById(R.id.reparationEdit1);

        findViewById(R.id.save1).setOnClickListener(view -> {
            Insurance insurance = new Insurance();
            insurance.setActive(Boolean.parseBoolean(status.getText().toString()));
            insurance.setName(name.getText().toString());
            insurance.setPrice(Double.parseDouble(price.getText().toString()));
            insurance.setReparation(Double.parseDouble(reparation.getText().toString()));
            insuranceList.set(position, insurance);
        });
    }

    public final Runnable editItem = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(this, 4000);
            Random random = new Random();
            int randomPos = random.nextInt(insuranceList.size());
            Insurance insurance = insuranceList.get(randomPos);
            insurance.setActive(!insurance.isActive());
            insuranceList.set(randomPos, insurance);
            Objects.requireNonNull(recycler.getAdapter()).notifyItemChanged(randomPos);
        }
    };



    @Override
    public void editInsurance(Insurance insurance, int pos) {
        name.setText(insurance.getName());
        price.setText(String.valueOf(insurance.getPrice()));
        price.setText(String.valueOf(insurance.isActive()));
        price.setText(String.valueOf(insurance.getReparation()));
        findViewById(R.id.frame1).setVisibility(View.VISIBLE);
        position = pos;
    }
}