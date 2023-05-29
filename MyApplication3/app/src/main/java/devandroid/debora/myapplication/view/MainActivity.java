package devandroid.debora.myapplication.view;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import devandroid.debora.myapplication.R;

public class MainActivity extends AppCompatActivity {

        private EditText editTextNome;
        private EditText editTextQuantidade;
        private EditText editTextLocal;
        private ListView listItems;
        private List<String> itemList;
        private ArrayAdapter<String> adaptar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);


                editTextNome = findViewById(R.id.editTextNome);
                editTextQuantidade = findViewById(R.id.editTextQuantidade);
                editTextLocal = findViewById(R.id.editTextLocal);
                Button buttonLimpar = findViewById(R.id.buttonLimpar);
                Button buttonSalvar = findViewById(R.id.buttonSalvar);
                Button buttonFinalizar = findViewById(R.id.buttonFinalizar);
                listItems = findViewById(R.id.listItems);


                itemList = new ArrayList<>();
                adaptar = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
                listItems.setAdapter(adaptar);


                buttonLimpar.setOnClickListener(v -> clearFields());


                buttonSalvar.setOnClickListener(v -> saveItem());


                buttonFinalizar.setOnClickListener(v -> finalizeItem());


                listItems.setOnItemClickListener((parent, view, position, id) -> {
                        String item = itemList.get(position);
                        Toast.makeText(MainActivity.this, "Item selecionado: " + item, Toast.LENGTH_SHORT).show();
                });
        }

        private void clearFields() {
                editTextNome.setText("");
                editTextQuantidade.setText("");
                editTextLocal.setText("");
        }

        private void saveItem() {
                String nome = editTextNome.getText().toString();
                String quantidade = editTextQuantidade.getText().toString();
                String local = editTextLocal.getText().toString();

                if (!nome.isEmpty() && !quantidade.isEmpty() && !local.isEmpty()) {
                        String item = nome + " - " + quantidade + " - " + local;
                        itemList.add(item);
                        adaptar.notifyDataSetChanged();
                        clearFields();
                } else {
                        Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }
        }

        private void finalizeItem() {
                int selecionarItemsPosicao = listItems.getCheckedItemPosition();
                if (selecionarItemsPosicao != AdapterView.INVALID_POSITION) {
                        itemList.remove(selecionarItemsPosicao);
                        adaptar.notifyDataSetChanged();
                        listItems.clearChoices();
                } else {
                        Toast.makeText(this, "Tarefa finalizada", Toast.LENGTH_SHORT).show();
                }
        }
}
