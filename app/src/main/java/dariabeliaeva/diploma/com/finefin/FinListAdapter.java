package dariabeliaeva.diploma.com.finefin;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

import dariabeliaeva.diploma.com.finefin.data_models.Spendings;

/**
 * Created by andrew on 28.03.16.
 */
public class FinListAdapter extends RecyclerView.Adapter<FinListAdapter.SpendingsViewHolder> {

    ArrayList<Spendings> spendings = new ArrayList<>();
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


    FinListAdapter(){}

    @Override
    public SpendingsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = View.inflate(parent.getContext(), R.layout.todo_text_view, null);
        return new SpendingsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SpendingsViewHolder holder, int position) {
        Spendings spenItem = spendings.get(position);
        holder.spenTextView.setText(spenItem.getName() + "/t" + spenItem.getPrice());
        holder.spenTextView.setBackgroundColor(
                COLORS[(int) (spenItem.getId() % COLORS.length)]
        );
    }

    @Override
    public int getItemCount() {
        return spendings.size();
    }

    public ArrayList<Spendings> getSpendings() {
        return spendings;
    }

    public void setSpendings(ArrayList<Spendings> spendings) {
        this.spendings = spendings;
        notifyItemRangeChanged(0, spendings.size());
    }

    public void removeSpending(int position){
        this.spendings.remove(position);
        notifyItemRemoved(position);
    }

    public void addSpending(Spendings spending){
        this.spendings.add(spending);
        notifyItemInserted(spendings.indexOf(spending));
    }

    class SpendingsViewHolder extends RecyclerView.ViewHolder {

        public TextView spenTextView;
        public SpendingsViewHolder(View rootView) {
            super(rootView);
            this.spenTextView = (TextView) rootView.findViewById(R.id.todo_text_view);
        }
    }
}
