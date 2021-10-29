package step.android.sharks_chat;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView message;
    TextView sender;
    TextView time;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        message = itemView.findViewById(R.id.msg_text);
        sender = itemView.findViewById(R.id.msg_username);
        time = itemView.findViewById(R.id.msg_time_send);

    }

}
