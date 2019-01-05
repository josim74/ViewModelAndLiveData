package josim74.github.com.viewmodelandlivedata;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFields extends Fragment {
    private MyViewModel viewModel;
    private EditText etName;
    private Button btnSet;
    private View view;


    public InputFields() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_input_fields, container, false);
        etName = view.findViewById(R.id.et_name);
        btnSet = view.findViewById(R.id.btn_set);
        viewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = etName.getText().toString();
                viewModel.getmCurrentName().setValue(str);
            }
        });

        return view;

    }

}
