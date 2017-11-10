package cn.miao.ncncdtestdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.miao.ncncd.api.BloodOxygenApi;
import cn.miao.ncncd.api.BloodPressureApi;
import cn.miao.ncncd.api.BloodSugarApi;
import cn.miao.ncncd.api.HealthApi;
import cn.miao.ncncd.api.HeartRateApi;
import cn.miao.ncncd.api.SleepApi;
import cn.miao.ncncd.api.SportApi;
import cn.miao.ncncd.api.TemperatureApi;
import cn.miao.ncncd.api.handle.ApiCallBack;
import cn.miao.ncncd.http.entity.BloodOxygen;
import cn.miao.ncncd.http.entity.BloodPressure;
import cn.miao.ncncd.http.entity.BloodSugar;
import cn.miao.ncncd.http.entity.Health;
import cn.miao.ncncd.http.entity.HeartRate;
import cn.miao.ncncd.http.entity.Sleep;
import cn.miao.ncncd.http.entity.Sport;
import cn.miao.ncncd.http.entity.Temperature;
import cn.miao.ncncd.vm.NcncdRegisterActivity;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getName();

    /*签名调试*/
    private Button btnBloodSugar;
    private Button btnBloodPressure;
    private Button btnHealth;
    private Button btnSport;
    private Button btnSleep;
    private Button btnBloodOxygen;
    private Button btnHeartRate;
    private Button btnTemperature;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBoot();
        initView();
        initData();
        initEvent();

    }

    public void initBoot() {
    }

    public void initView() {
        btnBloodSugar = findViewById(R.id.btn_blood_sugar);
        btnBloodPressure = findViewById(R.id.btn_blood_pressure);
        btnHealth = findViewById(R.id.btn_health);
        btnSport = findViewById(R.id.btn_sport);
        btnSleep = findViewById(R.id.btn_sleep);
        btnBloodOxygen = findViewById(R.id.btn_blood_oxygen);
        btnHeartRate = findViewById(R.id.btn_heart_rate);
        btnTemperature = findViewById(R.id.btn_temperature);
        btnRegister = findViewById(R.id.btn_register);
    }

    public void initData() {

    }

    public void initEvent() {

        /*上传血糖数据*/
        btnBloodSugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<BloodSugar> bloodSugars = new ArrayList<BloodSugar>();
                for (int i = 0; i < 1; i++) {
                    /*业务参数*/
                    BloodSugar bloodSugar = new BloodSugar();
                    bloodSugar.setType(1);
                    bloodSugar.setValue(1);
                    bloodSugar.setSampleTime(1);
                    bloodSugars.add(bloodSugar);
                }

                BloodSugarApi.uploadBloodSugar(MainActivity.this, "18811427233", bloodSugars, new ApiCallBack() {

                    @Override
                    public void onStart() {
                        Log.e(TAG, "====onStart=====");
                    }

                    @Override
                    public void onSuccess() {
                        Log.e(TAG, "====onSuccess=====");
                    }

                    @Override
                    public void onFailure(String response) {
                        Log.e(TAG, "====onFailure=====");
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onNetError() {
                        Log.e(TAG, "====onNetError=====");
                    }

                    @Override
                    public void onFinish() {

                        Log.e(TAG, "====onFinish=====");
                    }
                });
            }
        });

        /*上传血压数据*/
        btnBloodPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<BloodPressure> bloodPressures = new ArrayList<BloodPressure>();
                for (int i = 0; i < 1; i++) {
                    /*业务参数*/
                    BloodPressure bloodPressure = new BloodPressure();
                    bloodPressure.setDiastolic(0);
                    bloodPressure.setSystolic(0);
                    bloodPressure.setSampleTime(1);
                    bloodPressures.add(bloodPressure);
                }

                BloodPressureApi.uploadBloodPressure(MainActivity.this, "18811427233", bloodPressures, new ApiCallBack() {

                    @Override
                    public void onStart() {
                        Log.e(TAG, "====onStart=====");
                    }

                    @Override
                    public void onSuccess() {
                        Log.e(TAG, "====onSuccess=====");
                    }

                    @Override
                    public void onFailure(String response) {
                        Log.e(TAG, "====onFailure=====");
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onNetError() {
                        Log.e(TAG, "====onNetError=====");
                    }

                    @Override
                    public void onFinish() {

                        Log.e(TAG, "====onFinish=====");
                    }
                });
            }
        });

        /*上传健康数据*/
        btnHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Health> healthList = new ArrayList<Health>();
                for (int i = 0; i < 1; i++) {
                    /*业务参数*/
                    Health health = new Health();
                    health.setBmd(0);
                    health.setBmi(0);
                    health.setBmr(0);
                    health.setBodyFat(0);
                    health.setMoistureRate(0);
                    health.setMuscleRate(0);
                    health.setSampleTime((int) (System.currentTimeMillis() / 1000));
                    healthList.add(health);
                }

                HealthApi.uploadHealth(MainActivity.this, "18811427233", healthList, new ApiCallBack() {

                    @Override
                    public void onStart() {
                        Log.e(TAG, "====onStart=====");
                    }

                    @Override
                    public void onSuccess() {
                        Log.e(TAG, "====onSuccess=====");
                    }

                    @Override
                    public void onFailure(String response) {
                        Log.e(TAG, "====onFailure=====");
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onNetError() {
                        Log.e(TAG, "====onNetError=====");
                    }

                    @Override
                    public void onFinish() {

                        Log.e(TAG, "====onFinish=====");
                    }
                });
            }
        });

        /*上传运动数据*/
        btnSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Sport> sportList = new ArrayList<Sport>();
                for (int i = 0; i < 1; i++) {
                    /*业务参数*/
                    Sport sport = new Sport();
                    sport.setBeginTime(1);
                    sport.setDistance(1);
                    sport.setEndTime(2);
                    sport.setStep(1);
                    sportList.add(sport);
                }
                SportApi.uploadSport(MainActivity.this, "18811427233", sportList, new ApiCallBack() {

                    @Override
                    public void onStart() {
                        Log.e(TAG, "====onStart=====");
                    }

                    @Override
                    public void onSuccess() {
                        Log.e(TAG, "====onSuccess=====");
                    }

                    @Override
                    public void onFailure(String response) {
                        Log.e(TAG, "====onFailure=====");
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onNetError() {
                        Log.e(TAG, "====onNetError=====");
                    }

                    @Override
                    public void onFinish() {

                        Log.e(TAG, "====onFinish=====");
                    }
                });
            }
        });

        /*上传睡眠数据*/
        btnSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Sleep> sleepList = new ArrayList<Sleep>();
                for (int i = 0; i < 1; i++) {
                    /*业务参数*/
                    Sleep sleep = new Sleep();
                    sleep.setBeginTime(1);
                    sleep.setEndTime(2);
                    sleep.setEffectiveDuration(0);
                    sleep.setDeepDuration(0);
                    sleep.setLightDuration(0);
                    sleep.setTotalDuration(0);
                    sleepList.add(sleep);
                }
                SleepApi.uploadSleep(MainActivity.this, "18811427233", sleepList, new ApiCallBack() {

                    @Override
                    public void onStart() {
                        Log.e(TAG, "====onStart=====");
                    }

                    @Override
                    public void onSuccess() {
                        Log.e(TAG, "====onSuccess=====");
                    }

                    @Override
                    public void onFailure(String response) {
                        Log.e(TAG, "====onFailure=====");
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onNetError() {
                        Log.e(TAG, "====onNetError=====");
                    }

                    @Override
                    public void onFinish() {

                        Log.e(TAG, "====onFinish=====");
                    }
                });
            }
        });

        /*上传血氧数据*/
        btnBloodOxygen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<BloodOxygen> bloodOxygenList = new ArrayList<BloodOxygen>();
                for (int i = 0; i < 1; i++) {
                    /*业务参数*/
                    BloodOxygen bloodOxygen = new BloodOxygen();
                    bloodOxygen.setBeginTime(1);
                    bloodOxygen.setEndTime(2);
                    bloodOxygen.setAverage(0);
                    bloodOxygen.setMax(0);
                    bloodOxygen.setMin(0);
                    bloodOxygenList.add(bloodOxygen);
                }
                BloodOxygenApi.uploadBloodOxygen(MainActivity.this, "18811427233", bloodOxygenList, new ApiCallBack() {

                    @Override
                    public void onStart() {
                        Log.e(TAG, "====onStart=====");
                    }

                    @Override
                    public void onSuccess() {
                        Log.e(TAG, "====onSuccess=====");
                    }

                    @Override
                    public void onFailure(String response) {
                        Log.e(TAG, "====onFailure=====");
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onNetError() {
                        Log.e(TAG, "====onNetError=====");
                    }

                    @Override
                    public void onFinish() {

                        Log.e(TAG, "====onFinish=====");
                    }
                });
            }
        });

        /*上传心率数据*/
        btnHeartRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<HeartRate> heartRateList = new ArrayList<HeartRate>();
                for (int i = 0; i < 1; i++) {
                    /*业务参数*/
                    HeartRate heartRate = new HeartRate();
                    heartRate.setBeginTime(1);
                    heartRate.setEndTime(2);
                    heartRate.setAverage(0);
                    heartRate.setMax(0);
                    heartRate.setMin(0);
                    heartRateList.add(heartRate);
                }
                HeartRateApi.uploadHeartRate(MainActivity.this, "18811427233", heartRateList, new ApiCallBack() {

                    @Override
                    public void onStart() {
                        Log.e(TAG, "====onStart=====");
                    }

                    @Override
                    public void onSuccess() {
                        Log.e(TAG, "====onSuccess=====");
                    }

                    @Override
                    public void onFailure(String response) {
                        Log.e(TAG, "====onFailure=====");
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onNetError() {
                        Log.e(TAG, "====onNetError=====");
                    }

                    @Override
                    public void onFinish() {

                        Log.e(TAG, "====onFinish=====");
                    }
                });
            }
        });

        /*上传体温数据*/
        btnTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<Temperature> temperatureList = new ArrayList<Temperature>();
                for (int i = 0; i < 1; i++) {
                    /*业务参数*/
                    Temperature temperature = new Temperature();
                    temperature.setBeginTime(1);
                    temperature.setEndTime(2);
                    temperature.setAverage(0);
                    temperature.setMax(0);
                    temperature.setMin(0);
                    temperatureList.add(temperature);
                }
                TemperatureApi.uploadTemperature(MainActivity.this, "18811427233", temperatureList, new ApiCallBack() {

                    @Override
                    public void onStart() {
                        Log.e(TAG, "====onStart=====");
                    }

                    @Override
                    public void onSuccess() {
                        Log.e(TAG, "====onSuccess=====");
                    }

                    @Override
                    public void onFailure(String response) {
                        Log.e(TAG, "====onFailure=====");
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onNetError() {
                        Log.e(TAG, "====onNetError=====");
                    }

                    @Override
                    public void onFinish() {

                        Log.e(TAG, "====onFinish=====");
                    }
                });
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, NcncdRegisterActivity.class);
                startActivity(i);
            }
        });


    }
}
