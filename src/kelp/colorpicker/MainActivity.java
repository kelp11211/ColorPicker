package kelp.colorpicker;

import java.util.Locale;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView color_board, description, red_info, green_info, blue_info;
	private SeekBar red_bar, green_bar, blue_bar;
	private int red_value, green_value, blue_value;
	private String red_hex = "00", green_hex="00", blue_hex="00";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setColorDescription();
    }
    // initialize views that will be used in the activity
    private void initializeViews() {
    	// color_board, which is used to show the color
    	color_board = (TextView) findViewById(R.id.color_board);
    	// description, which is used to print the RGB hex value
    	description = (TextView) findViewById(R.id.color_description);
    	// red_info, which is used to print the current value of red color
    	red_info= (TextView) findViewById(R.id.seekbar_red_info);
    	red_info.setText("R" + getFormattedIntValue(0));
    	// green_info, which is used to print the current value of green color
    	green_info= (TextView) findViewById(R.id.seekbar_green_info);
    	green_info.setText("G" + getFormattedIntValue(0));
    	// blue_info, whitch is used to print the current value of blue color
    	blue_info= (TextView) findViewById(R.id.seekbar_blue_info);
    	blue_info.setText("B" + getFormattedIntValue(0));
    	// red color seekbar
    	red_bar = (SeekBar) findViewById(R.id.seekbar_red);
    	red_bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				red_info.setText("R" + getFormattedIntValue(progress));
				red_value = progress;
				red_hex = getFormattedHexValue(progress);
				setColorDescription();
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
			
    	});
    	// green color seekbar
    	green_bar = (SeekBar) findViewById(R.id.seekbar_green);
    	green_bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				green_info.setText("G" + getFormattedIntValue(progress));
				green_value = progress;
				green_hex = getFormattedHexValue(progress);
				setColorDescription();
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
			
    	});
    	// blue color seekbar
    	blue_bar = (SeekBar) findViewById(R.id.seekbar_blue);
    	blue_bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				blue_info.setText("B" + getFormattedIntValue(progress));
				blue_value = progress;
				blue_hex = getFormattedHexValue(progress);
				setColorDescription();
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
			
    	});
    }
    // convert the decimal value to hex value with leading zero
    private String getFormattedHexValue(int value) {
    	String val = Integer.toHexString(value);
		return ("00"+val).substring(val.length()).toUpperCase(Locale.TAIWAN);
    }
    // add leading spaces to decimal value
    private String getFormattedIntValue(int value) {
    	String val = String.valueOf(value);
    	return ("    "+val).substring(val.length()).toUpperCase(Locale.TAIWAN);
    }
    // change the color of color_board background and print the RGB hex value of current one
    private void setColorDescription() {
    	color_board.setBackgroundColor(Color.rgb(red_value, green_value, blue_value));
    	description.setText("RGB " + red_hex + green_hex + blue_hex);
    }
}
