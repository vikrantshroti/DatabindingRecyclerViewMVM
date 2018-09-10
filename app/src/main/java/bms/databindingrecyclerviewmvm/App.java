package bms.databindingrecyclerviewmvm;

import android.app.Application;
import android.databinding.DataBindingUtil;
import bms.databindingrecyclerviewmvm.databinding.AppDataBindingComponent;

public class App extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());
  }
}