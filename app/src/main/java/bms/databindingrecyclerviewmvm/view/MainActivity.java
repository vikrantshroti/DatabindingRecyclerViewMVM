package bms.databindingrecyclerviewmvm.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import bms.databindingrecyclerviewmvm.R;
import bms.databindingrecyclerviewmvm.databinding.ActivityMainBinding;
import bms.databindingrecyclerviewmvm.viewmodel.DataViewModel;

public class MainActivity extends AppCompatActivity {

  private DataViewModel dataViewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    View view = bind();
    initRecyclerView(view);
  }

  @Override
  protected void onResume() {
    super.onResume();
    dataViewModel.setUp();
  }

  @Override
  protected void onPause() {
    super.onPause();
    dataViewModel.tearDown();
  }

  private View bind() {
    ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    dataViewModel = new DataViewModel();
    binding.setViewModel(dataViewModel);
    return binding.getRoot();
  }

  private void initRecyclerView(View view) {
    RecyclerView recyclerView = view.findViewById(R.id.data_recycler_view);
    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
        DividerItemDecoration.VERTICAL));
  }
}