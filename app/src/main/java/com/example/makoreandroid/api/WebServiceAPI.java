package com.example.makoreandroid.api;

import com.example.makoreandroid.entities.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WebServiceAPI {
    @GET("contacts/Tal/messages")
    Call<List<Message>> getMessages(@Header("Authorization") String jwt);

    @POST("messages")
    Call<Void> createMessage(@Body Message message);

    @DELETE("messages/{id}")
    Call<Void> deleteMessage(@Path("id") int id);

}