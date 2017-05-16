package base;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.apec.dispatcher.R;


/**
 * @author Alejandro Platas Mallo
 * @version 1.00
 * @since 18/5/15
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        toolBar = (Toolbar) this.findViewById(R.id.toolbar);
        toolBar.setTitleTextColor(this.getColor(R.color.textColor));
        if (toolBar != null) {
            setSupportActionBar(toolBar);
            if (getSupportActionBar() != null) {
                setDisplayHomeEnabled(true);
            }
        }
    }

    protected abstract int getLayoutResource();

    public void setDisplayHomeEnabled(boolean b) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(b);
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        toolBar.setTitle(title);
    }

    @Override
    public void setTitle(int titleId) {
        toolBar.setTitle(titleId);
    }

    public Toolbar getToolBar() {
        return toolBar;
    }


}
