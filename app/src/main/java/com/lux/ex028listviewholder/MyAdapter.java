package com.lux.ex028listviewholder;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> items;

    public MyAdapter(Context context, ArrayList<String> items){
        this.context=context;
        this.items=items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //리스트뷰가 보여줄 아이템 1개 뷰객체를 만들어 리턴해주는 기능메소드
    //첫번째 파라미터 i : 현재 만들어야 할번째의 위치  - position
    //두번째 파라미터 view : 재활용할 뷰가 있다면 그 뷰를 참조, 없다면 null
    //세번째 파라미터 viewGroup : listView
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //1.create View
        if (view==null){//재활용할 뷰가 없는가?
            //layout폴더 안에 있는 listview_item.xml 문서를 읽어와서
            // 뷰 객체로 만들어주는 능력을 가진 객체 소환 : layoutInflater
            LayoutInflater inflater=LayoutInflater.from(context);
            view=inflater.inflate(R.layout.listview_item,viewGroup,false);

            ViewHolder holder = new ViewHolder(view);
            view.setTag(holder);
        }
        //2.bind View

        //만들어진 view안에 있는 TextView를 찾아오는 findViewById메소드가
        //속도를 매우 저하시킴
        //TextView tv=view.findViewById(R.id.item_tv);

        //뷰안에 태그로 저장된 뷰홀더 객체를 꺼내오기
        ViewHolder holder=(ViewHolder) view.getTag();

        //현재 만들어야 할 번째의 데이터
        String item= items.get(i);
        holder.tv.setText(item);

        return view;
    }

    //item 1개 뷰의 자식 뷰들의 참조변수를 멤버로 가지는 클래스
    class ViewHolder{
        TextView tv;

        public  ViewHolder(View itemView){

            tv=itemView.findViewById(R.id.item_tv);
        }
    }

}
