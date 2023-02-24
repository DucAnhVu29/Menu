package com.example.optionmenudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button popup_button;
    Button context_button;
    ConstraintLayout main_activity_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        popup_button = findViewById(R.id.popup_button);
        context_button = findViewById(R.id.context_button);
        main_activity_screen = findViewById(R.id.main_activity_screen);

        popup_button.setOnClickListener(v -> {
            showPopupMenu();
        });

        registerForContextMenu(context_button);
    }

    public void showPopupMenu(){
        PopupMenu popupMenu = new PopupMenu(this, popup_button);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()){
                case R.id.setting:
                    Toast.makeText(this, "You choose setting", Toast.LENGTH_LONG).show();
                case R.id.share:
                    Toast.makeText(this, "You choose share", Toast.LENGTH_LONG).show();
                case R.id.search:
                    Toast.makeText(this, "You choose search", Toast.LENGTH_LONG).show();
            }
            return false;
        });
        popupMenu.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v ,menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cyan:
                main_activity_screen.setBackgroundColor(Color.CYAN);
                break;
            case R.id.magenta:
                main_activity_screen.setBackgroundColor(Color.MAGENTA);
                break;
            case R.id.yellow:
                main_activity_screen.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.reset:
                main_activity_screen.setBackgroundColor(Color.WHITE);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting:
                Toast.makeText(this, "You choose setting", Toast.LENGTH_LONG).show();
                break;
            case R.id.share:
                Toast.makeText(this, "You choose share", Toast.LENGTH_LONG).show();
                break;
            case R.id.search:
                Toast.makeText(this, "You choose search", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}