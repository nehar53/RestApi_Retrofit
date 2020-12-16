package com.nehar5383.itunes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;



public class MainActivity extends AppCompatActivity {

    EditText edtUsername;
ResObj resObj;
    Button btnLogin;
    TextView textView,count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = (EditText) findViewById(R.id.edtUsername);

        btnLogin = (Button) findViewById(R.id.btnLogin);
     //   userService = ApiUtils.getUserService();
textView=(TextView)findViewById(R.id.txtSong);
    count=(TextView)findViewById(R.id.intSong);
        btnLogin.setOnClickListener(v -> {
            String username = edtUsername.getText().toString();

            //validate form
            if(validateSearch(username)){
                //do login
                doSearch();
            }
        });

    }

    private boolean validateSearch(String username){
        if(username == null || username.trim().length() == 0){
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void doSearch(){
        Call <ResObj> call = RetrofitClient.getInstance().getUservice().Search(edtUsername.getText().toString().trim());
        call.enqueue(new Callback<ResObj>() {
            @Override
            public void onResponse(Call <ResObj> resObjCall, Response<ResObj> response) {
                resObj  = response.body();

                if(response.code()==200){
ResObj r=new ResObj();
                   // JSONArray arr=new JSONArray();

                   Toast.makeText(MainActivity.this, "song search successful", Toast.LENGTH_SHORT).show();
//
count.setText("resultCount: "+r.getResultCount());

                        textView.setText("result: "+r.getResults());


                               } else {
                    Toast.makeText(MainActivity.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
               }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}