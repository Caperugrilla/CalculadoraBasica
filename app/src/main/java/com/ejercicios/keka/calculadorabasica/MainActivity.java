package com.ejercicios.keka.calculadorabasica;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    EditText etDisplay;
    TextView tvDisplay;
    Double operando1;
    Operacion operacion;
    boolean decimal = false;//Para que se muestre el "." en el TextView
    boolean isPunto = false; //Para que se muestre el "." en el EditText y no me contabilice mas

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDisplay = (EditText) findViewById(R.id.etDisplay);
        tvDisplay = (TextView) findViewById(R.id.tvDisplay);

    }

    public void numeroPulsado(View v) {

        int selección = v.getId();
        String a = tvDisplay.getText().toString();
        Button botonNumerico = (Button) v;
        String sNumero = botonNumerico.getText().toString();
        String sDisplay = etDisplay.getText().toString();
        sDisplay += sNumero;
        if(selección != R.id.punto){
            etDisplay.setText(sDisplay);

        }else{
            if(!isPunto){
                etDisplay.setText(sDisplay);
            }
        }


        try {
            switch (selección) {
                case R.id.num0:
                    tvDisplay.setText(a + "0");
                    break;

                case R.id.num1:
                    tvDisplay.setText(a + "1");
                    break;

                case R.id.num2:
                    tvDisplay.setText(a + "2");
                    break;

                case R.id.num3:
                    tvDisplay.setText(a + "3");
                    break;

                case R.id.num4:
                    tvDisplay.setText(a + "4");
                    break;

                case R.id.num5:
                    tvDisplay.setText(a + "5");
                    break;

                case R.id.num6:
                    tvDisplay.setText(a + "6");
                    break;

                case R.id.num7:
                    tvDisplay.setText(a + "7");
                    break;

                case R.id.num8:
                    tvDisplay.setText(a + "8");
                    break;

                case R.id.num9:
                    tvDisplay.setText(a + "9");
                    break;

                case R.id.punto:
                    if (decimal==false) {
                        if(!isPunto) {
                            tvDisplay.setText(a + ".");
                            isPunto = true;
                        }
                        decimal=true;
                    } else {return;}
                    break;
            }
        }catch(Exception e){
        tvDisplay.setText("ERROR");

        }


    }

    public void operacionPulsada(View v){
        String b = tvDisplay.getText().toString();
        String sOperacion = v.getTag().toString();
        if(sOperacion.equalsIgnoreCase("sumar")){
            operacion = Operacion.SUMAR;
            tvDisplay.setText(b+"+");
            decimal=false;
            isPunto = false;
        }else if (sOperacion.equalsIgnoreCase("restar")){
            operacion = Operacion.RESTAR;
            tvDisplay.setText(b+"-");
            decimal=false;
            isPunto = false;
        }else if (sOperacion.equalsIgnoreCase("multiplicar")){
            operacion=Operacion.MULTIPLICAR;
            tvDisplay.setText(b+"*");
            decimal=false;
            isPunto = false;
        }else if (sOperacion.equalsIgnoreCase("dividir")){
            operacion=Operacion.DIVIDIR;
            tvDisplay.setText(b+"/");
            decimal=false;
            isPunto = false;
        }

        String sNumeros = etDisplay.getText().toString();
        operando1=Double.parseDouble(sNumeros);
        limpiarDisplay();
    }


    public void calcular(View v) {
        String sOperando2 = etDisplay.getText().toString();
        double operando2 = Double.parseDouble(sOperando2);
        double resultado = 0;
        if (operacion == Operacion.SUMAR) {
            resultado = operando1 + operando2;


        } else if (operacion == Operacion.RESTAR) {
            resultado = operando1 - operando2;


        } else if(operacion==Operacion.MULTIPLICAR) {
            resultado = operando1 * operando2;


        } else if(operacion==Operacion.DIVIDIR) {
            resultado = operando1 / operando2;


        }

        etDisplay.setText(String.valueOf(resultado));

    }

    private void limpiarDisplay(){
        etDisplay.setText("");

    }

    public void borrar (View v){
        operando1 =0.0;
        operacion=null;
        tvDisplay.setText("");
        decimal=false;
        isPunto=false;
        limpiarDisplay();
    }
}

