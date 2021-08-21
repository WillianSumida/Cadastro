package com.example.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cadastro.model.Formulario;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText nomeEditText;
    private EditText telefoneEditText;
    private EditText emailEditText;
    private CheckBox listaEmailsCheckBox;
    private RadioButton sexoRadioButton;
    private EditText cidadeEditText;
    private Spinner estadoSpinner;
    private Button saveButton;
    private Button clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeEditText = findViewById(R.id.nomeEt);
        telefoneEditText = findViewById(R.id.telefoneEt);
        emailEditText = findViewById(R.id.emailEt);
        listaEmailsCheckBox = findViewById(R.id.listaEmailsCb);
        sexoRadioButton = findViewById(R.id.masculinoRb);
        estadoSpinner = findViewById(R.id.estadoSp);
        cidadeEditText = findViewById(R.id.cidadeEt);

        saveButton = findViewById(R.id.saveBt);
        saveButton.setOnClickListener(this);

        clearButton = findViewById(R.id.clearBt);
        clearButton.setOnClickListener(this);

        //mascara estudar como que funciona
        //com.github.rtoshiro.mflibrary:mflibrary:1.0.0
        SimpleMaskFormatter mask = new SimpleMaskFormatter("NN-NNNNN-NNNN");
        MaskTextWatcher withMask = new MaskTextWatcher(telefoneEditText, mask);
        telefoneEditText.addTextChangedListener(withMask);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.saveBt){
            String nome = this.nomeEditText.getText().toString();
            String telefone = this.telefoneEditText.getText().toString();
            String email = this.emailEditText.getText().toString();
            Boolean listaEmails = this.listaEmailsCheckBox.isChecked() ? true : false;
            String sexo = this.sexoRadioButton.isChecked() ? "masculino" : "feminino";
            String cidade = this.cidadeEditText.getText().toString();
            String estado = ((TextView) this.estadoSpinner.getSelectedView()).getText().toString();

            Formulario form = new Formulario(nome, telefone, email, listaEmails, sexo, cidade, estado);
            String verificador = isEmpty(form);

            if(verificador.equals("")) {
                Toast.makeText(this, form.toString(), Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this, verificador, Toast.LENGTH_LONG).show();
            }

        }
        else{
            nomeEditText.getText().clear();
            telefoneEditText.getText().clear();
            emailEditText.getText().clear();
            listaEmailsCheckBox.setChecked(false);
            sexoRadioButton.setChecked(true);
            cidadeEditText.getText().clear();
            estadoSpinner.setSelection(0);
        }
    }

    public String isEmpty(Formulario form){
        StringBuilder aviso = new StringBuilder();
        if (form.getNome().equals("")) aviso.append("Preencha o nome");
        if (form.getTelefone().equals("")) aviso.append("\nPreencha o telefone");
        if (form.getEmail().equals("")) aviso.append("\nPreencha o email");
        if (form.getCidade().equals("")) aviso.append("\nPreencha a cidade ");
        return aviso.toString();
    }
}