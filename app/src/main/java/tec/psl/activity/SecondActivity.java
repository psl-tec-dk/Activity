package tec.psl.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private Button btnBack;
    private TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtMessage = findViewById(R.id.txtMessage);

        Intent intent = getIntent();
        Toast.makeText(this, intent.getStringExtra("greeting"), Toast.LENGTH_SHORT).show();

        txtMessage.setText(intent.getStringExtra("greeting"));

        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener( v -> {
            intent.putExtra("msgfromsecond", "Alles gut...");
            intent.putExtra("theAnswer", 42);
            setResult(RESULT_OK, intent);
            finish();
        });

    }
}