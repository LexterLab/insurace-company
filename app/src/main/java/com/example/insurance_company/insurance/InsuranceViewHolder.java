package com.example.insurance_company.insurance;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.insurance_company.R;

public class InsuranceViewHolder extends RecyclerView.ViewHolder {
    private final TextView name;
    private final TextView price;
    private final TextView status;
    private final TextView reparation;
    public InsuranceViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        price = itemView.findViewById(R.id.price);
        status = itemView.findViewById(R.id.status);
        reparation = itemView.findViewById(R.id.reparation);
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setPrice(double price) {
        this.price.setText(String.valueOf(price));
    }

    public void setStatus(boolean status) {
        this.status.setText(String.valueOf(status));
    }

    public void setReparation(double reparation) {
        this.reparation.setText(String.valueOf(reparation));
    }
}
