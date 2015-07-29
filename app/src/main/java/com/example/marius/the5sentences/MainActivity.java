package com.example.marius.the5sentences;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;



public class MainActivity extends ActionBarActivity {

    String [] sentences;
    ListView listview;


 int pos;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




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



    private void displayMessage(String message){


        TextView transTxt= (TextView) findViewById(R.id.translated);
        transTxt.setText(message);
    }


    public void next(View view){
        setContentView(R.layout.number_1);

        listview=(ListView)findViewById(R.id.lvSentence);
        sentences = getResources().getStringArray(R.array.sentences);
        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                sentences);
        listview.setAdapter(adapter);


        listview.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                pos=position;
                String transTxt,ed1;

               // if i remove this two lines the app works fine
                EditText et1= (EditText) findViewById(R.id.name);
                ed1=et1.getText().toString();


                switch (pos)
                {
                    case 0:
                        //when the ed1 is on the string, the app crash, if not works fine

                        transTxt="Hola mi nombre es: "+ed1;
                        displayMessage(transTxt);
                        break;
                    case 1:
                        transTxt="¿Podrias ayudarme?";
                        displayMessage(transTxt);
                        break;
                    case 2:
                        transTxt="Necesito ir al baño";
                        displayMessage(transTxt);
                        break;
                    case 3:
                        transTxt="Yo soy "+ed1+" y mi amigo es Pedro";
                        displayMessage(transTxt);
                        break;
                    case 4:
                        transTxt="¿Que hora es?";
                        displayMessage(transTxt);
                        break;




                }
            }
        });


    }

}
