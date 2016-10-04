package id.prihantoro.sayurongo;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Wahyu Prihantoro on 04-Oct-16.
 */
@EActivity(R.layout.activity_forget_password)
public class ForgetPasswordActivity extends AppCompatActivity {

    public static final int MINIMUM_LENGTH_PHONE_NUMBER = 7;

    @ViewById
    TextView text;
    @ViewById
    EditText phone;
    @ViewById
    Button confirmButton;

    @AfterViews
    void init() {
        getSupportActionBar().setTitle("LUPA PASSWORD");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Click
    void confirmButton() {
        String phoneNumber = phone.getText().toString();
        if (confirmButton.getText().toString().equals("OK")){
            finish();
        } else {
            if (phoneNumber.length() < MINIMUM_LENGTH_PHONE_NUMBER) {
                Toast.makeText(this, "No. HP tidak valid", Toast.LENGTH_SHORT).show();
            }
            text.setText("Username dan Password anda telah dikirim ke:\n" + phoneNumber);
            phone.setVisibility(View.GONE);
            confirmButton.setText("OK");
        }
    }
}
