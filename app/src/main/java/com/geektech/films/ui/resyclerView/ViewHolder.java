package com.geektech.films.ui.resyclerView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.films.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView tv_result;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_result = itemView.findViewById(R.id.tv_result);
    }

    public void onbind(String s){
        tv_result.setText(s);
    }
}
