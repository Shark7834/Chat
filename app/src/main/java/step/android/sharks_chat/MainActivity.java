package step.android.sharks_chat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    String nameStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_name);
        etName = findViewById(R.id.input_username);


    }

    public void onClickSendNameBtn(View view) {
        nameStr= etName.getText().toString();
        if(!nameStr.equals(""))
        {
            Intent intent = new Intent(this, ProgramActivity.class);
            intent.putExtra("currUsername", etName.getText().toString());
            startActivity(intent);

        }
        else
        {
            Toast.makeText(getApplicationContext(),"Введите имя!",Toast.LENGTH_SHORT).show();
        }
    }



}