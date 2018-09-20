/*
   ___                  _                    _
  / __\___  _   _ _ __ | |_ ___ _ __     _  / |
 / /  / _ \| | | | '_ \| __/ _ \ '__|  _| |_| |
/ /__| (_) | |_| | | | | ||  __/ |    |_   _| |
\____/\___/ \__,_|_| |_|\__\___|_|      |_| |_|


Copyright (C) 2018  Raúl Rodríguez Concepción www.wepica.com

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package ralr.countersomething;

import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;


/**
 * Created by raul.rodriguezconcep on 20/02/15.
 */
public class BaseActivity  extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.action_settings:
                break;
            case R.id.puntuar:

                LanzaRate();

                break;

            case R.id.more:

                LanzaMore();

                break;
          /*  case R.id.changelog:

                new LanzaChangelog(BaseActivity.this).getFullLogDialog().show();
                break;
            case R.id.license:
                //Create an intent with context and the Activity class

                new Libs.Builder()
                        //Pass the fields of your application to the lib so it can find all external lib information
                        .withFields(R.string.class.getFields())
                        .withVersionShown(true)
                        .withLicenseShown(true)
                        .withAutoDetect(true)
                        .withLibraries("sqliteassethelper")
                        .withActivityTitle(getResources().getString(R.string.license))
                        .withAboutDescription(getResources().getString(R.string.escrita) + "<br/><br/><b>License GNU GPL V3.0</b><br/><br/><a href=\"https://github.com/rulogarcillan/PainLog\">Project in Github</a>")
                        .withActivityTheme(R.style.AppTheme)
                                //start the activity
                        .start(this);
                break;*/


            default:
                onBackPressed();
        }

        return true;
    }

    private void LanzaRate() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=ralr.countersomething"));
        startActivity(intent);
      //  overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }


    private void LanzaMore() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:Raúl R."));
        startActivity(intent);
     //   overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }


  /*  public static class LanzaChangelog extends ChangeLog {


        public static final String DEFAULT_CSS =

                "body {                                                           " + "	font-family: Verdana, Helvetica, Arial, sans-serif;   " + "	font-size: 11px;                                      " + "	color: #000000;                                       " + "	background-color: #ffffff;                            " + "	margin: 0px;                                          " + "	padding: 0px;                                         " + "}                                                        "
                        + "h1 {                                                     " + "	font-size: 14px;                                      " + "	font-weight: bold;                                    " + "	text-transform: uppercase;                            " + "	color: #000000;                                       " + "	margin: 0px;                                          " + "	padding: 10px 0px 0px 8px;                            " + "}                                                        "
                        + "h2 {                                                     " + "	font-size: 10px;                                      " + "	color: #999999;                                       " + "	font-weight: normal;                                  " + "	margin: 0px 0px 0px 8px;                              " + "	padding: 0px;                                         " + "}                                                        " + "ul {                                                     "
                        + "	margin: 0px 0px 10px 15px;                            " + "	padding-left: 15px;                                " + "	padding-top: 8px;                                     " + "	list-style-type: square;                              " + "	color: #999999;                                       " + "}";

        public LanzaChangelog(Context context) {
            super(new ContextThemeWrapper(context, R.style.AppTheme), DEFAULT_CSS);
        }
    }*/

}



