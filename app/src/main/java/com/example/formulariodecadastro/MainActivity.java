package com.example.formulariodecadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText nome, idade;
    private RadioButton masculino, feminino;
    private TextView resultadoNome, resultadoIdade, resultadoSexo;

    public MainActivity() {
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.editNome);
        idade = findViewById(R.id.editIdade);
        masculino = findViewById(R.id.radioButtonMasculino);
        feminino = findViewById(R.id.radioButtonFeminio);
        resultadoNome= findViewById(R.id.resultado_Nome);
        resultadoIdade= findViewById(R.id.resultado_Idade);
        resultadoSexo= findViewById(R.id.resultado_Sexo);
        Button botaoCadastrar = findViewById(R.id.buttonCadastrar);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String editNome = nome.getText().toString();
                String editIdade = idade.getText().toString();

                if(editNome.isEmpty() || editIdade.isEmpty())
                {
                    Snackbar.make(v,"Preencha o nome e a idade ", Snackbar.LENGTH_INDEFINITE ).show();
                }
                else
                {
                    RadioButtonSelecionado(v);
                }

            }
        });
    }

    private void RadioButtonSelecionado(View view) {

        String editNome = nome.getText().toString();
        String editIdade = idade.getText().toString();

        if (feminino.isChecked()) {
            resultadoNome.setText(editNome);
            resultadoIdade.setText(editIdade);
            resultadoSexo.setText("SEXO: FEMININO");

        } else if(masculino.isChecked()) {
            resultadoNome.setText(editNome);
            resultadoIdade.setText(editIdade);
            resultadoSexo.setText("SEXO: MASCULINO");

        }
        else{
            Snackbar.make(view,"Coloque o seu sexo",Snackbar.LENGTH_SHORT).show();
        }
    }
}