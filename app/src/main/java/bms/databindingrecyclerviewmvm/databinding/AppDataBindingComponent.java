package bms.databindingrecyclerviewmvm.databinding;

public class AppDataBindingComponent implements android.databinding.DataBindingComponent {
  @Override
  public RecyclerViewDataBinding getRecyclerViewDataBinding() {
    return new RecyclerViewDataBinding();
  }
}