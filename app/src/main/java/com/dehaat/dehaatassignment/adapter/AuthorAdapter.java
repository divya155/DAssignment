package com.dehaat.dehaatassignment.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.dehaat.dehaatassignment.R;
import com.dehaat.dehaatassignment.databinding.ItemAuthorListBinding;
import com.dehaat.dehaatassignment.datalayer.model.Author;
import com.dehaat.dehaatassignment.fragment.AuthorListFrament;
import com.dehaat.dehaatassignment.util.UiUtils;

import java.util.ArrayList;
import java.util.List;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder>{

    private Context context;
    private final int MAX_BIO_LINES = 2;
    private AuthorListFrament.AuthorItemInteractionListener authorItemInteractionListener;

    public AuthorAdapter(Context context, AuthorListFrament.AuthorItemInteractionListener authorItemInteractionListener){
        this.context = context;
        this.authorItemInteractionListener = authorItemInteractionListener;
    }

    private List<Author> mValues = new ArrayList();

    @NonNull
    @Override
    public AuthorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAuthorListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_author_list,
                parent,
                false);
        return new AuthorViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorViewHolder holder, int position) {
        Author author = mValues.get(position);
        holder.bind(author,position);
    }



    public void setmValues(List<Author> mValues) {
        this.mValues = mValues;
    }

    @Override
    public int getItemCount() {
        return mValues == null? 0 : mValues.size();
    }

    class AuthorViewHolder extends RecyclerView.ViewHolder{

        private ItemAuthorListBinding binding;

        public AuthorViewHolder(@NonNull ItemAuthorListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(final Author author, final int position){
            binding.setAuthor(author);

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(authorItemInteractionListener != null){
                        authorItemInteractionListener.onAuthorSelected(author,position);
                    }
                }
            });

            if(!TextUtils.isEmpty(author.getAuthor_bio())){
                if(UiUtils.INSTANCE.isTextTooLarge(context,binding.authorBio,author.getAuthor_bio(),MAX_BIO_LINES)){
                    binding.authorBio.setMaxLines(MAX_BIO_LINES);
                    binding.viewMore.setVisibility(View.VISIBLE);
                    binding.viewMore.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            binding.viewMore.setVisibility(View.GONE);
                            binding.authorBio.setMaxLines(Integer.MAX_VALUE);
                        }
                    });
                }else {
                    binding.viewMore.setVisibility(View.GONE);
                    binding.authorBio.setMaxLines(Integer.MAX_VALUE);
                }
            }
        }
    }
}
