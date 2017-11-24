package cn.miao.ncncdtestdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import cn.miao.ncncd.vm.NcncdRegisterActivity;
import cn.miao.ncncdtestdemo.adapter.TestAdapter;

/**
 * 主界面
 */
public class MainActivity extends AppCompatActivity {

    /*列表*/
    private ListView lvTest;
    private TestAdapter testAdapter;

    /*列表数据*/
    private String[] datas = {"上传血糖数据", "上传健康数据", "上传血压数据", "上传运动数据", "上传睡眠数据", "上传血氧数据", "上传心率数据", "上传体温数据", "上传用户数据"};
    private Class[] activitys = new Class[]{BloodSugarActivity.class, HealthActivity.class, BloodPressureActivity.class, SportActivity.class, SleepActivity.class, BloodOxygenActivity.class, HeartRateActivity.class, TemperatureActivity.class, NcncdRegisterActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTest = (ListView) findViewById(R.id.lv_test);
        testAdapter = new TestAdapter(this, datas);
        lvTest.setAdapter(testAdapter);

        lvTest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, activitys[position]);
                startActivity(intent);
            }
        });

    }

}
