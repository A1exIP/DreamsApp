  package com.example.dreamsapp;

  import android.content.Intent;
  import android.os.Bundle;
  import android.view.View;
  import android.widget.AdapterView;
  import android.widget.ArrayAdapter;
  import android.widget.Button;
  import android.widget.EditText;
  import android.widget.ListView;
  import android.widget.Toast;

  import androidx.appcompat.app.AppCompatActivity;

  import java.util.ArrayList;

  public class CalendarActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    private ArrayList<String> taskList;
    private ArrayAdapter<String> adapter;
    private EditText editTextTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        // Analysis
        Button analysis_button = findViewById(R.id.button_analysis); // Находим кнопку в макете по ее идентификатору
        analysis_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Устанавливаем обработчик нажатия кнопки
                // Создаем новое намерение для перехода на другую активность
                Intent intent = new Intent(CalendarActivity.this, AnalysisActivity.class);
                startActivity(intent); // Запускаем новую активность
            }
        });
        // Устанавливаем обработчик нажатия кнопки
//        analysis_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View activity_analysis) {
//                // Загружаем другой макет
//                setContentView(R.layout.activity_analysis);
//            }
//        });
        // Calendar
        Button calendar_button = findViewById(R.id.button_calendar); // Находим кнопку в макете по ее идентификатору
        calendar_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Устанавливаем обработчик нажатия кнопки
                // Создаем новое намерение для перехода на другую активность
                Intent intent = new Intent(CalendarActivity.this, CalendarActivity.class);
                startActivity(intent); // Запускаем новую активность
            }
        });
//        calendar_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View button_calendar) {
//                // Загружаем другой макет
//                setContentView(R.layout.activity_calendar);
//            }
//        });
        // Target
        Button target_button = findViewById(R.id.button_target); // Находим кнопку в макете по ее идентификатору
        target_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Устанавливаем обработчик нажатия кнопки
                // Создаем новое намерение для перехода на другую активность
                Intent intent = new Intent(CalendarActivity.this, TargetActivity.class);
                startActivity(intent); // Запускаем новую активность
            }
        });
//        target_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View button_target) {
//                // Загружаем другой макет
//                setContentView(R.layout.activity_target);
//            }
//        });
        // Account
        Button account_button = findViewById(R.id.button_account); // Находим кнопку в макете по ее идентификатору
        account_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // Устанавливаем обработчик нажатия кнопки
                // Создаем новое намерение для перехода на другую активность
                Intent intent = new Intent(CalendarActivity.this, AccountActivity.class);
                startActivity(intent); // Запускаем новую активность
            }
        });
//        account_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View button_account) {
//                // Загружаем другой макет
//                setContentView(R.layout.activity_account);
//            }
//        });

        // Инициализация списков задач
        taskList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);

        // Привязка элементов пользовательского интерфейса
        Button addButton = findViewById(R.id.button_menu);
        ListView taskListView = findViewById(R.id.listViewTasks);
//        TextView editTextTask = findViewById(R.id.textView);
        editTextTask = findViewById(R.id.editTextTextPersonName);

        // Назначение адаптера для списка задач
        taskListView.setAdapter(adapter);

        // Обработчик нажатия на кнопку добавления задачи
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask();
            }
        });

        // Обработчик нажатия на элемент списка задач для удаления
        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                removeTask(position);
            }
        });
    }

    // Метод для добавления задачи
    private void addTask() {
        String task = editTextTask.getText().toString().trim();
        if (!task.isEmpty()) {
            taskList.add(task);
            adapter.notifyDataSetChanged();
            editTextTask.getText().clear();
        } else {
            Toast.makeText(this, "Введите задачу", Toast.LENGTH_SHORT).show();
        }
    }

    // Метод для удаления задачи
    private void removeTask(int position) {
        taskList.remove(position);
        adapter.notifyDataSetChanged();
    }

}