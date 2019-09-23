package matc89.exercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OutraActivity extends AppCompatActivity {

    private Button botao;
    private Button botaoRetorno;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);

        botao = (Button) findViewById(R.id.btnConfirmar);
        botaoRetorno = (Button) findViewById(R.id.btnCancelar);
        editText = (EditText) findViewById(R.id.editText);

        final Bundle extra = getIntent().getExtras();
        editText.setText(extra.getString("nome"));

        botaoRetorno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textoRetornado = extra.getString("nome");

                Intent intent = new Intent(OutraActivity.this, MainActivity.class);
                intent.putExtra("nome", textoRetornado);

                startActivity(intent);
            }
        });

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String texto = editText.getText().toString();
                Intent intent = new Intent(OutraActivity.this, MainActivity.class);

                if (texto.matches("")) {
                    intent.putExtra("nome", "");
                } else {
                    intent.putExtra("nome", texto);
                }

                startActivity(intent);

            }
        });
    }
}
