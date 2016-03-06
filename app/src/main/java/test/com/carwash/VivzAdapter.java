package test.com.carwash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;

import java.util.Collections;
import java.util.List;

/**

 */
public class VivzAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder> {

    TextView etName;
Intent intent;
   private LayoutInflater inflater;


    private static final int TYPE_HEADER=0;
    private static final int TYPE_ITEM=1;


    List<Information> data= Collections.emptyList();
    private Context context;
    private ClickListener clickListener;
   public VivzAdapter(Context context,List<Information> data){
      this.context=context;
       inflater= LayoutInflater.from(context);
       this.data=data;


   }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        if(viewType==TYPE_HEADER){
            //DrawerHeader drawerHeader=new DrawerHeader();
            //drawerHeader.setContentView(R.layout.drawer_header);
            View view=inflater.inflate(R.layout.drawer_header, parent,false);
//View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_header,parent,false);


            //drawerHeader.onCreate(view);

            HeaderHolder holder=new HeaderHolder(view);
            return holder;
        }
        else{
            View view=inflater.inflate(R.layout.custom_view, parent,false);
            ItemHolder holder=new ItemHolder(view);
            return holder;
        }
    }
    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return TYPE_HEADER;
        }
        else {
            return TYPE_ITEM;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HeaderHolder ){
        }
        else{
            ItemHolder itemHolder= (ItemHolder) holder;
            Information current=data.get(position-1);
            itemHolder.title.setText(current.title);
            itemHolder.icon.setImageResource(current.iconId);
        }
    }
public void setClickListener(ClickListener clickListener){
    this.clickListener=clickListener;
}
    @Override
    public int getItemCount() {
        return data.size()+1;
    }



    class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
       TextView title;
        ImageView icon;


        public ItemHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title=(TextView)itemView.findViewById(R.id.tv1);
            icon=(ImageView)itemView.findViewById(R.id.iv1);

        }

        @Override
        public void onClick(View v) {

       if(clickListener!=null)
       {
           clickListener.itemClicked(v,getPosition()-1);
       }

        }
    }
    public interface ClickListener{
        public void itemClicked(View view, int position);
    }

    class HeaderHolder extends RecyclerView.ViewHolder  {



        public HeaderHolder(View itemView) {
            super(itemView);



        }



        }
    }





