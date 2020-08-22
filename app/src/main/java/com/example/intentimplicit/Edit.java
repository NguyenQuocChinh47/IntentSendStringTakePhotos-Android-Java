package com.example.intentimplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit extends AppCompatActivity {
    EditText edtEdit;
    Button btnEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        edtEdit = findViewById(R.id.edt_Edit);
        btnEdit = findViewById(R.id.btn_Edit);
        editName();
    }

    private void editName() {
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editname = edtEdit.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("tenmoine", editname);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}