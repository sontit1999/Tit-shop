package com.example.titshop.fragment.shipping;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.example.titshop.R;
import com.example.titshop.base.BaseFragment;
import com.example.titshop.callback.ActionbarListener;
import com.example.titshop.databinding.FragShippingBinding;

public class ShippingFragment extends BaseFragment<FragShippingBinding,ShippingViewModel> {
    ActionbarListener listener;
    @Override
    public Class<ShippingViewModel> getViewmodel() {
        return ShippingViewModel.class;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (ActionbarListener) context;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_shipping;
    }

    @Override
    public void setBindingViewmodel() {
           binding.setViewmodel(viewmodel);
           setupSpinner();
    }

    private void setupSpinner() {
        ArrayAdapter<CharSequence> adapterPay = ArrayAdapter.createFromResource(getContext(),
                R.array.payMehthod, R.layout.item_spinner);
// Specify the layout to use when the list of choices appears
        adapterPay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        binding.spinnerPayMethod.setAdapter(adapterPay);

        ArrayAdapter<CharSequence> adapterZipcode = ArrayAdapter.createFromResource(getContext(),
                R.array.zipcode, R.layout.item_spinner);
// Specify the layout to use when the list of choices appears
        adapterZipcode.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        binding.spinnerZipcode.setAdapter(adapterZipcode);
    }

    @Override
    public void ViewCreated() {

    }

    @Override
    public void onResume() {
        super.onResume();
        listener.onResumFragment(this);
    }
}
