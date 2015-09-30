package br.com.fiap.rm72468.calculadoradegorjeta;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends ActionBarActivity {

    //formatadores
    NumberFormat formatadorDePorcentagem = NumberFormat.getPercentInstance();
    NumberFormat formatadorDeMoeda = NumberFormat.getCurrencyInstance();

    //variaveis de componente de tela
    private SeekBar seekBar;
    private TextView lblPorcentagemVariavel;
    private TextView lblPorcentagemPadrao;

    private double porcentagemVariavel = 0.18;
    private double porcentagemPadrao = 0.1;
    private double valor = 0.0;


    private EditText txtValor;
    private TextView lblGorjetaVariavel;
    private TextView lblTotalPagarGorjetaVariavel;
    private TextView lblGorjetaPadrao;
    private TextView lblTotalPagarGorjetaPadrao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblPorcentagemPadrao = (TextView)findViewById(R.id.lblPorcentagemPadrao);
        lblPorcentagemVariavel = (TextView)findViewById(R.id.lblPorcentagemVariavel);
        lblGorjetaVariavel = (TextView)findViewById(R.id.lblGorjetaVariavel);
        lblTotalPagarGorjetaVariavel = (TextView)findViewById(R.id.lblTotalPagarGorjetaVariavel);
        lblGorjetaPadrao = (TextView)findViewById(R.id.lblGorjetaPadrao);
        lblTotalPagarGorjetaPadrao = (TextView)findViewById(R.id.lblTotalPagarGorjetaPadrao);
        txtValor = (EditText)findViewById(R.id.txtValor);
        txtValor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    valor = Double.parseDouble(s.toString());
                }catch (NumberFormatException e){
                    valor = 0.0;
                }
                atualizarPorcentagemVariavel();
                atualizarPorcentagemPadrao();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        lblPorcentagemPadrao.setText(formatadorDePorcentagem.format(porcentagemPadrao));

        seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagemVariavel = progress/100.0;
                lblPorcentagemVariavel.setText(formatadorDePorcentagem.format(porcentagemVariavel));
                atualizarPorcentagemVariavel();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void atualizarPorcentagemVariavel() {
        double gorjetaVariavel = valor * porcentagemVariavel;
        double total = valor + gorjetaVariavel;
        lblGorjetaVariavel.setText(formatadorDeMoeda.format(gorjetaVariavel));
        lblTotalPagarGorjetaVariavel.setText(formatadorDeMoeda.format(total));
    }
    private void atualizarPorcentagemPadrao() {
        double gorjetaPadrao = valor * porcentagemPadrao;
        double total = valor + gorjetaPadrao;
        lblGorjetaPadrao.setText(formatadorDeMoeda.format(gorjetaPadrao));
        lblTotalPagarGorjetaPadrao.setText(formatadorDeMoeda.format(total));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
