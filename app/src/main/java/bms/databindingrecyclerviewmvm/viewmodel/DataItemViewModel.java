package bms.databindingrecyclerviewmvm.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;
import bms.databindingrecyclerviewmvm.model.DataModel;

public class DataItemViewModel extends BaseObservable {
  private DataModel dataModel;

  public DataItemViewModel(DataModel dataModel) {
    this.dataModel = dataModel;
  }

  public void setUp() {
    // perform set up tasks, such as adding listeners
  }

  public void tearDown() {
    // perform tear down tasks, such as removing listeners
  }

  @Bindable
  public String getTitle() {
    return !TextUtils.isEmpty(dataModel.getTitle()) ? dataModel.getTitle() : "";
  }
}