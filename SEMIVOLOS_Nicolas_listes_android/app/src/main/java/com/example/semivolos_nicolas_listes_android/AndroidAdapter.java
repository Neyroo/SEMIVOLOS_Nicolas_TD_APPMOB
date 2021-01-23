package com.example.semivolos_nicolas_listes_android;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



import java.util.ArrayList;

public class AndroidAdapter extends ArrayAdapter {
    private final ArrayList<Androidversion> AndroidVersionList;
    private final Context context;
    private final int viewRes;
    private final Resources res;

    public AndroidAdapter(Context context, int textViewResourceId, ArrayList<Androidversion> versions) {
        super(context, textViewResourceId, versions);
        this.AndroidVersionList = versions;
        this.context = context;
        this.res = context.getResources();
        this.viewRes = textViewResourceId;
    }

    static class ViewHolder {
        TextView title;
        TextView description;
    }
    @Override //Il faut implémenter getView ici
    public View getView(int position, View ConvertView, ViewGroup parent) {
        View view = ConvertView;
        ViewHolder holder;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes, parent, false);
            holder = new ViewHolder();
            holder.title= (TextView) view.findViewById(R.id.title);
            holder.description = (TextView) view.findViewById(R.id.description);
            view.setTag(holder);
        } else {
            holder= (ViewHolder) view.getTag();
        }
        final Androidversion androidVersion = AndroidVersionList.get(position);
        if (androidVersion != null) {
            final String versionName = String.format("Nom de la version : %s", androidVersion.getVersionName());
            holder.title.setText(versionName);
            final String versionNumber = String.format("Numéro de la version : %s", androidVersion.getVersionNumber());
            holder.description.setText(versionNumber);
        }
        return view;
    }
    //Nombre d’éléments de la liste
    public int getCount() {
        return AndroidVersionList.size();
    }
} //Fin de la classe Adapter
