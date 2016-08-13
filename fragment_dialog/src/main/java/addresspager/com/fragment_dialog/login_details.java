package addresspager.com.fragment_dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by praveen on 08-08-2016.
 */
public class login_details extends DialogFragment {
    onSubmitListener mListener;

    interface onSubmitListener {
        void setOnSubmitListener(View v);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        final View layout_view = inflater.inflate(R.layout.login_details, container);
            Button save = (Button) layout_view.findViewById(R.id.save);
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onSubmitListener lis = (onSubmitListener) getActivity();
                    lis.setOnSubmitListener(layout_view);

                }
            });
        return layout_view;
    }
}
