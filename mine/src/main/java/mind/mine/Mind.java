package mind.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import mind.adapter.MineItemAdapter;

/**
 * Created by Administrator on 2016/8/11 0011.
 */
public class Mind extends android.support.v4.app.Fragment {

    ListView listView1,listView2;
    List<String> list1 = new ArrayList<String>();
    List<Integer> list2 = new ArrayList<Integer>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //文字
        String [] mine = {"我的发布","我的草稿","我的收藏","我的消息","平台声明","关于“爱家乡”","分享软件","修改密码","清除缓存"};
        //图片
        int [] img = { com.example.mine.R.drawable.img_my_fragment_release_left,
                       com.example.mine.R.drawable.img_my_fragment_draft_left,
                       com.example.mine.R.drawable.img_my_fragment_collection_left,
                       com.example.mine.R.drawable.img_my_fragment_msg_left,
                       com.example.mine.R.drawable.img_my_fragment_stament_left,
                       com.example.mine.R.drawable.img_my_fragment_about_left,
                       com.example.mine.R.drawable.img_my_fragment_share_left,
                       com.example.mine.R.drawable.img_my_fragment_password_left,
                       com.example.mine.R.drawable.img_my_fragment_buffer_left
                      };
        View view = inflater.inflate(com.example.mine.R.layout.fragment_mind,container,false);
        listView1 = (ListView)view.findViewById(com.example.mine.R.id.listView1);
        listView2 = (ListView)view.findViewById(com.example.mine.R.id.listView2);
        for (int i = 0 ; i<4;i++){
            list1.add(mine[i]);
            list2.add(img[i]);
        }
        MineItemAdapter adapter = new MineItemAdapter(getActivity(),list1,list2);
        listView1.setAdapter(adapter);
        list1.clear();
        list2.clear();
        for(int i = 4 ;i<mine.length;i++){
            list1.add(mine[i]);
            list2.add(img[i]);
        }
        MineItemAdapter adapter2 = new MineItemAdapter(getActivity(),list1,list2);
        listView2.setAdapter(adapter2);

        return view;
    }
}
