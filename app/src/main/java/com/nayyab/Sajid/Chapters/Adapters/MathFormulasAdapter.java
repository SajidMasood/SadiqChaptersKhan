package com.nayyab.Sajid.Chapters.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nayyab.Sajid.Chapters.Activities.DetailActivity;
import com.nayyab.Sajid.Chapters.Models.ParentDataItem;
import com.nayyab.Sajid.Chapters.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class MathFormulasAdapter extends RecyclerView.Adapter<MathFormulasAdapter.ChapterViewHolder> implements Filterable {
    private ArrayList<ParentDataItem> parentDataItems;
    ArrayList<ParentDataItem> backUp;

    public MathFormulasAdapter(ArrayList<ParentDataItem> parentDataItems) {
        this.parentDataItems = parentDataItems;
        backUp = new ArrayList<>(parentDataItems);
    }

    @NonNull
    @Override
    public ChapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_data_item,parent,false);
        return new ChapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterViewHolder holder, int position) {
        ParentDataItem parentDataItem = parentDataItems.get(position);
        holder.imageView.setImageResource(parentDataItem.getParentImages());
        holder.mParentTextView.setText(parentDataItem.getParentName());

        int noOfChildTextViews = holder.mChild_linearLayout.getChildCount();
        for (int index = 0; index < noOfChildTextViews; index++) {
            TextView currentTextView = (TextView) holder.mChild_linearLayout.getChildAt(index);
            currentTextView.setVisibility(View.VISIBLE);
        }

        int noOfChild = parentDataItem.getChildDataItems().size();
        if (noOfChild < noOfChildTextViews) {
            for (int index = noOfChild; index < noOfChildTextViews; index++) {
                TextView currentTextView = (TextView) holder.mChild_linearLayout.getChildAt(index);
                currentTextView.setVisibility(View.GONE);
            }
        }

        for (int textViewIndex = 0; textViewIndex < noOfChild; textViewIndex++) {
            TextView currentTextView = (TextView) holder.mChild_linearLayout.getChildAt(textViewIndex);
            currentTextView.setText(parentDataItem.getChildDataItems().get(textViewIndex).getChildName().replace("_"," "));

            int itemPosition = textViewIndex;
            currentTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Intent intent = new Intent(holder.mContext, DetailActivity.class);
                    Intent intent = new Intent(holder.mContext, DetailActivity.class);
                    intent.putExtra("titles",parentDataItem.getChildDataItems().get(itemPosition).getChildName());
                    holder.mContext.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return parentDataItems == null ? 0 : parentDataItems.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyword) {
            ArrayList<ParentDataItem> filterdData = new ArrayList<>();
            if (keyword.toString().isEmpty())
                filterdData.addAll(backUp);
            else {
                for (ParentDataItem obj : backUp){
                    if (obj.getParentName().toString().toLowerCase().contains(keyword.toString().toLowerCase()))
                        filterdData.add(obj);
                }
            }
            FilterResults results = new FilterResults();
            results.values = filterdData;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            parentDataItems.clear();
            parentDataItems.addAll((ArrayList<ParentDataItem>)results.values);
            notifyDataSetChanged();
        }
    };

    //-----------------------------------ViewHolder Class--------------------------------------------------
    class ChapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // TODO: 10/21/2020 variables...
        private Context mContext;
        private LinearLayout mParent_linearLayout;
        private LinearLayout mChild_linearLayout;
        private TextView mParentTextView;
        private TextView textView;
        private ImageView imageView, arrow;

        public ChapterViewHolder(View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            mParent_linearLayout = itemView.findViewById(R.id.parent_linearLayout);
            mChild_linearLayout = itemView.findViewById(R.id.child_linearLayout);
            mParentTextView  = itemView.findViewById(R.id.parent_item);
            imageView = itemView.findViewById(R.id.articleImage);
            arrow = itemView.findViewById(R.id.item_arrow);

            mChild_linearLayout.setVisibility(View.GONE);
            int intMaxNoOfChild = 0;
            for (int index = 0; index < parentDataItems.size(); index++){
                int intMaxSizeTemp = parentDataItems.get(index).getChildDataItems().size();
                if (intMaxSizeTemp > intMaxNoOfChild) intMaxNoOfChild = intMaxSizeTemp;
            }
            // Child Item TextView
            for (int indexView = 0; indexView < intMaxNoOfChild; indexView++){
                textView = new TextView(mContext);
                textView.setId(indexView);
                textView.setTextSize(15);
                textView.setTypeface(null, Typeface.BOLD);
                textView.setTextColor(Color.BLACK);
                textView.setPadding(220, 50, 20, 50);
                textView.setGravity(Gravity.CENTER_VERTICAL);
                textView.setBackground(ContextCompat.getDrawable(mContext, R.drawable.background_sub_module_text));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                textView.setOnClickListener(this);
                mChild_linearLayout.addView(textView, layoutParams);
            }
            mParent_linearLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.parent_linearLayout){
                if (mChild_linearLayout.getVisibility() == View.VISIBLE) {
                    mChild_linearLayout.setVisibility(View.GONE);
                    animationCollapse();
                    //parentImageUnRotate();
                } else {
                    parentImageRotate();
                    animationExpand();
                    mChild_linearLayout.setVisibility(View.VISIBLE);
                }
            } else {
                TextView textViewClicked = (TextView) view;
            }
        }
        private void animationExpand(){
            RotateAnimation animation = new RotateAnimation(360,180,
                    RELATIVE_TO_SELF,0.5f, RELATIVE_TO_SELF, 0.5f);
            animation.setDuration(300);
            animation.setFillAfter(true);
            arrow.startAnimation(animation);
        }
        private void animationCollapse() {
            RotateAnimation animation = new RotateAnimation(180,360,
                    RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
            animation.setDuration(300);
            animation.setFillAfter(true);
            arrow.startAnimation(animation);
        }
        private void parentImageRotate(){
            RotateAnimation rotateAnimation = new RotateAnimation(360,0,
                    RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
            rotateAnimation.setDuration(400);
            rotateAnimation.setFillAfter(true);
            imageView.startAnimation(rotateAnimation);
        }
        private void parentImageUnRotate(){
            RotateAnimation rotateAnimation = new RotateAnimation(270,360,
                    RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
            rotateAnimation.setDuration(400);
            rotateAnimation.setFillAfter(true);
            imageView.startAnimation(rotateAnimation);
        }
    }
}
