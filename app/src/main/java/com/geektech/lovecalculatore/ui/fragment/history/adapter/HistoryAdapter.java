package com.geektech.lovecalculatore.ui.fragment.history.adapter;

import android.annotation.SuppressLint;
import android.app.Application;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.lovecalculatore.data.entity.LoveModel;
import com.geektech.lovecalculatore.data.entity.historymodel.HistoryModel;
import com.geektech.lovecalculatore.data.room.LoveDao;
import com.geektech.lovecalculatore.data.room.LoveDataBase;
import com.geektech.lovecalculatore.databinding.ItemHistoryBinding;
import com.geektech.lovecalculatore.hilt.AppModule;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import dagger.hilt.android.qualifiers.ApplicationContext;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private final List<HistoryModel> list = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void addItem(List<HistoryModel> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHistoryBinding binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.txtMe.setText(list.get(position).getFirstName());
        holder.binding.txtYou.setText(list.get(position).getSecondName());
        holder.binding.txtResultHistory.setText(list.get(position).getResult());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final ItemHistoryBinding binding;
        public ViewHolder(ItemHistoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
