package josim74.github.com.viewmodelandlivedata;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private MyViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        InputFields inputFields = new InputFields();
        ShowFields showFields = new ShowFields();

        fragmentTransaction.add(R.id.input_fields, inputFields);
        fragmentTransaction.add(R.id.show_fields, showFields);

        fragmentTransaction.commit();

       // myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
    }
}
