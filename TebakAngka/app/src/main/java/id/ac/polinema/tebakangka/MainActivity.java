package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	private EditText numberText;
	private Button guessButton, resetButton;
	int min = 1;
	int max = 100;
	int randomNumber = initRandomNumber();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		numberText = findViewById(R.id.number_input);
		guessButton = findViewById(R.id.guess_button);
		resetButton = findViewById(R.id.reset_button);

		resetButton.setEnabled(false);
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		int random = (int) (Math.random() * ((max - min) + 1)) + min;
		return random;
	}

	public void handleGuess(View view) {
		if (numberText.getText().toString().equals("")) {
			Toast.makeText(this, "Isilah tebakan anda!", Toast.LENGTH_SHORT).show();
		} else {
			int guessNumber = Integer.parseInt(numberText.getText().toString());

			if (guessNumber > max) {
				Toast.makeText(this, "Tebakan anda lebih dari 100!", Toast.LENGTH_SHORT).show();
			} else if (guessNumber < min) {
				Toast.makeText(this, "Tebakan anda kurang dari 1!", Toast.LENGTH_SHORT).show();
			} else if (guessNumber > randomNumber) {
				Toast.makeText(this, "Tebakan anda terlalu besar!", Toast.LENGTH_SHORT).show();
			} else if (guessNumber < randomNumber) {
				Toast.makeText(this, "Tebakan anda terlalu kecil!", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this, "Tebakan anda benar!", Toast.LENGTH_SHORT).show();
				guessButton.setEnabled(false);
				numberText.setEnabled(false);
				resetButton.setEnabled(true);
			}
		}
	}

	public void handleReset(View view) {
		numberText.setText("");
		guessButton.setEnabled(true);
		numberText.setEnabled(true);
		randomNumber = initRandomNumber();
		resetButton.setEnabled(false);
	}
}


