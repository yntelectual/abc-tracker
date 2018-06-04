package sk.rain.men.abc.tracking.adapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import sk.rain.men.abc.tracking.R;

/**
 * Created by mhorvath on 15.02.2018.
 */

public class ChildCursorAdapter extends CursorAdapter {

    private LayoutInflater cursorInflater;

    public ChildCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
        cursorInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.child_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        if(cursor.getPosition() % 2 == 0) {
            view.setBackgroundResource(R.color.childEven);
        }else{
            view.setBackgroundResource(R.color.childOdd);
        }

        TextView nameText = view.findViewById(R.id.nameListText);
        TextView surnameText = view.findViewById(R.id.surnameListText);
        TextView ageText = view.findViewById(R.id.ageListText);

        nameText.setText(cursor.getString(cursor.getColumnIndex("NAME")));
        surnameText.setText(cursor.getString(cursor.getColumnIndex("SURNAME")));
        ageText.setText(cursor.getString(cursor.getColumnIndex("AGE")));

        ageText.getText();
    }
}
