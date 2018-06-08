package com.developer.livedatamvvm.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.developer.livedatamvvm.pojos.Pojo;
import com.developer.livedatamvvm.databinding.DataListing;
import com.developer.livedatamvvm.utilities.BindingUtils;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
    private List<Pojo> list;
    private LayoutInflater layoutInflater;
    Context context;

    public DataAdapter(List<Pojo> list, Context context) {

        this.list = list;

        this.context = context;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (layoutInflater == null) {

            layoutInflater = LayoutInflater.from(parent.getContext());

        }

        DataListing myListBinding = DataListing.inflate(layoutInflater, parent, false);

        return new MyViewHolder(myListBinding);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        Pojo data=list.get(position);

        holder.myListBinding.setDataListing(data);

        BindingUtils.loadImage(holder.myListBinding.image,data.getFlag());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        DataListing myListBinding;

        public MyViewHolder(DataListing myListBinding) {

            super(myListBinding.getRoot());

            this.myListBinding = myListBinding;


        }

    }



}
