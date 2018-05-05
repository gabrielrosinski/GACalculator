package com.gabriel.gacalculator.BirthdayAssignmnet;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gabriel.gacalculator.R;

import java.util.ArrayList;

class BirthdayDateAdapter extends RecyclerView.Adapter<BirthdayDateAdapter.ViewHolder> {

    ArrayList<String> birthdayDateList;


    public BirthdayDateAdapter(ArrayList<String> birthdayDateList) {
        this.birthdayDateList = birthdayDateList;
    }

    @Override
    public BirthdayDateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.birthday_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BirthdayDateAdapter.ViewHolder holder, int position) {
        holder.birthdayDate.setText(birthdayDateList.get(position));
    }

    @Override
    public int getItemCount() {
        return birthdayDateList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView birthdayDate;

        public ViewHolder(View itemView) {
            super(itemView);
            birthdayDate = itemView.findViewById(R.id.birthdayRowTextView);
        }
    }
}
