package bms.databindingrecyclerviewmvm.model;

import android.support.annotation.Nullable;

public class DataModel {
  private String title;

  public DataModel() {
  }

  @Nullable
  public String getTitle() {
    return title;
  }

  public void setTitle(@Nullable String title) {
    this.title = title;
  }
}