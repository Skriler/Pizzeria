package edu.itstep.pizzeria.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import edu.itstep.pizzeria.R;
import edu.itstep.pizzeria.classes.Pizza;
import edu.itstep.pizzeria.classes.PizzaConstants;

public class SelectPizzaActivity extends AppCompatActivity {
    private final String[] pizzaSizes = {
            PizzaConstants.SMALL_PIZZA,
            PizzaConstants.MEDIUM_PIZZA,
            PizzaConstants.BIG_PIZZA
    };
    private final String[] pizzaTitles = {
            PizzaConstants.MARGHERITA_PIZZA,
            PizzaConstants.PEPPERONI_PIZZA,
            PizzaConstants.BBQ_CHICKEN_PIZZA,
            PizzaConstants.HAWAIIAN_PIZZA,
            PizzaConstants.MEAT_LOVERS_PIZZA
    };

    Pizza pizza;

    private Spinner spSize;
    private Spinner spTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_pizza);

        getPizzaFromIntentOrCreate();

        createSpinnersLists();

        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this::showNextActivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actions_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.open_comments) {
            Intent intent = new Intent(this, CommentListActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void getPizzaFromIntentOrCreate() {
        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            pizza = (Pizza) arguments.getSerializable(Pizza.class.getSimpleName());
        }
        else {
            pizza = new Pizza();
        }
    }

    private void createSpinnersLists() {
        spSize = findViewById(R.id.spSize);
        spTitle = findViewById(R.id.spTitle);

        ArrayAdapter<String> adapterSize = new ArrayAdapter<>(this, R.layout.custom_spinner_item, pizzaSizes);
        adapterSize.setDropDownViewResource(R.layout.custom_spinner_item);
        ArrayAdapter<String> adapterTitle = new ArrayAdapter<>(this, R.layout.custom_spinner_item, pizzaTitles);
        adapterTitle.setDropDownViewResource(R.layout.custom_spinner_item);

        spSize.setAdapter(adapterSize);
        spTitle.setAdapter(adapterTitle);

        spSize.setSelection(adapterSize.getPosition(pizza.getSize()));
        spTitle.setSelection(adapterTitle.getPosition(pizza.getTitle()));
    }

    private void showNextActivity(View view) {
        pizza.setSize(spSize.getSelectedItem().toString());
        pizza.setTitle(spTitle.getSelectedItem().toString());

        Bundle arguments = getIntent().getExtras();
        if (arguments != null && arguments.containsKey(PizzaConstants.REQUEST_CODE_KEY)) {
            if (arguments.getInt(PizzaConstants.REQUEST_CODE_KEY) == PizzaConstants.REQUEST_CODE_SELECT_PIZZA) {
                Intent intent = new Intent();
                intent.putExtra(Pizza.class.getSimpleName(), pizza);
                setResult(RESULT_OK, intent);
            }
        } else {
            Intent intent = new Intent(this, ExtraIngredientsActivity.class);
            intent.putExtra(Pizza.class.getSimpleName(), pizza);
            startActivity(intent);
        }
        finish();
    }
}