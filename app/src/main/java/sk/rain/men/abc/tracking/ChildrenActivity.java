package sk.rain.men.abc.tracking;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.orm.query.Condition;
import com.orm.query.Select;
import com.orm.util.SugarCursor;

import java.util.List;

import sk.rain.men.abc.tracking.adapter.ChildCursorAdapter;
import sk.rain.men.abc.tracking.model.Child;

public class ChildrenActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    public static final String CHILD_MESSAGE = "sk.abc.CHILD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children);
        //List<Child> children = Child.listAll(Child.class);
        Cursor cursor = Select.from(Child.class).getCursor();
        ChildCursorAdapter cursorAdapter = new ChildCursorAdapter(this, cursor);

        ListView childListView = findViewById(R.id.childListView);
        childListView.setAdapter(cursorAdapter);
        childListView.setOnItemClickListener(this);
        childListView.setOnItemLongClickListener(this);
    }

    public void createChild(View view) {
        Intent intent = new Intent(this, ChildActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        SugarCursor cursor = (SugarCursor) adapterView.getItemAtPosition(i);

        Toast.makeText(this, cursor.getString(cursor.getColumnIndex("NAME")), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        SugarCursor cursor = (SugarCursor) adapterView.getItemAtPosition(i);
        Long childId = cursor.getLong(cursor.getColumnIndex("ID"));
        Intent intent = new Intent(this, ChildActivity.class);
        intent.putExtra(CHILD_MESSAGE, childId);
        startActivity(intent);

        return true;
    }
}
