package josim74.github.com.viewmodelandlivedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {
    private MyViewModel viewModel;
    private EditText editText;
    private TextView textView;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        viewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.getmCurrentName().setValue(editText.getText().toString());
            }
        });

        final Observer<String> mObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String s) {
                textView.setText(s);
            }
        };

        viewModel.getmCurrentName().observe(this, mObserver);
    }
}
