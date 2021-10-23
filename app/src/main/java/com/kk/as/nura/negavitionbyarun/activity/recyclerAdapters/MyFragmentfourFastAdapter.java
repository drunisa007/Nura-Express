package com.kk.as.nura.negavitionbyarun.activity.recyclerAdapters;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kk.as.nura.negavitionbyarun.R;
import com.kk.as.nura.negavitionbyarun.activity.fragment.PicassoImage;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Aung Thu on 8/6/2017.
 */

public class MyFragmentfourFastAdapter extends RecyclerView.Adapter<MyFragmentfourFastAdapter.MyViewHolder> {
    private Context context;
    private List<PicassoImage> listimage;
    public MyFragmentfourFastAdapter(Context context, List<PicassoImage> listimage){
        this.context=context;
        this.listimage=listimage;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.fourfragmentfastrecyclerview,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      /*  holder.imageview.setImageResource(R.drawable.adver2);*/
  Picasso.with(context).load(listimage.get(position).getImage()).memoryPolicy(MemoryPolicy.NO_CACHE).resize(250,250).into(holder.imageview);

    }

    @Override
    public int getItemCount() {
        return listimage.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageview;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageview= (ImageView) itemView.findViewById(R.id.fragmentfourimageview);
        }
    }
}
