package g313.gusev.lab06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    EditText txtTitle, txtContent;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtTitle = findViewById(R.id.editTitle);
        txtContent = findViewById(R.id.editContent);

        Intent intent = getIntent();
        pos = intent.getIntExtra("my-note-index", -1);
        txtTitle.setText(intent.getStringExtra("my-note-title"));
        txtContent.setText(intent.getStringExtra("my-note-content"));
    }

    public void onCancelClick(View v) {
        finish();
    }

    public void onOkClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("my-note-index", pos);
        intent.putExtra("my-note-title", txtTitle.getText().toString());
        intent.putExtra("my-content-title", txtContent.getText().toString());

        setResult(RESULT_OK, intent);
        finish();
    }
}