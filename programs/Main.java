//package sa.edu.qu.qupc.marks;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import org.json.simple.JSONArray;
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
			int[][][] tests={ {{1, 0, 1, 0, 0},{1, 0, 1, 1, 1},{1, 1, 1, 1, 1},{1, 0, 0, 1, 0}}, {{0, 0, 0, 1},{1, 1, 0, 1},{1, 1, 1, 1},{0, 0, 0, 0}}, {{1, 1, 1},{1, 0, 1},{1, 1, 1}}, {{1, 0, 1, 1, 1},{1, 1, 1, 1, 1},{0, 1, 1, 1, 1},{1, 1, 1, 1, 1},{1, 1, 1, 1, 1}}, {{1, 1, 1},{1, 1, 1},{1, 1, 1},{1, 1, 1},{1, 1, 1}}, {{1, 0, 1, 0, 0},{0, 0, 1, 1, 1},{1, 1, 1, 1, 1},{1, 0, 0, 1, 0}}, {{1, 0},{0, 1}}, {{0, 0},{0, 0}}, {{1, 1, 1, 1, 1, 1, 1},{1, 1, 1, 1, 1, 1, 1},{1, 1, 1, 1, 1, 1, 1},{1, 1, 1, 1, 1, 1, 1},{1, 1, 1, 1, 1, 1, 1},{1, 1, 1, 1, 1, 1, 1}}, {{0}}};
			int[] expected= {6, 4, 3, 16, 15, 6, 1, 0, 42, 0};
		JSONObject mainJsonObj = new JSONObject();
		for (int i = 0; i < tests.length; i++) {
			JSONObject entryJsonObj = new JSONObject();
			MaximalSquareAreaFinder obj = new MaximalSquareAreaFinder();
			int res = obj.getMaximalSquareArea(tests[i]);
			StringBuilder str = new StringBuilder();			
			for (int j=0; j<tests[i].length; j++) {
				str.append(String.format("%s\n",Arrays.toString(tests[i][j])));
			}
			entryJsonObj.put(INPUT_KEY, String.format("%s", str)); 
			entryJsonObj.put(EX_OUTPUT_KEY, String.format("%d",expected[i]));
			entryJsonObj.put(ACT_OUTPUT_KEY, String.format("%d", res));
			if (res == expected[i])
				entryJsonObj.put(STATUS_KEY, PASSED_KEY);
			else
				entryJsonObj.put(STATUS_KEY, FAILED_KEY);

			mainJsonObj.put("Test " + (i + 1), entryJsonObj);
		}

		try {
			FileWriter file = new FileWriter("./Main.output.json");
			String jsonString = JSONValue.toJSONString(mainJsonObj);
			file.write(jsonString);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
