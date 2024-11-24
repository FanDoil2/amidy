package com.example.sortowanie;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private EditText elementCountEditText;
    private Button startButton;
    private ProgressBar progressBar;
    private SortView sortView;
    private Handler uiHandler;
    private ExecutorService executorService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elementCountEditText = findViewById(R.id.elementCount);
        startButton = findViewById(R.id.startButton);
        progressBar = findViewById(R.id.progressBar);
        sortView = findViewById(R.id.sortView);

        uiHandler = new Handler(Looper.getMainLooper());
        executorService = Executors.newSingleThreadExecutor();

        startButton.setOnClickListener(v -> startSorting());
    }

    private void startSorting() {
        int elementCount = Integer.parseInt(elementCountEditText.getText().toString());
        int[] array = new int[elementCount];

        for (int i = 0; i < elementCount; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        progressBar.setVisibility(View.VISIBLE);
        sortView.setArray(array);

        executorService.execute(() -> {
            bubbleSort(array);
            uiHandler.post(() -> {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Sortowanie zakończone", Toast.LENGTH_SHORT).show();
                sortView.setHighlightIndex(-1);
            });
        });
    }

    private void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                int finalJ = j;
                uiHandler.post(() -> drawArray(array, finalJ));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void drawArray(int[] array, int highlightIndex) {
        sortView.setArray(array);
        sortView.setHighlightIndex(highlightIndex);
    }
}
