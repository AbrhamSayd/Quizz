package com.md.quizz;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class QuizzActivity extends AppCompatActivity {
    public Button btnR1;
    public Button btnR2;
    public Button btnR3;
    public TextView txt;
    public TextView txtQuest;
    public int i = 0;
    public String puntuaje = "0";
    String[][] questions =  {
            {"¿Cual es la capital de china?","Hermosillo","Shangai","Pekín"},
            {"¿Cuantos huesos tiene el cuerpo humano?","32","300","206"},
            {"¿Cuantas arterias tiene el corazon?","1","24","2"},
            {"¿Cul es la poblacion mundial?","8 Millones","3 Millones","7.9 Billones"},
            {"¿Cuanto cuesta una caja misteriosa del cod?","450","800","950"},
            {"¿Cual es el radio del sol?","450km","800km","696,340 km"},
            {"¿En que año nacio hitler","2002","1889","1889"},
            {"¿Ando buscandola en?","Marte","Sonoyta","Nueva York"},
            {"¿Que año es?","1899","2018","2022"},
            {"¿Cuando se creo el primer procesador?","2000","1819","1971"}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        btnR1 = (Button) findViewById(R.id.btnR1);
        btnR2 = (Button) findViewById(R.id.btnR2);
        btnR3 = (Button) findViewById(R.id.btnR3);
        txt = (TextView) findViewById(R.id.quizz);
        txtQuest = (TextView) findViewById(R.id.questions);
        txtQuest.setText(questions[i][0]);
        btnR1.setText(questions[i][1]);
        btnR2.setText(questions[i][2]);
        btnR3.setText(questions[i][3]);

    }


        public void cargarBotones(){
            Random randNum = new Random();
            Set<Integer> set = new LinkedHashSet<Integer>();
            while (set.size() < 3) {
                set.add(randNum.nextInt(3) + 1);
            }

            List<Integer> num = new ArrayList<Integer>(set);

        if (i>questions.length-1){

            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle("Puntuaje")
                    .setMessage("Su puntuaje es: "+ puntuaje)
                    .setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
            builder.show();

        }else{
            txtQuest.setText(questions[i][0]);
            btnR1.setText(questions[i][num.get(0)]);
            btnR2.setText(questions[i][num.get(1)]);
            btnR3.setText(questions[i][num.get(2)]);


        }

    }
    public void verificarDatos(View view){
        int x = Integer.parseInt(puntuaje);
        Button b = (Button)view;
        String resultado = b.getText().toString();
        if (resultado.equals(questions[i][3])){
            x++;
            puntuaje = String.valueOf(x);
            txt.setText(puntuaje);
            i++;
        }else{
        if (x>0){
            x--;
          puntuaje = String.valueOf(x);
          i++;
}
        txt.setText(puntuaje);}
        cargarBotones();
    }


}