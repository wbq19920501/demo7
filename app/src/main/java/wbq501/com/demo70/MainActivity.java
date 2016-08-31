package wbq501.com.demo70;

import android.app.ActivityOptions;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Rect;
import android.os.PersistableBundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("oncreate","onreate");
        init();
    }

    private void init() {
        one = (Button) findViewById(R.id.one);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Rect bounds = new Rect(500, 300, 100, 0);
                ActivityOptions options = ActivityOptions.makeBasic();
                options.setLaunchBounds(bounds);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT|Intent.FLAG_ACTIVITY_NEW_TASK);
                ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());
            }
        });
        one.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipData data = ClipData.newPlainText(view.getClass().getName(),
                        ((Button) view).getText());
                View.DragShadowBuilder builder = new View.DragShadowBuilder(view);
                view.startDragAndDrop(data, builder, view, View.DRAG_FLAG_GLOBAL);
                return true;
            }
        });
    }

    @Override
    protected void onStart() {
        Log.d("onStart","onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("onResume","onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("onResume","onResume");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("onStop","onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("onDestroy","onDestroy");
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.d("onSaveInstanceState","onSaveInstanceState");
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d("onRestoreInstanceState","onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        prntLog(isInMultiWindowMode+"isInMultiWindowMode");
        super.onMultiWindowModeChanged(isInMultiWindowMode);
    }
    private void prntLog(String log) {
        Log.d("MainActivity", log);
    }
}
