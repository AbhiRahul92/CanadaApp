


import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ConnectionApi {

    @GET()
    suspend fun getDetails() : Response<List<CanadaDetails>>


    companion object{
        operator fun invoke() : ConnectionApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/fact.json/")
                .build()
                .create(ConnectionApi::class.java)
        }
    }
}
