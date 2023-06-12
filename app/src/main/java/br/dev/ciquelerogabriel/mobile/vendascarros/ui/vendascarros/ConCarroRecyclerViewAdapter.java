package br.dev.ciquelerogabriel.mobile.vendascarros.ui.vendascarros;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import br.dev.ciquelerogabriel.mobile.vendascarros.databinding.FragmentConCarroBinding;
import br.dev.ciquelerogabriel.mobile.vendascarros.model.Carro;


import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link br.dev.ciquelerogabriel.mobile.vendascarros.model.Carro}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ConCarroRecyclerViewAdapter extends RecyclerView.Adapter<ConCarroRecyclerViewAdapter.ViewHolder> {

    private final List<Carro> mValues;

    public ConCarroRecyclerViewAdapter(List<Carro> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentConCarroBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getDataCarro());
        holder.mContentView.setText(mValues.get(position).getModeloCarro());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public Carro mItem;

        public ViewHolder(FragmentConCarroBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}