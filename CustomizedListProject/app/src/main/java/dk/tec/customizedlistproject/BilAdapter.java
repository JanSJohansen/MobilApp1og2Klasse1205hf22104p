package dk.tec.customizedlistproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BilAdapter extends BaseAdapter
{
    ArrayList<Bil> biler;
    Context context;

    public BilAdapter(ArrayList<Bil> biler, Context context)
    {
        this.biler = biler;
        this.context = context;
    }
    @Override
    public int getCount() {
        return biler.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.bil_item_layout, null);

        Bil bil = biler.get(position);

        ImageView img = v.findViewById(R.id.imgBil);
        img.setImageResource(bil.getBilledId());
        TextView txtNavn = v.findViewById(R.id.txtName);
        txtNavn.setText(bil.getName());
        TextView txtDescription = v.findViewById(R.id.txtDescription);
        txtDescription.setText(bil.getBeskrivelse());

        Button btnDelete = v.findViewById(R.id.btnDelete);
        btnDelete.setText("Delete " + bil.getName());

        return v;
    }
}
