package bms.databindingrecyclerviewmvm.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import bms.databindingrecyclerviewmvm.R;
import bms.databindingrecyclerviewmvm.databinding.ItemDataBinding;
import bms.databindingrecyclerviewmvm.model.DataModel;
import bms.databindingrecyclerviewmvm.viewmodel.DataItemViewModel;
import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
  private static final String TAG = "DataAdapter";
  private List<DataModel> data;

  public DataAdapter() {
    this.data = new ArrayList<>();
  }

  @NonNull
  @Override
  public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data,
        new FrameLayout(parent.getContext()), false);
    return new DataViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(DataViewHolder holder, int position) {
    DataModel dataModel = data.get(position);
    holder.setViewModel(new DataItemViewModel(dataModel));
  }

  @Override
  public int getItemCount() {
    return this.data.size();
  }

  @Override
  public void onViewAttachedToWindow(@NonNull DataViewHolder holder) {
    super.onViewAttachedToWindow(holder);
    holder.bind();
  }

  @Override
  public void onViewDetachedFromWindow(@NonNull DataViewHolder holder) {
    super.onViewDetachedFromWindow(holder);
    holder.unbind();
  }

  public void updateData(@Nullable List<DataModel> data) {
    if (data == null || data.isEmpty()) {
      this.data.clear();
    } else {
      this.data.addAll(data);
    }
    notifyDataSetChanged();
  }

  /* package */ static class DataViewHolder extends RecyclerView.ViewHolder {
    /* package */ ItemDataBinding binding;

    /* package */ DataViewHolder(View itemView) {
      super(itemView);
      bind();
    }

    /* package */ void bind() {
      if (binding == null) {
        binding = DataBindingUtil.bind(itemView);
      }
    }

    /* package */ void unbind() {
      if (binding != null) {
        binding.unbind(); // Don't forget to unbind
      }
    }

    /* package */ void setViewModel(DataItemViewModel viewModel) {
      if (binding != null) {
        binding.setViewModel(viewModel);
      }
    }
  }
}