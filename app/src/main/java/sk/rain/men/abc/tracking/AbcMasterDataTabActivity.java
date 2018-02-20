package sk.rain.men.abc.tracking;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import sk.rain.men.abc.tracking.model.AbcMasterData;
import sk.rain.men.abc.tracking.model.AbcType;

public class AbcMasterDataTabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abc_master_data_tab);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.abc_data_viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        SimpleAbcDataFragmentPagerAdapter adapter = new SimpleAbcDataFragmentPagerAdapter(getSupportFragmentManager(), this);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.abc_data_tabs);
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
