package sk.rain.men.abc.tracking.child;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import sk.rain.men.abc.tracking.AbcMasterDataActivity;
import sk.rain.men.abc.tracking.R;
import sk.rain.men.abc.tracking.SimpleAbcDataFragmentPagerAdapter;
import sk.rain.men.abc.tracking.model.AbcType;

public class AbcChildDataTabActivity extends FragmentActivity {

    public static String CHILD_ID_KEY = "childId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abc_form_data_tab);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.abc_form_viewpager);
        viewPager.setOffscreenPageLimit(3);

        Long childId = getIntent().getLongExtra(CHILD_ID_KEY, -1);

        // Create an adapter that knows which fragment should be shown on each page
        SimpleAbcFormFragmentPagerAdapter adapter = new SimpleAbcFormFragmentPagerAdapter(getSupportFragmentManager(), this, childId);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);


        // Give the TabLayout the ViewPager
        TabLayout tabLayout = findViewById(R.id.abc_form_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void createAntecedent(View view) {
        Intent intent = new Intent(this, AbcMasterDataActivity.class);
        intent.putExtra(AbcMasterDataActivity.ABC_MD_TYPE_MSG, AbcType.Antecedent);
        startActivity(intent);
    }

    public void createBehavior(View view) {
        Intent intent = new Intent(this, AbcMasterDataActivity.class);
        intent.putExtra(AbcMasterDataActivity.ABC_MD_TYPE_MSG, AbcType.Behavior);
        startActivity(intent);
    }

    public void createConsequence(View view) {
        Intent intent = new Intent(this, AbcMasterDataActivity.class);
        intent.putExtra(AbcMasterDataActivity.ABC_MD_TYPE_MSG, AbcType.Consequence);
        startActivity(intent);
    }
}
