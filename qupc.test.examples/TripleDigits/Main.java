package sa.edu.qu.qupc.formatter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Main {
	public static final String TEST_KEY = "Test ";
	public static final String INPUT_KEY = "Inputs";
	public static final String EX_OUTPUT_KEY = "Expected output";
	public static final String ACT_OUTPUT_KEY = "Actual output";
	public static final String STATUS_KEY = "Status";
	public static final String PASSED_KEY = "PASSED";
	public static final String FAILED_KEY = "FAILED";
	public static final String JSONFILE_NAME_KEY = "Main.output.json";

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// oracle tests
		int[][] tests = { { 2, 2, 8 }, { 2, 3, 8 }, { 22, 33, 44 }, { 3, 5, 7 }, { 4, 7, 32 }, { 3, 2, 50 }, { 12, 6, 470 }, { 999999999, 128, 1000000 } };
		// int[][] tests = { { 999999999, 128, 1000000 } };
		String expected[] = { "0.500", "001.000", "004.534", "034.714", "512.000", "0.180", "353.157", "000.000" };

		JSONObject jsonObj = new JSONObject();
		for (int i = 0; i < tests.length; i++) {
			JSONObject entryJsonObj = new JSONObject();
			TripleDigits obj = new TripleDigits();
			String res = obj.calculate(tests[i][0], tests[i][1], tests[i][2]);

			entryJsonObj.put(INPUT_KEY, String.format("%s", Arrays.toString(tests[i])));
			entryJsonObj.put(EX_OUTPUT_KEY, expected[i]);
			entryJsonObj.put(ACT_OUTPUT_KEY, res);

			if (res.equals(expected[i]))
				entryJsonObj.put(STATUS_KEY, PASSED_KEY);
			else
				entryJsonObj.put(STATUS_KEY, FAILED_KEY);

			jsonObj.put(TEST_KEY + (i + 1), entryJsonObj);
		}

		try {
			FileWriter file = new FileWriter(JSONFILE_NAME_KEY);
			String jsonString = JSONValue.toJSONString(jsonObj);
			file.write(jsonString);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
