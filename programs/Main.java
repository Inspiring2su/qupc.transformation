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
			int[][][] Ms={ { { 10, 20, 30 }, { 40, 50, 60 }, { 70, 80, 90 } }, { { 10, 20, 10 }, { 50, 40, 20 } }, { { 90, 80, 20 }, { 70, 60, 30 }, { 50, 40, 60 }, { 10, 20, 10 } }, { { 90, 80, 20 }, { 70, 60, 30 }, { 50, 10, 60 }, { 30, 20, 40 } }, { { 90, 80, 20 }, { 70, 60, 30 }, { 50, 40, 60 }, { 10, 20, 10 } }, { { 90, 80, 20 }, { 70, 60, 30 }, { 50, 40, 60 }, { 10, 20, 10 } }, { { 90, 80, 20 }, { 70, 60, 30 }, { 50, 40, 60 }, { 10, 20, 10 } }, { { 90, 80, 20 }, { 70, 60, 30 }, { 50, 40, 60 }, { 10, 20, 10 } } };
			int[][] manys={ { 1, 2, 1 }, { 1, 1 }, { 0, 1, 2, 3 }, { 0, 1, 2, 3 },{ 1, 0, 3, 2 }, { 1, 1, 1, 1 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 } };
			int[] expected={ 180, 70, 170, 150, 190, 210, 70, 0 };

		
		JSONObject mainJsonObj = new JSONObject();
		for (int i = 0; i < Ms.length; i++) {

			JSONObject entryJsonObj = new JSONObject();

			Marking obj = new Marking();
			int res = obj.totalBestMarks(Ms[i],manys[i]);
			
            
			for (int i = 0; i < inputs.length; i++) {
            StringBuilder str = new StringBuilder();
            if (detailsSize > 2) {
                for (int j = 0; j < inputs[i].length; j++) {
                    str.append(Arrays.toString(inputs[i][j]));
                    if (j < inputs[i].length - 1) {
                        str.append("; "); 
            }
        }
    } else {
        // Handling a single list or a simple variable
        if (inputs[i].getClass().getComponentType().isArray()) {
            str.append(Arrays.toString(inputs[i][0])); // Assume single entry in 2D array
        } else {
            str.append(Arrays.toString(inputs[i]));
        }
    }

			entryJsonObj.put(INPUT_KEY, String.format("%s", str));
			entryJsonObj.put(EX_OUTPUT_KEY, String.format("%d", expected[i]));
			entryJsonObj.put(ACT_OUTPUT_KEY, String.format("%d", res));

			if (res == expected[i]) entryJsonObj.put(STATUS_KEY, PASSED_KEY);
			else entryJsonObj.put(STATUS_KEY, FAILED_KEY);

			mainJsonObj.put("Test " + (i + 1), entryJsonObj);
		}
		
		try {
			FileWriter file = new FileWriter(JSONFILE_NAME_KEY);
			String jsonString = JSONValue.toJSONString(mainJsonObj);
			file.write(jsonString);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}