
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.util.Arrays;


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
		int[][][] tests = {
        {	{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}},
        {  	{2, 0, 0},
			{0, 2, 0},
			{0, 0, 2}},
        {   {3, 5},
			{8, 2}},
        {  	{1, 0, 0, 0},
			{0, 1, 0, 0},
			{0, 0, 1, 0},
			{0, 0, 0, 1}},
        {   {9}},
        {  	{1, 2, 3, 4},
        	{5, 6, 7, 8},
        	{9, 10, 11, 12},
        	{13, 14, 15, 16}},
        {   {5, 0, 0, 0, 0},
			{0, 5, 0, 0, 0},
			{0, 0, 5, 0, 0},
			{0, 0, 0, 5, 0},
			{0, 0, 0, 0, 5}},
        {   {1, 0, 0},
			{0, 2, 0},
			{0, 0, 3}},
        {  	{10, -2},
			{-3, 20}},
        {   {1, 2},
        	{3, 4}}
    };
		int[] expected = { 15, 6, 5, 4, 9, 34, 25, 6, 30, 5};

		JSONObject mainJsonObj = new JSONObject();
		for (int i = 0; i < tests.length; i++) {
			JSONObject entryJsonObj = new JSONObject();

			MatrixDiagonalSum obj = new MatrixDiagonalSum();
			int res = obj.getMainDiagonalSum(tests[i]);

			StringBuilder str = new StringBuilder();			
			for (int j=0; j<tests[i].length; j++) {
				str.append(String.format("%s\n",Arrays.toString(tests[i][j])));
			}
			entryJsonObj.put(INPUT_KEY, String.format("%s", str));
			entryJsonObj.put(EX_OUTPUT_KEY, String.format("%d", expected[i]));
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
