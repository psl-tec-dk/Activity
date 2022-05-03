package tec.psl.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnGoToSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGoToSecond = findViewById(R.id.btnGoToSecond);
        btnGoToSecond.setOnClickListener( v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("greeting", "Hilsen fra Main...");
            //startActivity(intent);
            startActivityForResult(intent, 2);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2) {
            if(resultCode == RESULT_OK) {
                Toast.makeText(this, "data: " + data.getIntExtra("theAnswer", -1), Toast.LENGTH_SHORT).show();
            }
        }
    }
}