package shibu.cs.brandies.edu.intent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class UtilityActivity extends AppCompatActivity {

    EditText temp,result;
    RadioButton toC;
    RadioButton toF;
    double value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utility);
        temp = (EditText) findViewById(R.id.TemperatureeditText);
        result = (EditText) findViewById(R.id.result);
        //about = (EditText) findViewById(R.id.abouttxt);
        toC = (RadioButton) findViewById(R.id.F2CRadioButton);
        toF = (RadioButton) findViewById(R.id.C2FRadioButton);
        setAbout();
        //convert(findViewById(R.id.convertButton));
    }

    private void setAbout() {
        Button about = (Button) findViewById(R.id.aboutButton);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UtilityActivity.this,"The formula used is f=c*1.8+32",Toast.LENGTH_LONG).show();
            }
        });

    }

    //convert based on user's choice
    public void convert(View v) {
        value = new Double(temp.getText().toString());
        if(toF.isChecked())
            value = c2f(value);
        else
            value = f2c(value);
        result.setText(new Double(value).toString());
    }

    //clear the result content
    public void clearContent(View v) {
        result.setText("");
    }

    //return to homepage
    public void returnHome(View v) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result", ((Double) value).toString());  //set return value as string
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }


    //converter methods
    public static double c2f(double c) {
        return c*1.8+32;
    }
    public static double f2c(double f) {
        return (f-32)/1.8;
    }
}
