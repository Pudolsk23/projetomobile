package devandroid.debora.tarefadois.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import devandroid.debora.tarefadois.R;

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

        Button buttonLimpar = findViewById(R.id.buttonLimpar);
        buttonLimpar.setOnClickListener(v -> LimparTare());

        Button buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonSalvar.setOnClickListener(v -> saveTarefa());

        Button buttonFinalizar = findViewById(R.id.buttonFinalizar);
        buttonFinalizar.setOnClickListener(v -> finaltarefa());

    }

    private void LimparTare() {
        editTextNome.getText().clear();
        editTextDescricao.getText().clear();
        editTextData.getText().clear();
    }

    private void saveTarefa() {
        String nome = editTextNome.getText().toString();
        String descricao = editTextDescricao.getText().toString();
        String data = editTextData.getText().toString();
        Toast.makeText(MainActivity.this, "Anotação salva", Toast.LENGTH_SHORT).show();
    }

    private void finaltarefa() {
        Toast.makeText(MainActivity.this, "Tarefa finalizada", Toast.LENGTH_SHORT).show();

    }
}
