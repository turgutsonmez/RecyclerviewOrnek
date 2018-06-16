package turgutsonmez.com.recyclerviewornek;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

  ArrayList<Manzara> mDataList;
  LayoutInflater inflater;

  public MyAdapter(Context context, ArrayList<Manzara> data) {

    //inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    inflater = LayoutInflater.from(context);
    this.mDataList = data;
  }

  @NonNull
  @Override
  public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = inflater.inflate(R.layout.list_item, parent, false);
    MyViewHolder holder = new MyViewHolder(v);
    return holder;
  }

  @Override
  public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

    Manzara tiklanilanManzara = mDataList.get(position);
    holder.setData(tiklanilanManzara, position);

  }

  public void deleteItem(int position) {

    mDataList.remove(position);
    notifyItemRemoved(position);
    notifyItemRangeChanged(position, mDataList.size());

  }

  public void addItem(int position, Manzara kopyalanacakManzara) {

    mDataList.add(position, kopyalanacakManzara);
    notifyItemInserted(position);
    notifyItemRangeChanged(position, mDataList.size());

    //Tüm değişikliği kaydededer. itemrangechanged ve iteminserted a gerek kalmaz(ama animasyonlar kaybolur ve çok permormanslı)
    //notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    return mDataList.size();
  }


  class MyViewHolder extends RecyclerView.ViewHolder {

    TextView mManzaraTitle, mManzaraDescription;
    ImageView mManzaraPicture, mSil, mKopyala;
    int tiklanilanOgeninPositionDegeri = 0;
    Manzara kopyalanacakManzara;


    public MyViewHolder(@NonNull View itemView) {
      super(itemView);
      mManzaraTitle = itemView.findViewById(R.id.txtManzaraBaslik);
      mManzaraDescription = itemView.findViewById(R.id.txtManzaraDescription);
      mManzaraPicture = itemView.findViewById(R.id.imgManzara);
      mSil = itemView.findViewById(R.id.imgSil);
      mKopyala = itemView.findViewById(R.id.imgKopyala);

      mSil.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          deleteItem(tiklanilanOgeninPositionDegeri);
        }
      });

      mKopyala.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          addItem(tiklanilanOgeninPositionDegeri, kopyalanacakManzara);
        }
      });
    }

    public void setData(Manzara tiklanilanManzara, int position) {
      this.mManzaraTitle.setText(tiklanilanManzara.getTitle());
      this.mManzaraDescription.setText(tiklanilanManzara.getDescription());
      this.mManzaraPicture.setImageResource(tiklanilanManzara.getImageID());
      this.tiklanilanOgeninPositionDegeri = position;
      this.kopyalanacakManzara = tiklanilanManzara;
    }
  }
}
