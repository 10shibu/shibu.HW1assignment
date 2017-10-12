package shibu.cs.brandies.edu.intent;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeActivity();
    }

    private void changeActivity() {
        button = (Button) findViewById(R.id.parent);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.parent) {
                    sendMessage(v);
                }
            }
        });
    }

    //send intent to start the utility_activity
    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, UtilityActivity.class);
        //startActivity(intent);
        startActivityForResult(intent,1);

    }
    //get results back and dispaly it
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                Toast.makeText(this, "The last conversion was: "+result, Toast.LENGTH_LONG).show();
            }
        }
    }
}
