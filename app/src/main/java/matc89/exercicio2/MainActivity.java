package matc89.exercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private TextView textView;
    private String textoRetornado; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.btnTrocar);
        textView = (TextView) findViewById(R.id.textView);

        final Bundle extra = getIntent().getExtras();

        textoRetornado = "";

        if (extra != null){
            if (extra.getString("nome").matches("")){
                textView.setText("Oi!");
            }
            else {
                textoRetornado = extra.getString("nome");
                textView.setText("Oi," + " " + textoRetornado + "!");
            }
        }

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String texto ;

                if (extra == null){
                    texto = "";
                } else {
                    texto = extra.getString("nome");
                }

                Intent intent = new Intent(MainActivity.this, OutraActivity.class);
                intent.putExtra("nome", texto );

                startActivity(intent);
            }
        });
    }

    protected void onSaveInstanceState(Bundle state){
        super.onSaveInstanceState(state);
        if (textoRetornado.matches("") || textoRetornado.matches("Oi!")){
            state.putString("nome", "Oi!");
        } else {
            state.putString("nome", " " + textoRetornado + "!");
        }
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        textView.setText(savedInstanceState.getString("nome"));

    }

}
