package id.prihantoro.sayurongo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import id.prihantoro.sayurongo.fragment.FragmentDrawer;
import id.prihantoro.sayurongo.model.User;
import id.prihantoro.sayurongo.prefs.UserData;
import id.prihantoro.sayurongo.utils.DrawerNavigator;

/**
 * Created by Wahyu Prihantoro on 15-Sep-16.
 */
@EActivity(R.layout.activity_edit_profile)
public class EditProfileActivity extends AppCompatActivity {
    public static final int REQUEST_IMAGE_CAPTURE = 1;
    @ViewById
    Toolbar toolbar;
    UserData userData = new UserData();
    @Bean
    DrawerNavigator navigator;
    @ViewById
    Spinner spinner;
    @ViewById
    EditText name;
    @ViewById
    EditText phone;
    @ViewById
    EditText password;
    @ViewById
    ImageView image;
    @ViewById
    RadioButton pembeli;
    @ViewById
    RadioButton penjual;

    private long id;
    private User user;
    private Bitmap currentBitmap;
    private String currentPhotoBase64;
    private FragmentDrawer drawerFragment;

    public static Bitmap decodeBase64(String input) {
        byte[] decodedBytes = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }

    @AfterViews
    void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("UBAH PROFIL");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.role_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setVisibility(View.GONE);
        id = UserData.getInstance().getId(this);
        if (id != -1) {
            user = User.findById(User.class, id);
        }
        if (user != null) {
            name.setText(user.name);
            phone.setText(user.phone);
            password.setText(user.password);
            if (user.photo != null && !user.photo.isEmpty()) {
                image.setImageBitmap(decodeBase64(user.photo));
            }
        }
        if (UserData.getInstance().isSeller(this)){
            penjual.setChecked(true);
            pembeli.setChecked(false);
        } else {
            pembeli.setChecked(true);
            penjual.setChecked(false);
        }
        pembeli.setEnabled(false);
        penjual.setEnabled(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Click
    void ok() {
        user.name = name.getText().toString();
        user.phone = phone.getText().toString();
        user.password = password.getText().toString();
        user.save();
        finish();
    }

    @Click
    public void editPhoto() {
        Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, getCaptureImageOutputUri());
        if (takePhotoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePhotoIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Uri uri = getPickImageResultUri(data);
            CropImage.activity(uri)
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .start(this);
        } else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                try {
                    Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), resultUri);
                    currentBitmap = imageBitmap;
                    image.setImageBitmap(imageBitmap);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    imageBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    currentPhotoBase64 = Base64.encodeToString(byteArray, Base64.NO_WRAP);
                    user.photo = currentPhotoBase64;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
                Log.d("error", error.getMessage());
            } else {
                Log.d("error", requestCode + "");
            }

        }
    }

    public Uri getPickImageResultUri(Intent data) {
        boolean isCamera = true;
        if (data != null && data.getData() != null) {
            String action = data.getAction();
            isCamera = action != null && action.equals(MediaStore.ACTION_IMAGE_CAPTURE);
        }
        return isCamera ? getCaptureImageOutputUri() : data.getData();
    }

    private Uri getCaptureImageOutputUri() {
        Uri outputFileUri = null;
        File getImage = getExternalCacheDir();
        if (getImage != null) {
            outputFileUri = Uri.fromFile(new File(getImage.getPath(), "pickImageResult.jpeg"));
        }
        return outputFileUri;
    }
}