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
public class BaseActivity extends AppCompatActivity {

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
            case R.id.privacy_policy:
                openPrivacy();
                break;
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

    private void openPrivacy() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://info.tuppersoft.com/privacy/privacy_policy_counter.html"));
        startActivity(browserIntent);
    }


    private void LanzaMore() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:Raúl R."));
        startActivity(intent);
        //   overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }
}



