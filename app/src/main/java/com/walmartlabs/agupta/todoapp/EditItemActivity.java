package com.walmartlabs.agupta.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends ActionBarActivity {
    EditText etEditText;
    int position;
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        position = getIntent().getIntExtra("position", 0);
        System.out.println("position recieved = " + position);
        value = getIntent().getStringExtra("value");
        etEditText = (EditText) findViewById(R.id.etEditItem);
        etEditText.setText(value);
        etEditText.setSelection(etEditText.getText().length());
    }

    public void onSave(View view){
        String newItemText = etEditText.getText().toString();
        Intent data = new Intent();
        data.putExtra("newItemText", newItemText);
        data.putExtra("position", this.position);
        data.putExtra("code", 20);
        setResult(200, data);
        finish();
    }
}
