package sk.rain.men.abc.tracking.child;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.orm.query.Select;
import com.orm.util.SugarCursor;

import java.util.List;

import sk.rain.men.abc.tracking.AbcMasterDataActivity;
import sk.rain.men.abc.tracking.R;
import sk.rain.men.abc.tracking.adapter.AbcMasterDataCursorAdapter;
import sk.rain.men.abc.tracking.model.AbcForm;
import sk.rain.men.abc.tracking.model.AbcMasterData;
import sk.rain.men.abc.tracking.model.AbcType;


public class ConsequenceChildFragment extends Fragment implements AdapterView.OnItemClickListener {

    private Long childId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_consequence, container, false);

        childId = getArguments().getLong(AbcChildDataTabActivity.CHILD_ID_KEY);
        List<AbcForm> abcForm = AbcForm.find(AbcForm.class, "child_id = " + childId);
        StringBuilder sb = new StringBuilder();
        for (AbcForm aForm : abcForm) {
            sb.append(aForm.getAbcId());
            sb.append(",");
        }

        Cursor cursor = Select.from(AbcMasterData.class).where("type == '" + AbcType.Consequence.name() + "' AND id IN (" + sb.substring(0, sb.length() - 1)  + ")").getCursor();

        AbcMasterDataCursorAdapter cursorAdapter = new AbcMasterDataCursorAdapter(getActivity(), cursor);

        ListView dataListView = view.findViewById(R.id.consequenceListView);
        dataListView.setAdapter(cursorAdapter);
        dataListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        SugarCursor cursor = (SugarCursor) adapterView.getItemAtPosition(i);
        Long abcMasterDataId = cursor.getLong(cursor.getColumnIndex("ID"));
        Intent intent = new Intent(getActivity(), AbcMasterDataActivity.class);
        intent.putExtra(AbcMasterDataActivity.ABC_MD_ID_MSG, abcMasterDataId);
        startActivity(intent);
    }

}
