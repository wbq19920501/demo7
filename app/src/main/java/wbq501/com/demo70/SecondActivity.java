package wbq501.com.demo70;

import android.content.ClipData;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by admin on 2016/8/25.
 */
public class SecondActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two);
        final TextView content = (TextView) findViewById(R.id.content);
        findViewById(R.id.content).setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                switch (dragEvent.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        prntLog("drag started");
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        prntLog("drag entered");
                        break;
                    case DragEvent.ACTION_DROP:
                        ClipData.Item item = dragEvent.getClipData().getItemAt(0);
                        content.setText(item.getText());
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        prntLog("drag entered");
                        break;
                }
                return true;
            }
        });
    }
    private void prntLog(String log) {
        Log.d("MainActivity", log);
    }
}
