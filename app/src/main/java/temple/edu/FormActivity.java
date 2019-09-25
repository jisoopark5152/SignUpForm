package temple.edu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import java.text.Normalizer;

public class FormActivity extends AppCompatActivity {

    EditText flname, email, password, passwordconfirm;
    Button save;
    AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        awesomeValidation = new AwesomeValidation( ValidationStyle.BASIC);

        updateUI();
    }

    private void updateUI() {

        flname = (EditText)findViewById(R.id.flname);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        passwordconfirm = (EditText)findViewById(R.id.passwordconfirm);
        save = (Button)findViewById(R.id.save);

        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])";
        awesomeValidation.addValidation(FormActivity.this,R.id.flname, "[a-z][A-Z]",R.string.flnameerr);
        awesomeValidation.addValidation(FormActivity.this,R.id.email, android.util.Patterns.EMAIL_ADDRESS,R.string.emailerr);
        awesomeValidation.addValidation(FormActivity.this,R.id.password,regexPassword,R.string.passworderr);
        awesomeValidation.addValidation(FormActivity.this,R.id.passwordconfirm,R.id.password,R.string.passwordconfirmerr);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (awesomeValidation.validate()) {

                    Toast.makeText(FormActivity.this, "Data Received Successfully", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(FormActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
        }

    });
}
}
