package com.example.makoreandroid.api;

import com.example.makoreandroid.entities.Message;
import com.example.makoreandroid.entities.RemoteUser;
import com.example.makoreandroid.entities.User;
import com.example.makoreandroid.jsonfiles.SendingMessageJson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WebServiceAPI {
    @GET("contacts/{id}/messages")
    Call<List<Message>> getMessages(@Path("id") String id, @Header("Authorization") String jwt);


    @POST("contacts/{id}/messages")
    Call<Void> createMessage(@Path("id") String id, @Header("Authorization") String jwt, @Body String content);

    @POST("transfer")
    Call<Void> transferMessage(@Body SendingMessageJson message);

    @DELETE("messages/{id}")
    Call<Void> deleteMessage(@Path("id") int id);

    @GET("contacts")
    Call<List<RemoteUser>> getContacts(@Header("Authorization") String jwt);

    @POST("connection/login")
    Call<String> loginGetToken(@Body User user);

    @POST("contacts")
    Call<Void> createUser(@Body User user);

    @DELETE("contacts/{id}")
    Call<Void> deleteUser(@Path(value = "username", encoded = true) String username);

}
