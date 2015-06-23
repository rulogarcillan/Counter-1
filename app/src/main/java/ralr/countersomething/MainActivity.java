package ralr.countersomething;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends BaseActivity {

    TextView txt_count;
    ImageButton ic_restore, ic_edit;
    RelativeLayout up;
    int total = 0;
    int currentapiVersion;
    SharedPreferences.Editor editor;
    SharedPreferences prefs;
    String KEY_PREF_COUNT = "TOTAL";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        up = (RelativeLayout) findViewById(R.id.up);
        txt_count = (TextView) findViewById(R.id.txt_count);
        ic_edit = (ImageButton) findViewById(R.id.ic_edit);
        ic_restore = (ImageButton) findViewById(R.id.ic_restore);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // getSupportActionBar().setHomeButtonEnabled(true);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
        total = prefs.getInt(KEY_PREF_COUNT, 0);
        txt_count.setText(Integer.toString(total));
        currentapiVersion = android.os.Build.VERSION.SDK_INT;

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total = total + 1;
                cambiaValor(total);

            }
        });

        ic_restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total=0;
                cambiaValor(total);
            }
        });

        ic_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyAlertDialogStyle);


                alert.setMessage(R.string.new_value);


                final EditText input = new EditText(MainActivity.this);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                input.setFilters(new InputFilter[] { new InputFilter.LengthFilter(9) });
                alert.setView(input);

                alert.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Editable value = input.getText();
                        if (value.toString().equals(""))
                            total = 0;
                        else
                            total = Integer.parseInt(value.toString());
                        cambiaValor(total);

                    }
                });

                alert.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                });

                alert.show();

            }
        });
    }


    private void cambiaValor(int valor) {

        editor.putInt(KEY_PREF_COUNT, valor);
        editor.commit();
        if (currentapiVersion >= Build.VERSION_CODES.LOLLIPOP) {
            efectoDentro(valor);
        } else {
            txt_count.setText(Integer.toString(valor));
        }

    }

    private void efectoFuera() {


        int cx = (txt_count.getLeft() + txt_count.getRight()) / 2;
        int cy = (txt_count.getTop() + txt_count.getBottom()) / 2;


        int finalRadius = Math.max(txt_count.getWidth(), txt_count.getHeight());


        Animator anim =
                ViewAnimationUtils.createCircularReveal(txt_count, cx, cy, 0, finalRadius);


        txt_count.setVisibility(View.VISIBLE);
        //anim.setDuration(300);
        anim.start();
    }

    private void efectoDentro(final int valor) {
        // get the center for the clipping circle
        // get the center for the clipping circle
        int cx = (txt_count.getLeft() + txt_count.getRight()) / 2;
        int cy = (txt_count.getTop() + txt_count.getBottom()) / 2;


        int initialRadius = txt_count.getWidth();


        Animator anim =
                ViewAnimationUtils.createCircularReveal(txt_count, cx, cy, initialRadius, 0);

        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                txt_count.setVisibility(View.INVISIBLE);
                txt_count.setText(Integer.toString(valor));
                efectoFuera();
            }
        });


        // anim.setDuration(300);
        anim.start();
    }


}
