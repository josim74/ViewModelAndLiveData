package josim74.github.com.viewmodelandlivedata;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowFields extends Fragment {
    private MyViewModel viewModel;
    private View view;
    private TextView tvName, tvAge, tvPhone;


    public ShowFields() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_show_fields, container, false);
        tvName = view.findViewById(R.id.tv_name);
        viewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        final Observer<String> mObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String s) {
                tvName.setText(s);
            }
        };

        viewModel.getmCurrentName().observe(getActivity(), mObserver);

        return view;
    }

}
