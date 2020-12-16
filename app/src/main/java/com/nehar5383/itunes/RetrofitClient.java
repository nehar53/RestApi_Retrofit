package com.nehar5383.itunes;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class RetrofitClient {

    private  Retrofit retrofit ;
    private  static final  String URL="https://itunes.apple.com/";
    private  static  RetrofitClient mInstance;



    private RetrofitClient() {
      //  if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        public static synchronized RetrofitClient getInstance() {
            if (mInstance == null) {
                mInstance = new RetrofitClient();

            }
            return mInstance;
        }
        public UserService getUservice () {
            return retrofit.create(UserService.class);
        }
    }
