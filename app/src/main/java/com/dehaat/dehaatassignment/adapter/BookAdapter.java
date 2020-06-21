package com.dehaat.dehaatassignment.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.dehaat.dehaatassignment.R;
import com.dehaat.dehaatassignment.databinding.ItemBookListBinding;
import com.dehaat.dehaatassignment.datalayer.model.Book;
import com.dehaat.dehaatassignment.util.UiUtils;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BooksViewHolder>{

    private Context context;
    private final int MAX_DESCRIPTION_LINES = 2;
    private List<Book> mValues = new ArrayList();

    public BookAdapter(Context context){
        this.context = context;
    }


    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBookListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_book_list,
                parent,
                false);
        return new BooksViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        holder.bind(mValues.get(position));
    }

    public void setmValues(List<Book> mValues) {
        this.mValues = mValues;
    }

    @Override
    public int getItemCount() {
        return mValues == null? 0 : mValues.size();
    }

    class BooksViewHolder extends RecyclerView.ViewHolder{

        private ItemBookListBinding binding;

        public BooksViewHolder(@NonNull ItemBookListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Book book){
            binding.setBook(book);

            if(!TextUtils.isEmpty(book.getDescription())){
                if(UiUtils.INSTANCE.isTextTooLarge(context,binding.bookDescription,book.getDescription(),MAX_DESCRIPTION_LINES)){
                    binding.bookDescription.setMaxLines(MAX_DESCRIPTION_LINES);
                    binding.viewMore.setVisibility(View.VISIBLE);
                    binding.viewMore.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            binding.viewMore.setVisibility(View.GONE);
                            binding.bookDescription.setMaxLines(Integer.MAX_VALUE);
                        }
                    });
                }else {
                    binding.viewMore.setVisibility(View.GONE);
                    binding.bookDescription.setMaxLines(Integer.MAX_VALUE);
                }
            }
        }
    }
}
