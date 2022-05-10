package edu.itstep.pizzeria.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

import edu.itstep.pizzeria.R;
import edu.itstep.pizzeria.classes.Pizza;
import edu.itstep.pizzeria.classes.PizzaConstants;

public class ExtraIngredientsActivity extends AppCompatActivity {
    private Pizza pizza;

    private ArrayList<CheckBox> cbGroupIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_ingredients);

        getPizzaFromIntent();
        getCbGroupIngredients();
        setCheckedSelectedIngredients();

        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this::showNextActivity);
    }

    private void getPizzaFromIntent() {
        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            pizza = (Pizza) arguments.getSerializable(Pizza.class.getSimpleName());
        }
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

    private void getCbGroupIngredients() {
        cbGroupIngredients = new ArrayList<>();
        cbGroupIngredients.add(findViewById(R.id.cbBroccoli));
        cbGroupIngredients.add(findViewById(R.id.cbPotato));
        cbGroupIngredients.add(findViewById(R.id.cbMushroom));
        cbGroupIngredients.add(findViewById(R.id.cbBlackOlives));
        cbGroupIngredients.add(findViewById(R.id.cbAnchovies));
        cbGroupIngredients.add(findViewById(R.id.cbEggplant));
        cbGroupIngredients.add(findViewById(R.id.cbCapsicum));
    }

    private void showNextActivity(View view) {
        addSelectedIngredients();

        Bundle arguments = getIntent().getExtras();
        if (arguments != null && arguments.containsKey(PizzaConstants.REQUEST_CODE_KEY)) {
            if (arguments.getInt(PizzaConstants.REQUEST_CODE_KEY) == PizzaConstants.REQUEST_CODE_EXTRA_INGREDIENTS) {
                Intent intent = new Intent();
                intent.putExtra(Pizza.class.getSimpleName(), pizza);
                setResult(RESULT_OK, intent);
            }
        } else {
            Intent intent = new Intent(this, OrderDetailsActivity.class);
            intent.putExtra(Pizza.class.getSimpleName(), pizza);
            startActivity(intent);
        }

        finish();
    }

    private void addSelectedIngredients() {
        if (pizza == null)
            return;

        String extraIngredients = "";
        for (CheckBox cbIngredient : cbGroupIngredients) {
            if (!cbIngredient.isChecked())
                continue;

            extraIngredients = extraIngredients.concat(cbIngredient.getText().toString().concat(", "));
        }

        if (extraIngredients.length() != 0)
            extraIngredients = extraIngredients.substring(0, extraIngredients.length() - 2);

        pizza.setExtraIngredients(extraIngredients);
    }

    private void setCheckedSelectedIngredients() {
        if (pizza.getExtraIngredients() == null)
            return;

        String[] selectedIngredients = pizza.getExtraIngredients().split(", ");

        for (CheckBox cbIngredient : cbGroupIngredients) {
            String cbTitle = cbIngredient.getText().toString();

            for (String ingredient : selectedIngredients) {
                if (!ingredient.equals(cbTitle))
                    continue;

                cbIngredient.setChecked(true);
            }
        }
    }
}