package sk.rain.men.abc.tracking.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.TextView;

import sk.rain.men.abc.tracking.R;

/**
 * Created by mhorvath on 15.02.2018.
 */

public class AbcMasterDataCursorAdapter extends CursorAdapter {

    private LayoutInflater cursorInflater;

    public AbcMasterDataCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
        cursorInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        //return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_multiple_choice, parent, false);
        return LayoutInflater.from(context).inflate(R.layout.abc_master_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        if(cursor.getPosition() % 2 == 0) {
            view.setBackgroundResource(R.color.childEven);
        }else{
            view.setBackgroundResource(R.color.childOdd);
        }

        //CheckedTextView text1 = view.findViewById(android.R.id.text1);
        //text1.setText(cursor.getString(cursor.getColumnIndex("NAME")));

        TextView abcNameText = view.findViewById(R.id.abcNameListText);
        TextView abcDescText = view.findViewById(R.id.abcDescListText);

        abcNameText.setText(cursor.getString(cursor.getColumnIndex("NAME")));
        abcDescText.setText(cursor.getString(cursor.getColumnIndex("DESCRIPTION")));
    }
}
