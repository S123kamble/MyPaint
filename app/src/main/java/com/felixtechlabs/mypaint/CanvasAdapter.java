package com.felixtechlabs.mypaint;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CanvasAdapter extends RecyclerView.Adapter<CanvasAdapter.MyCanvasView> {

    private Context mContext;
    private List<Items> mItemList;
    public CanvasAdapter(Context mContext, List<Items> mItemList) {
        this.mContext = mContext;
        this.mItemList = mItemList;
    }

    @NonNull
    @Override
    public MyCanvasView onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v;
        v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_item, parent, false);
        MyCanvasView holder = new MyCanvasView(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyCanvasView holder, int position) {

        final Items items = mItemList.get(position);

        holder.txt1.setText(items.getTextView1());
        holder.txt2.setText(items.getTextView2());
        holder.txt3.setText(items.getTextView3());
        holder.txt4.setText(items.getTextView4());
        holder.txt5.setText(items.getTextView5());
        holder.txt6.setText(items.getTextView6());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public class MyCanvasView extends RecyclerView.ViewHolder {

        public TextView txt1,txt2,txt3,txt4,txt5,txt6;

        public MyCanvasView(@NonNull View itemView) {
            super(itemView);

            txt1 =itemView.findViewById(R.id.field1);
            txt2 =itemView.findViewById(R.id.field2);
            txt3 =itemView.findViewById(R.id.field3);
            txt4 =itemView.findViewById(R.id.field4);
            txt5 =itemView.findViewById(R.id.field5);
            txt6 =itemView.findViewById(R.id.field6);
        }
    }
}

