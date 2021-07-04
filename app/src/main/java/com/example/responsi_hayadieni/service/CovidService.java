package com.example.responsi_hayadieni.service;

import com.example.responsi_hayadieni.model.Rsakit.DataItem;
import com.example.responsi_hayadieni.model.Rsakit.RsakitResponse;
import com.example.responsi_hayadieni.model.covid.ContentItem;
import com.example.responsi_hayadieni.model.covid.CovidResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CovidService {
    private Retrofit retrofit = null;

    public API getAPI(){
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(API.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(API.class);
    }

    public void getKasus(final CovidListener<List<ContentItem>> listener){
        getAPI().getCoronaCase().enqueue(new Callback<CovidResponse>() {
            @Override
            public void onResponse(Call<CovidResponse> call, Response<CovidResponse> response) {
                CovidResponse data = response.body();

                if (data != null && data.getData() != null){
                    listener.onSuccess(data.getData().getContent());
                }
            }

            @Override
            public void onFailure(Call<CovidResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }

    public void getFaskes(final CovidListener<List<DataItem>> listener){
        getAPI().getFaskes().enqueue(new Callback<RsakitResponse>() {
            @Override
            public void onResponse(Call<RsakitResponse> call, Response<RsakitResponse> response) {
                RsakitResponse data = response.body();

                if (data != null && data.getData() != null){
                    listener.onSuccess(data.getData());
                }
            }

            @Override
            public void onFailure(Call<RsakitResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }
}
