package com.aohuan.dodo.coordinator;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.aohuan.dodo.coordinator.do_.do0.Main0Activity;
import com.aohuan.dodo.coordinator.do_.do1.Main1Activity;
import com.aohuan.dodo.coordinator.do_.do2.Main2Activity;
import com.aohuan.dodo.coordinator.do_.do3.Main3Activity;
import com.aohuan.dodo.coordinator.do_.do4.Main4Activity;
import com.aohuan.dodo.coordinator.do_.do5.Main5Activity;
import com.aohuan.dodo.coordinator.do_.do6.Main6Activity;
import com.aohuan.dodo.coordinator.do_.do7.Main7Activity;
import com.aohuan.dodo.coordinator.doa.doa0.MainA0Activity;
import com.aohuan.dodo.coordinator.doa.doa1.MainA1Activity;
import com.aohuan.dodo.coordinator.doa.doa2.MainA2Activity;
import com.aohuan.dodo.coordinator.doa.doa3.MainA3Activity;
import com.aohuan.dodo.coordinator.doa.doa4.MainA4Activity;
import com.aohuan.dodo.coordinator.doa.doa5.MainA5Activity;
import com.aohuan.dodo.coordinator.doa.doa6.MainA6Activity;
import com.aohuan.dodo.coordinator.dob.MainB0Activity;
import com.aohuan.dodo.coordinator.dob.MainB1Activity;
import com.aohuan.dodo.coordinator.dob.MainB2Activity;
import com.aohuan.dodo.coordinator.don.don0.MainN0Activity;
import com.aohuan.dodo.coordinator.don.don1.MainN1Activity;
import com.aohuan.dodo.coordinator.do_.utils.Utils;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListView mEListView;
    List<String> mStringArrayList;  //所有的字符，这里为了方便，没有分组
    List<String> mStringTopList;    //对应的top类型的list

//    ArrayList<>

    ArrayList<TypeBean> typeChildList = new ArrayList<>();//对应bean的list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEListView = (ExpandableListView) findViewById(R.id.list2);
        mStringArrayList = Arrays.asList(getResources().getStringArray(R.array.typelist));
        mStringTopList = Arrays.asList(getResources().getStringArray(R.array.typetop));

        setBean();

        mEListView.setAdapter(new ExpandableListViewaAdapter());

    }

    private void setBean() {
        //添加top
        for(int i=0; i<mStringTopList.size(); i++){
            typeChildList.add(new TypeBean(mStringTopList.get(i)));
        }

        for(int i=0; i<mStringArrayList.size(); i++){
            ChildBean bean = setIndexBean(i, mStringArrayList.get(i));
            if(i < PART_A){
                typeChildList.get(0).childBeanList.add(bean);
            }else if(i >= PART_A && i < PART_B){
                typeChildList.get(1).childBeanList.add(bean);
            }else if(i >= PART_B && i < PART_N){
                typeChildList.get(2).childBeanList.add(bean);
            }else if(i >= PART_N){
                typeChildList.get(3).childBeanList.add(bean);
            }
        }
    }
    public static final int PART_1 = 0;
    public static final int PART_A = 8;
    public static final int PART_B = PART_A + 7;
    public static final int PART_N = PART_B + 5;


    private ChildBean setIndexBean(int i, String name) {
//        ChildBean bean = new ChildBean();

        switch (i){
            ////===========PART 1
            case PART_1 + 0:
                return setBeanName(name, Main0Activity.class);
            case PART_1 +1:
                return setBeanName(name, Main1Activity.class);
            case PART_1 +2:
                return setBeanName(name, Main2Activity.class);
            case PART_1 +3:
                return setBeanName(name, Main3Activity.class);
            case PART_1 +4:
                return setBeanName(name, Main4Activity.class);
            case PART_1 +5:
                return setBeanName(name, Main5Activity.class);
            case PART_1 +6:
                return setBeanName(name, Main6Activity.class);
            case PART_1 +7:
                return setBeanName(name, Main7Activity.class);
//                break;

            ////===========PART_A

            case PART_A + 0:
                return setBeanName(name, MainA0Activity.class);
            case PART_A + 1:
                return setBeanName(name, MainA1Activity.class);
            case PART_A + 2:
                return setBeanName(name, MainA2Activity.class);
            case PART_A + 3:
                return setBeanName(name, MainA3Activity.class);
            case PART_A + 4:
                return setBeanName(name, MainA4Activity.class);
            case PART_A + 5:
                return setBeanName(name, MainA5Activity.class);
            case PART_A + 6:
                return setBeanName(name, MainA6Activity.class);

            ////===========PART_B
            case PART_B + 0:
                return setBeanName(name, MainB0Activity.class);
            case PART_B + 1:
                return setBeanName(name, MainB1Activity.class);
            case PART_B + 2:
                return setBeanName(name, MainB2Activity.class);

            ////===========PART_N

            case PART_N + 0:
                return setBeanName(name, MainN0Activity.class);
            case PART_N + 1:
                return setBeanName(name, MainN1Activity.class);
        }
        return new ChildBean();
    }

    ChildBean setBeanName(String name, Class cls){
        ChildBean bean = new ChildBean();
        bean.name = name;
        bean.cls = cls;
        return bean;
    }

    class ExpandableListViewaAdapter extends BaseExpandableListAdapter {

        @Override
        public int getGroupCount() {
            return typeChildList.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return typeChildList.get(groupPosition).childBeanList.size();
        }

        @Override
        public TypeBean getGroup(int groupPosition) {
//            return "title " + groupPosition;
            return typeChildList.get(groupPosition);
        }

        @Override
        public ChildBean getChild(int groupPosition, int childPosition) {
//            return "content " + childPosition;
            return typeChildList.get(groupPosition).childBeanList.get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,View convertView, ViewGroup parent) {
            return getGenericView(getGroup(groupPosition));
        }

        @Override
        public View getChildView(int groupPosition, int childPosition,boolean isLastChild, View convertView, ViewGroup parent) {
            return getGenericView(getChild(groupPosition, childPosition));
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        private TextView getGenericView(final Object obj) {

            int tvHeight = 100;

            TextView textView = new TextView(getApplicationContext());
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            textView.setPadding(40, 0, 0, 0);

            //====

            String string = "no Contents";
            if(obj instanceof TypeBean){
                string = ((TypeBean) obj).name;
                tvHeight = 300;
                textView.setBackgroundColor(Color.GRAY);
            }else if(obj instanceof  ChildBean){
                string = ((ChildBean) obj).name;
                tvHeight = 200;
                final Class cls = ((ChildBean) obj).cls;
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(cls == null){
                            Toast.makeText(getApplicationContext(),"没有设置，嘿嘿！！！", Toast.LENGTH_SHORT).show();
                        }else {
                            startActivity(new Intent(getApplication(), ((ChildBean) obj).cls));
                        }

                    }
                });
            }else{

            }
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    tvHeight);
            textView.setLayoutParams(layoutParams);
            textView.setText(string);
            textView.setTextColor(Color.BLACK);
            return textView;
        }

    }
    class TypeBean{
        TypeBean(String name){
            this.name = name;
        }
        String name;
        ArrayList<ChildBean> childBeanList = new ArrayList<>();
    }

    class ChildBean{
        String name;
        Class cls;
    }

}
