package devandroid.debora.tarefadois;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextDescricao;
    private EditText editTextData;

    @SuppressLint("MissingInflateParams")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        editTextDescricao = findViewById(R.id.editTextDescricao);
        editTextData = findViewById(R.id.editTextData);

        Button buttonClear = findViewById(R.id.buttonLimpar);
        buttonClear.setOnClickListener(v -> clearFields());

        Button buttonSave = findViewById(R.id.buttonSalvar);
        buttonSave.setOnClickListener(v -> saveTask());

        Button buttonFinish = findViewById(R.id.buttonFinalizar);
        buttonFinish.setOnClickListener(v -> finishTask());

        Toast.makeText(MainActivity.this,"Voltar", Toast.LENGTH_LONG).show();

    }

    private void clearFields() {
        editTextNome.getText().clear();
        editTextDescricao.getText().clear();
        editTextData.getText().clear();
    }

    private void saveTask() {
        editTextDescricao.getText().toString();
        String dueDate = editTextData.getText().toString();


    }

    private void finishTask() {

    }
}
