package com.example.titshop.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public abstract class BaseAdapter<T ,VB extends ViewDataBinding> extends RecyclerView.Adapter<BaseAdapter.ViewHolder> {
    protected ArrayList<T> datalist = new ArrayList<>();

    public abstract int getLayoutId();
    public abstract int getIdVariable();
    public abstract int getIdVariableOnclick();
    public abstract CBAdapter getOnclick();

    public void setList(ArrayList<T> arrayList){
        this.datalist = arrayList;
        notifyDataSetChanged();
    }
    public void addMore(ArrayList<T> arrayList){
        this.datalist.addAll(arrayList);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        VB binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), getLayoutId(), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    @Override
    public void onBindViewHolder(BaseAdapter.ViewHolder holder, int position) {
        holder.setVariable(getIdVariable(),datalist.get(position));
        holder.setClickAdapter(getIdVariableOnclick(),getOnclick());
    }

    class ViewHolder<T,VB extends ViewDataBinding> extends RecyclerView.ViewHolder{
        private VB binding;
        public ViewHolder(@NonNull VB binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void setVariable(int id,T t){
            this.binding.setVariable(id,t);
        }
        public void setClickAdapter(int id,CBAdapter t){
            this.binding.setVariable(id,t);
        }
    }

}
