package rodriguez.daniel.fullscreentests;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;



public class MainActivity extends AppCompatActivity{

    final Handler mHandler = new Handler();
    private Runnable mRunnable;
    private int mInterval = 1000; // milliseconds
    private boolean initialState = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }
    protected void onResume() {
        super.onResume();

        mRunnable = new Runnable() {
            /*
                public abstract void run ()
                    Starts executing the active part of the class' code. This method is
                    called when a thread is started that has been created with a class which
                    implements Runnable.
            */
            @Override
            public void run() {
                // Do the task
                doTask();
            }
        };
                /*
                    public final boolean postDelayed (Runnable r, long delayMillis)
                        Causes the Runnable r to be added to the message queue, to be run after the
                        specified amount of time elapses. The runnable will be run on the thread to
                        which this handler is attached. The time-base is uptimeMillis(). Time spent
                        in deep sleep will add an additional delay to execution.
                */
        // Schedule the task
        mHandler.postDelayed(mRunnable,mInterval);
    }

    public void doTask() {
        if(initialState){
            // Reverse the boolean
            initialState = false;
            // Set the TextView color to red
            setContentView(R.layout.activity_main);
        }else {
            // Reverse the boolean
            initialState = true;
            // Change the TextView color to initial State
            setContentView(R.layout.black);
        }
        // Schedule the task
        mHandler.postDelayed(mRunnable,mInterval);
    }

}