package dariabeliaeva.diploma.com.finefin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView;
//import co.moonmonkeylabs.realmrecyclerview.example.models.TodoItem;
import io.realm.Realm;
import io.realm.RealmBasedRecyclerViewAdapter;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.RealmViewHolder;
import io.realm.Sort;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dariabeliaeva.diploma.com.finefin.data_models.Spendings;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private static final int[] COLORS = new int[] {
            Color.argb(255, 28, 160, 170),
            Color.argb(255, 99, 161, 247),
            Color.argb(255, 13, 79, 139),
            Color.argb(255, 89, 113, 173),
            Color.argb(255, 200, 213, 219),
            Color.argb(255, 99, 214, 74),
            Color.argb(255, 205, 92, 92),
            Color.argb(255, 105, 5, 98)
    };

    private Realm realm;
    Date dPicker = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setHideOnContentScrollEnabled(true);
        getSupportActionBar().setTitle("Balance");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buildAndShowInputDialog();
            }

            //Intent myIntent = new Intent(MainActivity.this, AddNoteActivity.class);
            //startActivity(myIntent);
            //Snackbar.make(view, "Add later", Snackbar.LENGTH_LONG)
            //.setAction("Action", null).show();
            //}
        });

        realm = Realm.getInstance(this);





        List<Spendings> spendings = new ArrayList<Spendings>();

        spendings.add(new Spendings(1, "milk", 10, dPicker));
        spendings.add(new Spendings(2, "water", 12, dPicker));
        //spendings.add(new Spendings(3, "soda", 9.5, "09-23-2015", ));
        //spendings.add(new Spendings(4, "juice", 20, "09-23-2012", ));
        //spendings.add(new Spendings(5, "vodka", 90, "12-23-2012", ));

        realm.beginTransaction();
//        for (Spendings sp : spendings) {
            realm.copyToRealmOrUpdate(spendings);
//        }

        realm.commitTransaction();


        /*TextView tvDate = (TextView) findViewById(R.id.tvDate);
        LinearLayout llDate = (LinearLayout) findViewById(R.id.llDate);
        tvDate.setText("09-24-2334");

        LayoutInflater inflater = LayoutInflater.from(this);
        RealmResults<Spendings> result = realm.where(Spendings.class).findAll();
        for (Spendings spendingsItem : result) {
            View view = inflater.inflate(R.layout.date_item, null);
            ((TextView) view.findViewById(R.id.tvPrice)).setText(String.valueOf(spendingsItem.getPrice()));
            ((TextView) view.findViewById(R.id.tvName)).setText(spendingsItem.getName());
            llDate.addView(view);
            System.out.println("LOOP");
        }
        */
        RealmResults<Spendings> spenItems = realm
                .where(Spendings.class)
                .findAll();
        SpenRealmAdapter toDoRealmAdapter = new SpenRealmAdapter(this, spenItems, true, true);
        RealmRecyclerView realmRecyclerView = (RealmRecyclerView) findViewById(R.id.realm_recycler_view);
        realmRecyclerView.setItemViewCacheSize(10);
        realmRecyclerView.setAdapter(toDoRealmAdapter);
    }

    public class SpenRealmAdapter
            extends RealmBasedRecyclerViewAdapter<Spendings, SpenRealmAdapter.ViewHolder> {

        public class ViewHolder extends RealmViewHolder {

            public TextView spenTextView;
            public ViewHolder(FrameLayout container) {
                super(container);
                this.spenTextView = (TextView) container.findViewById(R.id.todo_text_view);
            }
        }

        public SpenRealmAdapter(
                Context context,
                RealmResults<Spendings> realmResults,
                boolean automaticUpdate,
                boolean animateResults) {
            super(context, realmResults, automaticUpdate, animateResults);
        }



        @Override
        public ViewHolder onCreateRealmViewHolder(ViewGroup viewGroup, int viewType) {
            View v = inflater.inflate(R.layout.todo_text_view, viewGroup, false);
            return new ViewHolder((FrameLayout) v);
        }

        @Override
        public void onBindRealmViewHolder(ViewHolder viewHolder, int position) {
            final Spendings spenItem = realmResults.get(position);
            viewHolder.spenTextView.setText(spenItem.getName() + "/t" + spenItem.getPrice());
            viewHolder.itemView.setBackgroundColor(
                    COLORS[(int) (spenItem.getId() % COLORS.length)]
            );
        }



        @Override
        public int getItemCount() {
            return realmResults.size();
        }
    }

    private void buildAndShowInputDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Create New");

        LayoutInflater li = LayoutInflater.from(this);
        View dialogView = li.inflate(R.layout.to_do_dialog_view, null);
        final EditText input = (EditText) dialogView.findViewById(R.id.input);
        final EditText input1 = (EditText) dialogView.findViewById(R.id.input1);

        builder.setView(dialogView);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                addSpenItem(input.getText().toString(), Integer.parseInt(input1.getText().toString()));
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        final AlertDialog dialog = builder.show();
        input.setOnEditorActionListener(
                new EditText.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_DONE ||
                                (event.getAction() == KeyEvent.ACTION_DOWN &&
                                        event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                            dialog.dismiss();
                            addSpenItem(input.getText().toString(), Integer.parseInt(input1.getText().toString()));
                            return true;
                        }
                        return false;
                    }
                });
    }

    private void addSpenItem(String spenItemText, int spenSum) {
        if (spenItemText == null || spenItemText.length() == 0) {

                Toast
                        .makeText(this, "Could not be empty!", Toast.LENGTH_SHORT)
                        .show();
                return;

        }

        realm.beginTransaction();
        Spendings spenItem = realm.createObject(Spendings.class);
        spenItem.setId(System.currentTimeMillis());
        spenItem.setName(spenItemText);
        spenItem.setPrice(spenSum);
        spenItem.setDate(dPicker);

        realm.commitTransaction();
    }
}

