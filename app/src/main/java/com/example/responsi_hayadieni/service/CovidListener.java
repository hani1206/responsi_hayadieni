package com.example.responsi_hayadieni.service;

public interface CovidListener<T> {
    void onSuccess(T items);
    void onFailed(String msg);
}
