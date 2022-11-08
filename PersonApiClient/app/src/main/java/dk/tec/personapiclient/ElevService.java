package dk.tec.personapiclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ElevService
{
    @GET("Elev/{id}")
    Call<Elev> getElevById(@Path("id")int id);

    @GET("Elev")
    Call<List<Elev>> getAllElev();

    @POST("Elev")
    Call<Void> addElev(@Body Elev elev);

}
