package edu.itstep.pizzeria.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.itstep.pizzeria.R;
import edu.itstep.pizzeria.classes.Pizza;
import edu.itstep.pizzeria.classes.PizzaConstants;

public class OrderDetailsActivity extends AppCompatActivity {
    private Pizza pizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        getPizzaFromIntent();
        pizza.calculatePrice();

        setPizzaProperty(R.id.tvPizzaSize, pizza.getSize());
        setPizzaProperty(R.id.tvPizzaTitle, pizza.getTitle());
        setPizzaProperty(R.id.tvExtraIngredients, pizza.getExtraIngredients());
        setPizzaProperty(R.id.tvPizzaPrice, String.valueOf(pizza.getPrice()));

        Button btnChangePizza = findViewById(R.id.btnChangePizza);
        btnChangePizza.setOnClickListener(this::ShowSelectPizzaActivity);

        Button btnChangeIngredients = findViewById(R.id.btnChangeIngredients);
        btnChangeIngredients.setOnClickListener(this::showExtraIngredientsActivity);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        intent.putExtra(Pizza.class.getSimpleName(), pizza);
        intent.putExtra(PizzaConstants.REQUEST_CODE_KEY, requestCode);
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (data != null) {
                pizza = (Pizza) data.getSerializableExtra(Pizza.class.getSimpleName());
            }
        }

        switch (requestCode) {
            case PizzaConstants.REQUEST_CODE_SELECT_PIZZA:
                setPizzaProperty(R.id.tvPizzaSize, pizza.getSize());
                setPizzaProperty(R.id.tvPizzaTitle, pizza.getTitle());
                break;
            case PizzaConstants.REQUEST_CODE_EXTRA_INGREDIENTS:
                setPizzaProperty(R.id.tvExtraIngredients, pizza.getExtraIngredients());
                break;
        }

        pizza.calculatePrice();
        setPizzaProperty(R.id.tvPizzaPrice, String.valueOf(pizza.getPrice()));
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

    private void getPizzaFromIntent() {
        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            pizza = (Pizza) arguments.getSerializable(Pizza.class.getSimpleName());
        }
    }

    private void setPizzaProperty(int tvId, String property) {
        TextView tvProperty = findViewById(tvId);
        tvProperty.setText(property);
    }

    private void ShowSelectPizzaActivity(View view) {
        Intent intent = new Intent(this, SelectPizzaActivity.class);
        startActivityForResult(intent, PizzaConstants.REQUEST_CODE_SELECT_PIZZA);
    }

    private void showExtraIngredientsActivity(View view) {
        Intent intent = new Intent(this, ExtraIngredientsActivity.class);
        startActivityForResult(intent, PizzaConstants.REQUEST_CODE_EXTRA_INGREDIENTS);
    }
}