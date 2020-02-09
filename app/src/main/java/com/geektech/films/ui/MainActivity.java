package com.geektech.films.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.films.R;
import com.geektech.films.data.entity.Example;
import com.geektech.films.data.internet.RetrofitBuilder;
import com.geektech.films.ui.resyclerView.Adapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter adapter;
    private EditText editText;
    private Button next;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setRecyclerview();
        fetchfilm();
    }

    private void initViews() {
        editText = findViewById(R.id.etSearch);
        next = findViewById(R.id.btn_next);
    }

    private void setRecyclerview() {
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new Adapter();
        recyclerView.setAdapter(adapter);
        textView = findViewById(R.id.test);
    }

    private void fetchfilm() {
        next.setOnClickListener(v ->
                RetrofitBuilder.getService().fetchFilm(editText.getText().toString().trim(), "54145127")
                .enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            setUpAdapter(response.body().getWebsite());
                        }
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }));
    }


//
//    private void parseJson(JsonObject body){
//        JsonObject rates = body.getAsJsonObject("rates");
//        keys = rates.keySet().toArray();
//        values = new ArrayList<>();
//        for (Object item : keys ) {
//            values.add(rates.getAsJsonPrimitive(item.toString()).toString());
//        }
//        setUpAdapter();
//    }

    private void setUpAdapter(String website) {
        textView.setText(website);
        Log.d("ololo", "setUpAdapter: " + website);
        adapter.update(website);
    }

}