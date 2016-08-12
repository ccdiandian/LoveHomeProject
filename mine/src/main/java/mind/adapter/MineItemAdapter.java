package mind.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mine.R;

import java.util.List;

public class MineItemAdapter extends BaseAdapter {

    private List<String> objects;
    private List<Integer> img;

    private Context context;
    private LayoutInflater layoutInflater;

    public MineItemAdapter(Context context,List<String> objects,List<Integer> img) {
        this.context = context;
        this.objects = objects;
        this.img = img;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public String getItem(int position) {
        return objects.get(position);
    }

    //返回图片
    public int getImg(int position){ return img.get(position);}

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.mine_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((String)getItem(position),getImg(position),(ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(String object,int img, ViewHolder holder) {
        //TODO implement
        holder.img.setImageResource(img);
        holder.text.setText(object);

    }

    protected class ViewHolder {
        private ImageView img;
        private TextView text;

        public ViewHolder(View view) {
            img = (ImageView) view.findViewById(R.id.img);
            text = (TextView) view.findViewById(R.id.text);
        }
    }
}
