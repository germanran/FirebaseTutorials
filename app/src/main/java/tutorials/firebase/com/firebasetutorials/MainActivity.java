package tutorials.firebase.com.firebasetutorials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button mFirebaseBtn;
    private DatabaseReference mDatabase;
    private EditText mUsername;
    private EditText mEmail;
    private EditText mAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mFirebaseBtn = (Button) findViewById(R.id.firebase_button);
        mUsername = (EditText) findViewById(R.id.Username_editText);
        mEmail = (EditText) findViewById(R.id.email_editText);
        mAge = (EditText) findViewById(R.id.age_editText2);

        mFirebaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = mUsername.getText().toString();
                String email = mEmail.getText().toString();
                String age = mAge.getText().toString();

                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("Name", username);
                hashMap.put("Email", email);
                hashMap.put("Age", age);

                mUsername.setText("");
                mEmail.setText("");
                mAge.setText("");
                mDatabase.push().setValue(hashMap);
            }
        });
    }
}
