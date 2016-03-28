package dariabeliaeva.diploma.com.finefin;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        final TextView editTxt = (TextView) findViewById(R.id.tvData);

        final DatePickerDialog dpDlg = new DatePickerDialog(AddNoteActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                editTxt.setText(String.valueOf(dayOfMonth)+"."+String.valueOf(monthOfYear));
            }
        }, 0, 0, 0
        );

        editTxt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dpDlg.show();

            }
        });

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tabSpec;

        //create tab and specify tag
        tabSpec = tabHost.newTabSpec("tag1");
        //tab name
        tabSpec.setIndicator("Outcomes");
        //set id from FrameLayout, it is the container
        tabSpec.setContent(R.id.tab1);
        // add to main element
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        // указываем название и картинку
        // в нашем случае вместо картинки идет xml-файл,
        // который определяет картинку по состоянию вкладки
        tabSpec.setIndicator("Вкладка 2", getResources().getDrawable(R.drawable.tab_icon_selector));
        tabSpec.setContent(R.id.tab2);
        tabHost.addTab(tabSpec);

        // создаем View из layout-файла
        View v = getLayoutInflater().inflate(R.layout.tab_header, null);
        // и устанавливаем его, как заголовок
        tabSpec.setIndicator(v);
        tabSpec.setContent(R.id.tab1);
        tabHost.addTab(tabSpec);

        // вторая вкладка будет выбрана по умолчанию
        tabHost.setCurrentTabByTag("tag1");

        // обработчик переключения вкладок
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            public void onTabChanged(String tabId) {
                Toast.makeText(getBaseContext(), "tabId = " + tabId, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);//Menu Resource, Menu
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
