package step.android.sharks_chat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
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

public class ProgramActivity extends AppCompatActivity {

    EditText mEditTextMessage;
    Button mSendButton;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference msgRef ;
    RecyclerView mMessagesRecycler;

    Message message ;

    String msgStr;

    ArrayList<Message> messages = new ArrayList<>();
    private String currUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);



        Bundle arguments = getIntent().getExtras();

        if(arguments!=null){
            currUsername = arguments.get("currUsername").toString();
        }


        mEditTextMessage = findViewById(R.id.msg_input);
        mSendButton = findViewById(R.id.msg_send_btn);
        mMessagesRecycler = findViewById(R.id.msg_recycler);

        mMessagesRecycler.setLayoutManager(new LinearLayoutManager(this));
        DataAdapter dataAdapter = new DataAdapter(this,messages);
        mMessagesRecycler.setAdapter(dataAdapter);
        msgRef = database.getReference("messages");



        msgRef.addChildEventListener(new ChildEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Message msg = snapshot.getValue(Message.class);
                messages.add(msg);
                dataAdapter.notifyDataSetChanged();
                mMessagesRecycler.smoothScrollToPosition(messages.size());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }

    public void onClickSendMsgBtn(View view) {
        msgStr = Objects.requireNonNull(mEditTextMessage.getText()).toString();

        if(msgStr.equals("")){
            Toast.makeText(getApplicationContext(),"Введите сообщение!", Toast.LENGTH_SHORT).show();
            return;
        }
        message = new Message(currUsername, msgStr);

        msgRef.push().setValue(message);
        mEditTextMessage.setText("");


    }



}