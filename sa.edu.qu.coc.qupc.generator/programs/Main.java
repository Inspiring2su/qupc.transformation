import java.io.FileWriter;
import java.io.IOException;
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
			Int[][][] Ms={ { { 10, 20, 30 }, { 40, 50, 60 }, { 70, 80, 90 } }, { { 10, 20, 10 }, { 50, 40, 20 } }, { { 90, 80, 20 }, { 70, 60, 30 }, { 50, 40, 60 }, { 10, 20, 10 } }, { { 90, 80, 20 }, { 70, 60, 30 }, { 50, 10, 60 }, { 30, 20, 40 } }, { { 90, 80, 20 }, { 70, 60, 30 }, { 50, 40, 60 }, { 10, 20, 10 } }, { { 90, 80, 20 }, { 70, 60, 30 }, { 50, 40, 60 }, { 10, 20, 10 } }, { { 90, 80, 20 }, { 70, 60, 30 }, { 50, 40, 60 }, { 10, 20, 10 } }, { { 90, 80, 20 }, { 70, 60, 30 }, { 50, 40, 60 }, { 10, 20, 10 } } };
			Int[][] manys={ { 1, 2, 1 }, { 1, 1 }, { 0, 1, 2, 3 }, { 0, 1, 2, 3 },{ 1, 0, 3, 2 }, { 1, 1, 1, 1 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 } };
			Int[] expected={ 180, 70, 170, 150, 190, 210, 70, 0 };
	}
}