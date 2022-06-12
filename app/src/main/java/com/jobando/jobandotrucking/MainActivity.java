package com.jobando.jobandotrucking;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class MainActivity extends AppCompatActivity {
    firebaseConfig configureDB = new firebaseConfig();
    FirebaseFirestore fstore;
    String userID, username, passcode, employeeType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureDB.startConfig(this);
        Button btnlogin = findViewById(R.id.buttonLogin);
        TextView user = findViewById(R.id.usernametxt);
        TextView code = findViewById(R.id.passwordtxt);
        fstore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = fstore.collection("Users").document("adminAccount");

        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                username = value.getString("username");
                passcode = value.getString("password");
                employeeType = value.getString("EmployeeType");
            }
                DI PA GUMAGANA LOGIN
                    NEED ILOOP SA FIREBASE YUNG DATA
                    DAPAT UNIQUE YUNG USERNAME
                    HINDI KO NA GINAWANG COMMENT TO PARA MAKITA AGAD
        });
        btnlogin.setOnClickListener(v->{
            if(user.getText().toString().equals(username)){
                Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(this, "form txtview "+user.getText()+ "from firestore " + username, Toast.LENGTH_SHORT).show();
            }
        });
    }
}