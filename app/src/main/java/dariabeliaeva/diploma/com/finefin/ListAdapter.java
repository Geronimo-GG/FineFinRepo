package dariabeliaeva.diploma.com.finefin;
/*
public class ListAdapter extends BaseAdapter {
    Context context;
    ArrayList aL;
    int count = 0;
    int limit;
    private LayoutInflater inflater = null;

    public ListAdapter(Context context, ArrayList aL, int size) {
        this.context = context;
        this.aL = aL;
        this.limit = size;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return limit;
    }

    @Override
    public Object getItem(int position) {
        return this.aL.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;

        LinearLayout lL = null;
        if (vi == null) {
            vi = inflater.inflate(R.layout.list_item,
                    null); //Layout of an item of a ListView
        }

        lL= (LinearLayout) vi.findViewById(R.id.linearLayoutList);

        TextView data = (TextView) lL.findViewById
                (R.id.textListItem); //A textView in item of ListView
        ImageView memberIcon =
                (ImageView) lL.findViewById(R.id.maleOrFemale); // An ImageView in
        // item of the ListView

        ArrayList savedPositions = db.getTempData(); // Get some Flgs from Database

        List<Integer> loanDepositAmount =
                db.getLoanInfoOfMembers(); // Get loan amounts of members

        //CHANGE IT TO CATEGORIES
        List<String> genderList =
                db.getAllGenderOfMembers();// Get genders of the members
        for (int i = 0; i < genderList.size(); i++) {
            if (position == i) {
                String maleOrFemale = "";
                try {
                    maleOrFemale = genderList.get(position).toString();
                } catch (Exception e) {
                    e.toString();
                }
                if (maleOrFemale.equals("Female")) {
                    memberIcon.setBackgroundResource(R.drawable.female); //Set Female image
                } else {
                    memberIcon.setBackgroundResource(R.drawable.male); // Set Male Image
                }
                if (newMembers.get(position).toString().contains("New")) {
                    data.setTextColor(Color.parseColor
                            ("#086A87"));//Change the text color of new members
                }
                if (position == loanDepositAmount.get(i)) {
                    data.setTextColor(Color.parseColor
                            ("#FE2E2E")); //Mark red to the members
                    //those have loan dues
                }
            }
        }

        for (int i = 0; i < savedPositions.size(); i++) {
            if (position == Integer.parseInt(savedPositions.get(i)
                    .toString())) {
                rL.setBackgroundDrawable(new ColorDrawable(Color
                        .parseColor("#31B404")));//Change Background to
                //Green for the previously saved members
            }
        }

        data.setText(newMembers.get(position).toString());

        return vi;
    }
}
*/