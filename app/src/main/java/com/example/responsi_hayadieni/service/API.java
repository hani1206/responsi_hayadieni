package com.example.responsi_hayadieni.service;
import com.example.responsi_hayadieni.model.Rsakit.RsakitResponse;
import com.example.responsi_hayadieni.model.covid.CovidResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    String URL_BASE = "https://covid19-public.digitalservice.id/api/v1/";

    @GET("rekapitulasi_v2/jabar/harian")
    Call<CovidResponse> getCoronaCase();

    @GET("sebaran_v2/jabar/faskes")
    Call<RsakitResponse> getFaskes();

}
