package br.com.fiap.rm72468.calculadoradegorjeta;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends ActionBarActivity {

    //formatadores
    NumberFormat formatadorDePorcentagem = NumberFormat.getPercentInstance();
    //NumberFormat formatadorDeMoeda = NumberFormat.getCurrencyInstance();

    //variaveis de componente de tela
    private SeekBar seekBar;
    private TextView lblPorcentagemVariavel;

    private double porcentagemVariavel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblPorcentagemVariavel = (TextView)findViewById(R.id.lblPorcentagemVariavel);
        porcentagemVariavel = 18;
        seekBar = (SeekBar)findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagemVariavel = progress/100.0;
                lblPorcentagemVariavel.setText(formatadorDePorcentagem.format(porcentagemVariavel));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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
