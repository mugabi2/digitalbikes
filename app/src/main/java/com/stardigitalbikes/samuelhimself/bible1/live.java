package com.stardigitalbikes.samuelhimself.bible1;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class live extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private static final String KEY_TITLE = "africa";
    private static final String KEY_DESCRIPTION = "description";

    private EditText editTextTitle;
    private EditText editTextDescription,num;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);

        editTextTitle = findViewById(R.id.edit_text_title);
        num = findViewById(R.id.edit_text_num);
    }

    public void saveNote(View v) {
        String title = editTextTitle.getText().toString();
        String description = num.getText().toString(), one="dareslam",two ="500";
        Map<String, Object> bracket = new HashMap<>();
        bracket.put(title, description);
        bracket.put(one, two);

        db.collection("BVSMUK").document("population").set(bracket)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(live.this, "Note saved", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(live.this, "Error!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());
                    }
                });
    }
}
