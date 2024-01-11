package com.example.insurance_company.insurance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.insurance_company.R;

import java.util.List;

public class InsuranceAdapter extends RecyclerView.Adapter<InsuranceViewHolder> {
    private Context context;
    private final InsuranceEdit insuranceEdit;
    private final List<Insurance> insurances;

    public InsuranceAdapter(InsuranceEdit insuranceEdit, List<Insurance> insurances) {
        this.insuranceEdit = insuranceEdit;
        this.insurances = insurances;
    }

    @NonNull
    @Override
    public InsuranceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View insuranceView = inflater.inflate(R.layout.insurance, parent,false);
        return new InsuranceViewHolder(insuranceView);
    }

    @Override
    public void onBindViewHolder(@NonNull InsuranceViewHolder holder, int position) {
        Insurance insurance = insurances.get(position);
        holder.setName(insurance.getName());
        holder.setPrice(insurance.getPrice());
        holder.setStatus(insurance.isActive());
        holder.setReparation(insurance.getReparation());

        holder.itemView.setOnClickListener(view -> insuranceEdit.editInsurance(insurance, position));
    }

    @Override
    public int getItemCount() {
        return insurances.size();
    }
}
